
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
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
 * 考勤
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuqin")
public class ChuqinController {
    private static final Logger logger = LoggerFactory.getLogger(ChuqinController.class);

    @Autowired
    private ChuqinService chuqinService;


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
        PageUtils page = chuqinService.queryPage(params);

        //字典表数据转换
        List<ChuqinView> list =(List<ChuqinView>)page.getList();
        for(ChuqinView c:list){
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
        ChuqinEntity chuqin = chuqinService.selectById(id);
        if(chuqin !=null){
            //entity转view
            ChuqinView view = new ChuqinView();
            BeanUtils.copyProperties( chuqin , view );//把实体数据重构到view中

                //级联表
                YuangongEntity yuangong = yuangongService.selectById(chuqin.getYuangongId());
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
    public R save(@RequestBody ChuqinEntity chuqin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuqin:{}",this.getClass().getName(),chuqin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            chuqin.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChuqinEntity> queryWrapper = new EntityWrapper<ChuqinEntity>()
            .eq("yuangong_id", chuqin.getYuangongId())
            .eq("chuqin_types", chuqin.getChuqinTypes())
            .eq("overtimeNumber", chuqin.getOvertimeNumber())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuqinEntity chuqinEntity = chuqinService.selectOne(queryWrapper);
        if(chuqinEntity==null){
            chuqin.setInsertTime(new Date());
            chuqin.setCreateTime(new Date());
            chuqinService.insert(chuqin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuqinEntity chuqin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chuqin:{}",this.getClass().getName(),chuqin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            chuqin.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ChuqinEntity> queryWrapper = new EntityWrapper<ChuqinEntity>()
            .notIn("id",chuqin.getId())
            .andNew()
            .eq("yuangong_id", chuqin.getYuangongId())
            .eq("chuqin_types", chuqin.getChuqinTypes())
            .eq("overtimeNumber", chuqin.getOvertimeNumber())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(chuqin.getInsertTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuqinEntity chuqinEntity = chuqinService.selectOne(queryWrapper);
        if(chuqinEntity==null){
            chuqinService.updateById(chuqin);//根据id更新
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
        chuqinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ChuqinEntity> chuqinList = new ArrayList<>();//上传的东西
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
                            ChuqinEntity chuqinEntity = new ChuqinEntity();
//                            chuqinEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            chuqinEntity.setOnTime(new Date(data.get(0)));          //上班打卡时间 要改的
//                            chuqinEntity.setDownTime(new Date(data.get(0)));          //下班打卡时间 要改的
//                            chuqinEntity.setChuqinTypes(Integer.valueOf(data.get(0)));   //打卡类型 要改的
//                            chuqinEntity.setOvertimeNumber(Integer.valueOf(data.get(0)));   //加班时间(小时) 要改的
//                            chuqinEntity.setInsertTime(date);//时间
//                            chuqinEntity.setCreateTime(date);//时间
                            chuqinList.add(chuqinEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chuqinService.insertBatch(chuqinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
     * 打卡
     */
    @RequestMapping("/clockIn")
    public R clockIn(String flag, HttpServletRequest request){
        logger.debug("clockIn方法:,,Controller:{},,flag:{}",this.getClass().getName(),flag);
        try {
            Integer id = (Integer)request.getSession().getAttribute("userId");
            String role = String.valueOf(request.getSession().getAttribute("role"));
            if(StringUtil.isEmpty(role) || "管理员".equals(role)){
                return R.error(511,"没有打卡权限");
            }
            Date d = new Date();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date = format1.format(d);
            List<ChuqinEntity> chuqinList = new ArrayList<ChuqinEntity>();//要生成的list数据
            List<String> s = new ArrayList<>();
            s.add("yuangong_id+0");
            Wrapper<ChuqinEntity> queryWrapper3 = new EntityWrapper<ChuqinEntity>().eq("yuangong_id",id).orderDesc(s);
            List<ChuqinEntity> oldChuqinList = chuqinService.selectList(queryWrapper3);
            if("1".equals(flag)){
                //上班卡
                Date date1 = new Date();
                date1.setHours(8);
                date1.setMinutes(0);
                date1.setSeconds(0);
                //上班打卡
                //新增前先查看当前用户最大打卡时间

                if(oldChuqinList != null && oldChuqinList.size()>0){
                    ChuqinEntity entity = oldChuqinList.get(0);
                    Date todayTime = entity.getInsertTime();//获取出勤表最大出勤
                    String today = format1.format(todayTime);
                    //把日期加一天
                    Calendar   calendar = new GregorianCalendar();
                    calendar.setTime(todayTime);
                    calendar.add(calendar.DATE,1);
                    String newToday = format1.format(calendar.getTime());
                    if(date.equals(today)){
                        return R.error(511,"已经打过上班卡了");
                    }else if(!date.equals(newToday)){//当天日期 不是出勤最大日期加一天的话   就是补充缺勤日期
                        chuqinList = this.getQueQin(d, format1, today, id);
                    }

                    if(chuqinList !=null && chuqinList.size() >0){
                        chuqinService.insertBatch(chuqinList);
                    }


                    //插入当天的上班卡
                    ChuqinEntity chuqin = new ChuqinEntity();
                    chuqin.setOnTime(d);
                    if(d.compareTo(date1)>0){//当前时间d 大于规定时间date1
                        chuqin.setChuqinTypes(6);//设置为迟到
                    }else if(d.compareTo(date1)<=0){//当前时间d 小于等于规定时间date1
                        chuqin.setChuqinTypes(3);//设置为未打下班卡
                    }
                    chuqin.setCreateTime(d);
                    chuqin.setInsertTime(format1.parse(date));
                    chuqin.setYuangongId(id);
                    chuqinService.insert(chuqin);
                }else{
                    //第一次打卡
                    ChuqinEntity chuqin = new ChuqinEntity();
                    chuqin.setOnTime(d);
                    if(d.compareTo(date1)>0){//当前时间d 大于规定时间date1
                        chuqin.setChuqinTypes(6);//设置为迟到
                    }else if(d.compareTo(date1)<=0){//当前时间d 小于等于规定时间date1
                        chuqin.setChuqinTypes(3);//设置为未打下班卡
                    }
                    chuqin.setCreateTime(d);
                    chuqin.setInsertTime(format1.parse(date));
                    chuqin.setYuangongId(id);
                    chuqinService.insert(chuqin);
                }

            }else if("2".equals(flag)){
                //下班打卡的地方
                Date date1 = new Date();
                date1.setHours(19);
                date1.setMinutes(00);
                date1.setSeconds(0);
                Date date2 = new Date();
                date2.setHours(18);
                date2.setMinutes(00);
                date2.setSeconds(0);
                //下班打卡
                if(oldChuqinList!=null){//不是第一次打卡
                    //查询当前用户是否生成了上班打卡
                    Wrapper<ChuqinEntity> queryWrapper = new EntityWrapper<ChuqinEntity>().eq("yuangong_id",id).eq("insert_time",date).orderDesc(s);
                    ChuqinEntity chuqinEntity = chuqinService.selectOne(queryWrapper);
                    if(chuqinEntity !=null){//生成了上班打卡
                        chuqinEntity.setDownTime(d);
                        if("6".equals(String.valueOf(chuqinEntity.getChuqinTypes()))){
                        }else if(d.compareTo(date1)>0){//当前时间d 大于规定时间   加班
                            int hours = d.getHours();
                            int i = hours - 19+1;
                            if(i>0){
                                chuqinEntity.setOvertimeNumber(i);
                            }
                            chuqinEntity.setChuqinTypes(5);//设置为迟到
                        }else if(d.compareTo(date2)<0){//当前时间d 小于等于规定时间 早退
                            chuqinEntity.setChuqinTypes(7);//设置为未打下班卡
                        }else{
                            chuqinEntity.setChuqinTypes(1);
                        }
                        chuqinService.updateById(chuqinEntity);
                    }else{
                        //当天上午没有生成上班打卡,要防止用户昨天及之前没有生成打卡记录
                        Wrapper<ChuqinEntity> queryWrapper1 = new EntityWrapper<ChuqinEntity>().eq("yuangong_id",id).orderDesc(s);
                        List<ChuqinEntity> list = chuqinService.selectList(queryWrapper1);
                        if(list != null && list.size()>0){
                            ChuqinEntity entity = list.get(0);
                            Date todayTime = entity.getInsertTime();//获取出勤表最大出勤
                            String today = format1.format(todayTime);
                            Calendar calendar = new GregorianCalendar();
                            calendar.setTime(todayTime);
                            calendar.add(calendar.DATE,1);
                            String newToday = format1.format(calendar.getTime());
                            if(date.equals(today)){
                                //昨天id+1  等于今天的话  就是直接新增下午打卡
                                ChuqinEntity chuqin = new ChuqinEntity();
                                chuqin.setDownTime(d);
                                chuqin.setChuqinTypes(2);
                                chuqinService.insert(chuqin);
                            }else if(!date.equals(newToday)){//当天日期 不是出勤最大日期加一天的话   就是补充缺勤日期
                                chuqinList = this.getQueQin(d, format1, today, id);
                            }

                            if(chuqinList !=null && chuqinList.size() >0){
                                chuqinService.insertBatch(chuqinList);
                            }
                        }
                    }
                }else{
                    //第一次打卡
                    ChuqinEntity chuqin = new ChuqinEntity();
                    chuqin.setDownTime(d);
                    chuqin.setChuqinTypes(2);
                    chuqinService.insert(chuqin);
                }
            }else {
                return R.error(511,"未知错误");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return R.ok();
    }

    /**
     * 补充缺勤和未打的情况
     * @param d   当前日期
     * @param format1 "yyyy-MM-dd"
     * @param newToday 数据库存的最大打卡日期 加一天
     * @param id    打卡人id
     * @return
     * @throws ParseException
     */
    public static  List<ChuqinEntity> getQueQin(Date d,SimpleDateFormat format1,String newToday,Integer id) throws ParseException {
        List<ChuqinEntity> list = new ArrayList<>();
        // 返回的日期集合
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dateFormat.parse(newToday);//缺勤那天
        Calendar   calendar = new GregorianCalendar();
        calendar.setTime(d);
        calendar.add(calendar.DATE,-1); //当前时间减去一天，即一天前的时间
        Date end = dateFormat.parse(format1.format(calendar.getTime()));

        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
        while (tempStart.before(tempEnd)) {
            ChuqinEntity chuqinEntity = new ChuqinEntity();
            chuqinEntity.setYuangongId(id);
            chuqinEntity.setInsertTime(tempStart.getTime());
            chuqinEntity.setCreateTime(d);
            chuqinEntity.setChuqinTypes(4);
            list.add(chuqinEntity);
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return list;
    }





}
