
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
 * 薪资信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xizi")
public class XiziController {
    private static final Logger logger = LoggerFactory.getLogger(XiziController.class);

    @Autowired
    private XiziService xiziService;


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
        PageUtils page = xiziService.queryPage(params);

        //字典表数据转换
        List<XiziView> list =(List<XiziView>)page.getList();
        for(XiziView c:list){
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
        XiziEntity xizi = xiziService.selectById(id);
        if(xizi !=null){
            //entity转view
            XiziView view = new XiziView();
            BeanUtils.copyProperties( xizi , view );//把实体数据重构到view中

                //级联表
                YuangongEntity yuangong = yuangongService.selectById(xizi.getYuangongId());
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
    public R save(@RequestBody XiziEntity xizi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xizi:{}",this.getClass().getName(),xizi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            xizi.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XiziEntity> queryWrapper = new EntityWrapper<XiziEntity>()
            .eq("yuangong_id", xizi.getYuangongId())
            .eq("xizi_month", xizi.getXiziMonth())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiziEntity xiziEntity = xiziService.selectOne(queryWrapper);
        if(xiziEntity==null){
            xizi.setInsertTime(new Date());
            xizi.setCreateTime(new Date());


            xizi.setXiziShifaMoney(xizi.getXiziJibenMoney()+xizi.getXiziJixiaoMoney()+xizi.getXiziCanyinMoney());
            xiziService.insert(xizi);
            return R.ok();
        }else {
            return R.error(511,"该用户当月已有薪资记录");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiziEntity xizi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xizi:{}",this.getClass().getName(),xizi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            xizi.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XiziEntity> queryWrapper = new EntityWrapper<XiziEntity>()
            .notIn("id",xizi.getId())
            .andNew()
            .eq("yuangong_id", xizi.getYuangongId())
            .eq("xizi_month", xizi.getXiziMonth())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiziEntity xiziEntity = xiziService.selectOne(queryWrapper);
        if(xiziEntity==null){
            xizi.setXiziShifaMoney(xizi.getXiziJibenMoney()+xizi.getXiziJixiaoMoney()+xizi.getXiziCanyinMoney());
            xiziService.updateById(xizi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该用户当月已有薪资记录");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xiziService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<XiziEntity> xiziList = new ArrayList<>();//上传的东西
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
                            XiziEntity xiziEntity = new XiziEntity();
//                            xiziEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            xiziEntity.setXiziName(data.get(0));                    //薪资名称 要改的
//                            xiziEntity.setXiziMonth(data.get(0));                    //月份 要改的
//                            xiziEntity.setXiziJibenMoney(data.get(0));                    //基本工资 要改的
//                            xiziEntity.setXiziJixiaoMoney(data.get(0));                    //绩效工资 要改的
//                            xiziEntity.setXiziCanyinMoney(data.get(0));                    //餐饮补贴 要改的
//                            xiziEntity.setXiziShifaMoney(data.get(0));                    //实发工资 要改的
//                            xiziEntity.setXiziContent("");//照片
//                            xiziEntity.setInsertTime(date);//时间
//                            xiziEntity.setCreateTime(date);//时间
                            xiziList.add(xiziEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xiziService.insertBatch(xiziList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
