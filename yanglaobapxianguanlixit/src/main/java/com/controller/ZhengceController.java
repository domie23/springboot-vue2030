
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
 * 养老政策
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhengce")
public class ZhengceController {
    private static final Logger logger = LoggerFactory.getLogger(ZhengceController.class);

    private static final String TABLE_NAME = "zhengce";

    @Autowired
    private ZhengceService zhengceService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告资讯
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private XiangmuService xiangmuService;//项目
    @Autowired
    private XiangmuCollectionService xiangmuCollectionService;//项目收藏
    @Autowired
    private XiangmuLiuyanService xiangmuLiuyanService;//项目留言
    @Autowired
    private XiangmuYuyueService xiangmuYuyueService;//保险参保
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private ZhengceCollectionService zhengceCollectionService;//养老政策收藏
    @Autowired
    private ZhengceLiuyanService zhengceLiuyanService;//养老政策留言
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        params.put("zhengceDeleteStart",1);params.put("zhengceDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = zhengceService.queryPage(params);

        //字典表数据转换
        List<ZhengceView> list =(List<ZhengceView>)page.getList();
        for(ZhengceView c:list){
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
        ZhengceEntity zhengce = zhengceService.selectById(id);
        if(zhengce !=null){
            //entity转view
            ZhengceView view = new ZhengceView();
            BeanUtils.copyProperties( zhengce , view );//把实体数据重构到view中
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
    public R save(@RequestBody ZhengceEntity zhengce, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhengce:{}",this.getClass().getName(),zhengce.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhengceEntity> queryWrapper = new EntityWrapper<ZhengceEntity>()
            .eq("zhengce_name", zhengce.getZhengceName())
            .eq("zhengce_types", zhengce.getZhengceTypes())
            .eq("zhengce_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhengceEntity zhengceEntity = zhengceService.selectOne(queryWrapper);
        if(zhengceEntity==null){
            zhengce.setZhengceDelete(1);
            zhengce.setInsertTime(new Date());
            zhengce.setCreateTime(new Date());
            zhengceService.insert(zhengce);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhengceEntity zhengce, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhengce:{}",this.getClass().getName(),zhengce.toString());
        ZhengceEntity oldZhengceEntity = zhengceService.selectById(zhengce.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zhengce.getZhengcePhoto()) || "null".equals(zhengce.getZhengcePhoto())){
                zhengce.setZhengcePhoto(null);
        }
        if("".equals(zhengce.getZhengceContent()) || "null".equals(zhengce.getZhengceContent())){
                zhengce.setZhengceContent(null);
        }

            zhengceService.updateById(zhengce);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhengceEntity> oldZhengceList =zhengceService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ZhengceEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZhengceEntity zhengceEntity = new ZhengceEntity();
            zhengceEntity.setId(id);
            zhengceEntity.setZhengceDelete(2);
            list.add(zhengceEntity);
        }
        if(list != null && list.size() >0){
            zhengceService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ZhengceEntity> zhengceList = new ArrayList<>();//上传的东西
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
                            ZhengceEntity zhengceEntity = new ZhengceEntity();
//                            zhengceEntity.setZhengceName(data.get(0));                    //养老政策名称 要改的
//                            zhengceEntity.setZhengceUuidNumber(data.get(0));                    //养老政策编号 要改的
//                            zhengceEntity.setZhengcePhoto("");//详情和图片
//                            zhengceEntity.setZhengceTypes(Integer.valueOf(data.get(0)));   //养老政策类型 要改的
//                            zhengceEntity.setZhengceContent("");//详情和图片
//                            zhengceEntity.setZhengceDelete(1);//逻辑删除字段
//                            zhengceEntity.setInsertTime(date);//时间
//                            zhengceEntity.setCreateTime(date);//时间
                            zhengceList.add(zhengceEntity);


                            //把要查询是否重复的字段放入map中
                                //养老政策编号
                                if(seachFields.containsKey("zhengceUuidNumber")){
                                    List<String> zhengceUuidNumber = seachFields.get("zhengceUuidNumber");
                                    zhengceUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhengceUuidNumber = new ArrayList<>();
                                    zhengceUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhengceUuidNumber",zhengceUuidNumber);
                                }
                        }

                        //查询是否重复
                         //养老政策编号
                        List<ZhengceEntity> zhengceEntities_zhengceUuidNumber = zhengceService.selectList(new EntityWrapper<ZhengceEntity>().in("zhengce_uuid_number", seachFields.get("zhengceUuidNumber")).eq("zhengce_delete", 1));
                        if(zhengceEntities_zhengceUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhengceEntity s:zhengceEntities_zhengceUuidNumber){
                                repeatFields.add(s.getZhengceUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [养老政策编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhengceService.insertBatch(zhengceList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ZhengceView> returnZhengceViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("zhengceYesnoTypes",2);
        PageUtils pageUtils = zhengceCollectionService.queryPage(params1);
        List<ZhengceCollectionView> collectionViewsList =(List<ZhengceCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ZhengceCollectionView collectionView:collectionViewsList){
            Integer zhengceTypes = collectionView.getZhengceTypes();
            if(typeMap.containsKey(zhengceTypes)){
                typeMap.put(zhengceTypes,typeMap.get(zhengceTypes)+1);
            }else{
                typeMap.put(zhengceTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("zhengceTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("zhengceYesnoTypes",2);
            PageUtils pageUtils1 = zhengceService.queryPage(params2);
            List<ZhengceView> zhengceViewList =(List<ZhengceView>)pageUtils1.getList();
            returnZhengceViewList.addAll(zhengceViewList);
            if(returnZhengceViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("zhengceYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = zhengceService.queryPage(params);
        if(returnZhengceViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnZhengceViewList.size();//要添加的数量
            List<ZhengceView> zhengceViewList =(List<ZhengceView>)page.getList();
            for(ZhengceView zhengceView:zhengceViewList){
                Boolean addFlag = true;
                for(ZhengceView returnZhengceView:returnZhengceViewList){
                    if(returnZhengceView.getId().intValue() ==zhengceView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnZhengceViewList.add(zhengceView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnZhengceViewList = returnZhengceViewList.subList(0, limit);
        }

        for(ZhengceView c:returnZhengceViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnZhengceViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zhengceService.queryPage(params);

        //字典表数据转换
        List<ZhengceView> list =(List<ZhengceView>)page.getList();
        for(ZhengceView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhengceEntity zhengce = zhengceService.selectById(id);
            if(zhengce !=null){


                //entity转view
                ZhengceView view = new ZhengceView();
                BeanUtils.copyProperties( zhengce , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZhengceEntity zhengce, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhengce:{}",this.getClass().getName(),zhengce.toString());
        Wrapper<ZhengceEntity> queryWrapper = new EntityWrapper<ZhengceEntity>()
            .eq("zhengce_name", zhengce.getZhengceName())
            .eq("zhengce_uuid_number", zhengce.getZhengceUuidNumber())
            .eq("zhengce_types", zhengce.getZhengceTypes())
            .eq("zhengce_delete", zhengce.getZhengceDelete())
//            .notIn("zhengce_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhengceEntity zhengceEntity = zhengceService.selectOne(queryWrapper);
        if(zhengceEntity==null){
            zhengce.setZhengceDelete(1);
            zhengce.setInsertTime(new Date());
            zhengce.setCreateTime(new Date());
        zhengceService.insert(zhengce);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

