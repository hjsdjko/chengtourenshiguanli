
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 考核信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kaohe")
public class KaoheController {
    private static final Logger logger = LoggerFactory.getLogger(KaoheController.class);

    @Autowired
    private KaoheService kaoheService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YuangongService yuangongService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = kaoheService.queryPage(params);

        //字典表数据转换
        List<KaoheView> list =(List<KaoheView>)page.getList();
        for(KaoheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KaoheEntity kaohe = kaoheService.selectById(id);
        if(kaohe !=null){
            //entity转view
            KaoheView view = new KaoheView();
            BeanUtils.copyProperties( kaohe , view );//把实体数据重构到view中

                //级联表
                YuangongEntity yuangong = yuangongService.selectById(kaohe.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KaoheEntity kaohe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaohe:{}",this.getClass().getName(),kaohe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            kaohe.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<KaoheEntity> queryWrapper = new EntityWrapper<KaoheEntity>()
            .eq("yuangong_id", kaohe.getYuangongId())
            .eq("kaohe_name", kaohe.getKaoheName())
            .eq("kaohe_types", kaohe.getKaoheTypes())
            .eq("kaohe_jieguo_types", kaohe.getKaoheJieguoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoheEntity kaoheEntity = kaoheService.selectOne(queryWrapper);
        if(kaoheEntity==null){
            kaohe.setInsertTime(new Date());
            kaohe.setCreateTime(new Date());
            kaoheService.insert(kaohe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KaoheEntity kaohe, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kaohe:{}",this.getClass().getName(),kaohe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            kaohe.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<KaoheEntity> queryWrapper = new EntityWrapper<KaoheEntity>()
            .notIn("id",kaohe.getId())
            .andNew()
            .eq("yuangong_id", kaohe.getYuangongId())
            .eq("kaohe_name", kaohe.getKaoheName())
            .eq("kaohe_types", kaohe.getKaoheTypes())
            .eq("kaohe_jieguo_types", kaohe.getKaoheJieguoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoheEntity kaoheEntity = kaoheService.selectOne(queryWrapper);
        if(kaoheEntity==null){
            kaoheService.updateById(kaohe);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kaoheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<KaoheEntity> kaoheList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            KaoheEntity kaoheEntity = new KaoheEntity();
//                            kaoheEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            kaoheEntity.setKaoheName(data.get(0));                    //考核名称 要改的
//                            kaoheEntity.setKaoheTypes(Integer.valueOf(data.get(0)));   //考核类型 要改的
//                            kaoheEntity.setKaoheContent("");//照片
//                            kaoheEntity.setKaoheJieguoTypes(Integer.valueOf(data.get(0)));   //考核结果 要改的
//                            kaoheEntity.setInsertTime(date);//时间
//                            kaoheEntity.setCreateTime(date);//时间
                            kaoheList.add(kaoheEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        kaoheService.insertBatch(kaoheList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
