package org.jeecg.modules.rdata.controller;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Workbook;
import org.checkerframework.checker.units.qual.A;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.collapse.CollapseBuilder;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.rdata.entity.*;
import org.jeecg.modules.rdata.service.IInvComService;
import org.jeecg.modules.rdata.service.IInvMainService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.rdata.service.IInvPay2Service;

import org.jeecg.modules.rdata.util.ElasticsearchUtil;
import org.jeecg.modules.rdata.util.EsPage;
import org.jeecg.modules.rdata.util.ExcelUtils;
import org.jeecg.modules.rdata.util.PubUtil;
import org.jeecg.modules.rdata.vo.CheckResurt;
import org.jeecg.modules.rdata.vo.EsCheckResurt;
import org.jeecg.modules.rdata.vo.NIPage;
import org.jeecg.modules.rdata.vo.QueryInvMain;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

/**
 * @Description: 小票主单表
 * @Author: jeecg-boot
 * @Date: 2021-04-23
 * @Version: V1.0
 */
@Api(tags = "小票查询")
@RestController
@RequestMapping("/rdata/invMain")
@Slf4j
public class InvMainController extends JeecgController<InvMain, IInvMainService> {
    @Autowired
    private IInvMainService invMainService;

    @Autowired
    private IInvComService invComService;

    @Autowired
    private IInvPay2Service iInvPay2Service;

    @Autowired
    private RedisUtil redisUtil;






    /**
     * 模糊查询条件_es
     *
     * @param type  判别参数类别 1：收银机号  2：收银员号
     * @param value  参数值
     * @param req
     * @return
     */
    @AutoLog(value = "小票主单表-模糊查询条件_es")
    @ApiOperation(value = "小票主单表-模糊查询条件_es", notes = "小票主单表-模糊查询条件_es")
    @GetMapping(value = "/condition_query_es")
    public Result<?> queryCondition(@RequestParam(name = "storeCode",defaultValue = "1") String storeCode ,
                                    @RequestParam(name = "type",defaultValue = "1") String type ,
                                    @RequestParam(name = "value", defaultValue = "") String value,
                                     HttpServletRequest req) {
        //校验门店编码
        if(Strings.isEmpty(storeCode)){
            //数据库无数据
            return Result.error("请选择门店编码");
        }

//        //获取最大数据版本
//        String ds = PubUtil.getMaxDs("es_inv_main_dd&"+storeCode, redisUtil);
//        if (Strings.isEmpty(ds)) {
//            //数据库无数据
//            return Result.error("数据库无数据");
//        }

        String queryParam = "";
        //根据参数类别获取对应的字段列
        switch (type){
            case "1":
                queryParam = "syjh";
                break;
            case "2":
                queryParam = "syyh";
                break;
            default:
                queryParam = "";
                break;
        }

        if (Strings.isEmpty(queryParam)){
            return Result.error("参数不正确，判别参数类别 1：收银机号  2：收银员号");
        }
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        //指定门店
        if(!Strings.isEmpty(storeCode)){
            if(storeCode.contains(",")){
                String[] split = storeCode.split(",");
                List<String> stores = Arrays.asList(split);
                TermsQueryBuilder storeCodesquery = QueryBuilders.termsQuery("store_code",stores);
                query.must(storeCodesquery);
            }else {
                if (!"allStore".equals(storeCode)) {
                    MatchPhraseQueryBuilder storeCodesquery = QueryBuilders.matchPhraseQuery("store_code", storeCode);
                    query.must(storeCodesquery);
                }
            }

        }else {
            return Result.error("请选择门店");
        }
        // 选定数据范围
       // MatchPhraseQueryBuilder dsQuery = QueryBuilders.matchPhraseQuery("ds", ds);
       // query.must(dsQuery);
        if (!Strings.isEmpty(value)){
            WildcardQueryBuilder conditionQuery = QueryBuilders.wildcardQuery(queryParam, "*"+value+"*");
            query.must(conditionQuery);
        }


        List<String> records= ElasticsearchUtil.searchDataPageByFold("es_inv_main_dd", "first", 0, 0, query, queryParam, "rqsj", "",queryParam + ".keyword");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("valueList",records);

        return Result.ok(jsonObject);
    }
    /**
     * 分页列表查询
     *
     * @param queryInvMain
     * @param req
     * @return
     */
    @AutoLog(value = "小票主单表-分页列表查询_es")
    @ApiOperation(value = "小票主单表-分页列表查询_es", notes = "小票主单表-分页列表查询_es")
    @PostMapping(value = "/list_es")
    public Result<?> queryPageListes(@RequestBody QueryInvMain queryInvMain,
                                     HttpServletRequest req) {
        //校验门店编码
        if(Strings.isEmpty(queryInvMain.getStoreCode())){
            //数据库无数据
            return Result.error("请选择门店编码");
        }
        //获取最大数据版本
//        String ds = PubUtil.getMaxDs("es_inv_main_dd&"+queryInvMain.getStoreCode(), redisUtil);
//        if (Strings.isEmpty(ds)) {
//            //数据库无数据
//            return Result.error("数据库无数据");
//        }

        BoolQueryBuilder query = QueryBuilders.boolQuery();
        EsCheckResurt esCheckResurt = invMainService.checkAndput(query, queryInvMain);
       query = esCheckResurt.getQuery();
        if (ObjectUtils.isEmpty(query)) {
            return Result.error(esCheckResurt.getResultMessage());
        }


        EsPage esPage = ElasticsearchUtil.searchDataPage("es_inv_main_dd", "first", queryInvMain.getPageNo() - 1, queryInvMain.getPageSize(), query, "", "rqsj", "");

        List<Map<String, Object>> recordList = esPage.getRecordList();
        //拼接字段
        recordList=recordList.stream().map(x->{
            //非会员折扣 = 折扣额 + 折让额 + 优惠折扣额
            x.put("fhyzk",new BigDecimal(0.00).add(new BigDecimal(x.get("zzke").toString())).add(new BigDecimal(x.get("zzre").toString())).add(new BigDecimal(x.get("yhzke").toString())));
            //零售金额 = 应收金额 + 会员折扣 + 非会员折扣
            x.put("lsje",new BigDecimal(0.00).add(new BigDecimal(x.get("ysje").toString())).add(new BigDecimal(x.get("hyzke").toString())).add(new BigDecimal(x.get("fhyzk").toString())));
            return x;
        }).collect(Collectors.toList());
        List<InvMain> records = recordList.stream().map(x ->
                JSON.toJavaObject((JSON) JSON.toJSON(x), InvMain.class)
        ).collect(Collectors.toList());



        //设置附加信息
        Map<String,BigDecimal> additionMap = new HashMap<>();
        //设置需要附件求和的字段
        String[] addFields = {"ysje","sjfk","zl","zke","hyzke","yhzke","sysy","rmb","usd","hkd","xjzp","zzzp","xyk","lq","mzk","ick","sz","pay11","pay12","pay13","pay14","pay15","zzke","zzre","lsje","fhyzk"};
        Arrays.stream(addFields).map(x->additionMap.put(x,new BigDecimal("0.00"))).collect(Collectors.toList());
        recordList.stream().map(x->{
            for (String field : additionMap.keySet()){
                BigDecimal add = additionMap.get(field).add(new BigDecimal(x.getOrDefault(field, "0.00").toString()));
                additionMap.put(field,add);

            }
            return x;
        }).collect(Collectors.toList());
        String additionString= JSON.toJSONString(additionMap);
        JSONObject additionMsg = JSONObject.parseObject(additionString);

        NIPage<InvMain> pageList = new NIPage<>();
        pageList.setTotal(esPage.getRecordCount());
        pageList.setPages(esPage.getPageCount());
        pageList.setSize(queryInvMain.getPageSize());
        pageList.setCurrent(queryInvMain.getPageNo());
        pageList.setRecords(records);
        pageList.setAdditionMsg(additionMsg);
        return Result.ok(pageList);
    }


    /**
     * 分页列表查询
     *
     * @param queryInvMain
     * @param
     * @return
     */
    @AutoLog(value = "小票主单表-分页列表数据导出")
    @ApiOperation(value = "小票主单表-分页列表数据导出", notes = "小票主单表-分页列表数据导出")
    @GetMapping(value = "/export")
    public Result<?>  queryPageListExport( QueryInvMain queryInvMain,
                                              HttpServletResponse response) {
        //校验门店编码
        if(Strings.isEmpty(queryInvMain.getStoreCode())){
            //数据库无数据
            return Result.error("请选择门店编码");
        }
        //获取最大数据版本
//        String ds = PubUtil.getMaxDs("es_inv_main_dd&"+queryInvMain.getStoreCode(), redisUtil);
//        if (Strings.isEmpty(ds)) {
//            //数据库无数据
//            return Result.error("数据库无数据");
//        }

        BoolQueryBuilder query = QueryBuilders.boolQuery();
        EsCheckResurt esCheckResurt = invMainService.checkAndput(query, queryInvMain);
        query = esCheckResurt.getQuery();
        if (ObjectUtils.isEmpty(query)) {
            return Result.error("未查询到数据");
        }

        EsPage esPage = ElasticsearchUtil.searchDataPage("es_inv_main_dd", "first", queryInvMain.getPageNo() - 1, queryInvMain.getPageSize(), query, "", "rqsj", "");

        List<Map<String, Object>> recordList = esPage.getRecordList();

        //拼接字段
        recordList=recordList.stream().map(x->{
            //非会员折扣 = 折扣额 + 折让额 + 优惠折扣额
            x.put("fhyzk",new BigDecimal(0.00).add(new BigDecimal(x.get("zzke").toString())).add(new BigDecimal(x.get("zzre").toString())).add(new BigDecimal(x.get("yhzke").toString())));
            //零售金额 = 应收金额 + 会员折扣 + 非会员折扣
            x.put("lsje",new BigDecimal(0.00).add(new BigDecimal(x.get("ysje").toString())).add(new BigDecimal(x.get("hyzke").toString())).add(new BigDecimal(x.get("fhyzk").toString())));
            return x;
        }).collect(Collectors.toList());

        List<InvMain> records = recordList.stream().map(x ->
                JSON.toJavaObject((JSON) JSON.toJSON(x), InvMain.class)
        ).collect(Collectors.toList());



        //设置附加信息
        Map<String,BigDecimal> additionMap = new HashMap<>();
        //设置需要附件求和的字段
        String[] addFields = {"ysje","sjfk","zl","zke","hyzke","yhzke","sysy","rmb","usd","hkd","xjzp","zzzp","xyk","lq","mzk","ick","sz","pay11","pay12","pay13","pay14","pay15","zzke","zzre","lsje","fhyzk"};
        Arrays.stream(addFields).map(x->additionMap.put(x,new BigDecimal("0.00"))).collect(Collectors.toList());
        recordList.stream().map(x->{
            for (String field : additionMap.keySet()){
                BigDecimal add = additionMap.get(field).add(new BigDecimal(x.getOrDefault(field, "0.00").toString()));
                additionMap.put(field,add);

            }
            return x;
        }).collect(Collectors.toList());
        System.out.println(records.size()+"-----------------------------------------");
        InvMain invMain = JSON.toJavaObject((JSON) JSON.toJSON(additionMap), InvMain.class);
        invMain.setSeqno("汇总");
        invMain.setDjlb("");
        records.add(invMain);
        // 导出数据，数据，数据类型，文件名称，表名，响应对象
        ExcelUtils.exportExcel(records, InvMain.class, "小票信息表", "小票信息统计", response);
        return Result.ok("数据导出成功");


    }

    /**
     * 分页列表查询
     *暂时未使用
     * @param queryInvMain
     * @param
     * @return
     */
    @AutoLog(value = "小票主单表-分页列表数据导出")
    @ApiOperation(value = "小票主单表-分页列表数据导出", notes = "小票主单表-分页列表数据导出")
    @GetMapping(value = "/bigExport")
    public Result<?>  queryPageListBigExport( QueryInvMain queryInvMain,
                                           HttpServletResponse response) {

        //校验门店编码
        if(Strings.isEmpty(queryInvMain.getStoreCode())){
            //数据库无数据
            return Result.error("请选择门店编码");
        }
        //获取最大数据版本
//        String ds = PubUtil.getMaxDs("es_inv_main_dd&"+queryInvMain.getStoreCode(), redisUtil);
//        if (Strings.isEmpty(ds)) {
//            //数据库无数据
//            return Result.error("数据库无数据");
//        }

        BoolQueryBuilder query = QueryBuilders.boolQuery();
        EsCheckResurt esCheckResurt = invMainService.checkAndput(query, queryInvMain);
        query = esCheckResurt.getQuery();
        if (ObjectUtils.isEmpty(query)) {
            return Result.error("未查询到数据");
        }
        int pageNo = 1;
        int i = 1;
        //设置附加信息
        Map<String,BigDecimal> additionMap = new HashMap<>();
        List<InvMain> allRecords = new ArrayList<>();
        while (queryInvMain.getPageSize()>=i){
            EsPage esPage = ElasticsearchUtil.searchDataPage("es_inv_main_dd", "first", pageNo, 10000, query, "", "rqsj", "");

            List<Map<String, Object>> recordList = esPage.getRecordList();
            //拼接字段
            recordList=recordList.stream().map(x->{
                //非会员折扣 = 折扣额 + 折让额 + 优惠折扣额
                x.put("fhyzk",new BigDecimal(0.00).add(new BigDecimal(x.get("zzke").toString())).add(new BigDecimal(x.get("zzre").toString())).add(new BigDecimal(x.get("yhzke").toString())));
                //零售金额 = 应收金额 + 会员折扣 + 非会员折扣
                x.put("lsje",new BigDecimal(0.00).add(new BigDecimal(x.get("ysje").toString())).add(new BigDecimal(x.get("hyzke").toString())).add(new BigDecimal(x.get("fhyzk").toString())));
                return x;
            }).collect(Collectors.toList());

            List<InvMain> records = recordList.stream().map(x ->
                    JSON.toJavaObject((JSON) JSON.toJSON(x), InvMain.class)
            ).collect(Collectors.toList());


            allRecords.addAll(records);
            //设置需要附件求和的字段
            String[] addFields = {"ysje","sjfk","zl","zke","hyzke","yhzke","sysy","rmb","usd","hkd","xjzp","zzzp","xyk","lq","mzk","ick","sz","pay11","pay12","pay13","pay14","pay15","zzke","zzre","lsje","fhyzk"};
            Arrays.stream(addFields).map(x->additionMap.put(x,new BigDecimal("0.00"))).collect(Collectors.toList());
            recordList.stream().map(x->{
                for (String field : additionMap.keySet()){
                    BigDecimal add = additionMap.get(field).add(new BigDecimal(x.getOrDefault(field, "0.00").toString()));
                    additionMap.put(field,add);

                }
                return x;
            }).collect(Collectors.toList());
            i = pageNo*10000;
            pageNo++;
        }

        InvMain invMain = JSON.toJavaObject((JSON) JSON.toJSON(additionMap), InvMain.class);
        invMain.setSeqno("汇总");
        invMain.setDjlb("");
        allRecords.add(invMain);
        // 导出数据，数据，数据类型，文件名称，表名，响应对象
        ExcelUtils.exportExcel(allRecords, InvMain.class, "小票信息表", "小票信息统计", response);
        return Result.ok("数据导出成功");

    }



    /**
     * 通过seqno查询
     *
     * @param seqno
     * @return
     */
    @AutoLog(value = "小票明细查询-通过seqno查询_es")
    @ApiOperation(value = "小票明细查询-通过seqno查询_es", notes = "小票明细查询-通过seqno查询")
    @GetMapping(value = "/queryComById_es")
    public Result<?> queryComById_es(@RequestParam(name = "seqno", required = true) String seqno, @RequestParam(name = "storeCode", required = true) String storeCode) {
        //获取最大数据版本
        //String ds = PubUtil.getMaxDs("es_inv_com_dd&"+storeCode, redisUtil);
//        if (Strings.isEmpty(ds)) {
//            //数据库无数据
//            return Result.error("数据库无数据");
//        }
        if (Strings.isEmpty(seqno)) {
            return Result.error("未填写小票号");
        }
        if (Strings.isEmpty(storeCode)) {
            return Result.error("未填写门店编码");
        }

        BoolQueryBuilder query = QueryBuilders.boolQuery();
//        MatchPhraseQueryBuilder ds_query = QueryBuilders.matchPhraseQuery("ds", ds);
//        query.must(ds_query);
        MatchPhraseQueryBuilder seq_query = QueryBuilders.matchPhraseQuery("seqno", seqno);
        query.must(seq_query);
        MatchPhraseQueryBuilder code_query = QueryBuilders.matchPhraseQuery("store_code", storeCode);
        query.must(code_query);
        //忽略逻辑删除数据  1：有效数据  0：删除数据
        MatchPhraseQueryBuilder operationType = QueryBuilders.matchPhraseQuery("operation_type", "1");
        query.must(operationType);
        List<Map<String, Object>> recordList = ElasticsearchUtil.searchListData("es_inv_com_dd", "first", query, 100, "", "line_no,asc", "");

        List<InvCom> list = recordList.stream().map(x ->
                JSON.toJavaObject((JSON) JSON.toJSON(x), InvCom.class)
        ).collect(Collectors.toList());
        if (!ObjectUtils.isEmpty(list)) {
            //拼接字段
            list=list.stream().map(x -> {
                //售价金额 = 零售价*数量
                x.setSjje(x.getLsj().multiply(x.getSl()));
                //临时折扣 = 折扣额+折让额
                x.setLszk(x.getZke().add(x.getZre()));
                x.setLineNo(x.getLineNo().contains(".")?x.getLineNo().split("\\.")[0]:x.getLineNo());
                return x;
            }).collect(Collectors.toList());
        } else {
            return Result.error("未找到对应数据");
        }
        JSONObject returnMsg = new JSONObject();
        //设置附加信息
        Map<String,BigDecimal> additionMap = new HashMap<>();
        //设置需要附件求和的字段
        String[] addFields = {"sl","lsj","jg","zke","zre","hyzk","yhzk","sysy","yfphm","sjje","lszk"};
        Arrays.stream(addFields).map(x->additionMap.put(x,new BigDecimal("0.00"))).collect(Collectors.toList());
        recordList.stream().map(x->{
            for (String field : additionMap.keySet()){
                BigDecimal add = additionMap.get(field).add(new BigDecimal(x.getOrDefault(field, "0.00").toString()));
                additionMap.put(field,add);

            }
            return x;
        }).collect(Collectors.toList());
        String additionString= JSON.toJSONString(additionMap);
        JSONObject additionMsg = JSONObject.parseObject(additionString);
        returnMsg.put("data",list);
        returnMsg.put("additionMsg",additionMsg);

        return Result.ok(returnMsg);
    }


    /**
     * 通过seqno查询
     *
     * @param seqno
     * @return
     */
    @AutoLog(value = "二级支付介质查询-通过seqno查询_es")
    @ApiOperation(value = "二级支付介质查询-通过seqno查询_es", notes = "二级支付介质查询-通过seqno查询_es")
    @GetMapping(value = "/queryPayById_es")
    public Result<?> queryPayById_es(@RequestParam(name = "seqno", required = true) String seqno, @RequestParam(name = "storeCode", required = true) String storeCode) {
        //获取最大数据版本
       // String ds = PubUtil.getMaxDs("es_inv_pay2_dd&"+storeCode, redisUtil);
//        if (Strings.isEmpty(ds)) {
//            //数据库无数据
//            return Result.error("数据库无数据");
//        }
        if (Strings.isEmpty(seqno)) {
            return Result.error("未填写小票号");
        }
        if (Strings.isEmpty(storeCode)) {
            return Result.error("未填写门店编码");
        }

        BoolQueryBuilder query = QueryBuilders.boolQuery();
//        MatchPhraseQueryBuilder ds_query = QueryBuilders.matchPhraseQuery("ds", ds);
//        query.must(ds_query);
        MatchPhraseQueryBuilder seq_query = QueryBuilders.matchPhraseQuery("seqno", seqno);
        query.must(seq_query);
        MatchPhraseQueryBuilder code_query = QueryBuilders.matchPhraseQuery("store_code", storeCode);
        query.must(code_query);
        //忽略逻辑删除数据  1：有效数据  0：删除数据
        MatchPhraseQueryBuilder operationType = QueryBuilders.matchPhraseQuery("operation_type", "1");
        query.must(operationType);
        List<Map<String, Object>> recordList = ElasticsearchUtil.searchListData("es_inv_pay2_dd", "first", query, 100, "", "rqsj", "");
        List<InvPay2> list = recordList.stream().map(x ->
                JSON.toJavaObject((JSON) JSON.toJSON(x), InvPay2.class)
        ).collect(Collectors.toList());
        if (!ObjectUtils.isEmpty(list)) {
            //拼接字段
            list=list.stream().map(x -> {
                //本位币金额 = 金额 * 汇率
                x.setBwbje(x.getJe().multiply(x.getHl()));
                return x;
            }).collect(Collectors.toList());
        } else {
            return Result.error("未找到对应数据");
        }
        JSONObject returnMsg = new JSONObject();
        //设置附加信息
        Map<String,BigDecimal> additionMap = new HashMap<>();
        //设置需要附件求和的字段
        String[] addFields = {"je","hl","bwbje"};
        Arrays.stream(addFields).map(x->additionMap.put(x,new BigDecimal("0.00"))).collect(Collectors.toList());
        recordList.stream().map(x->{
            for (String field : additionMap.keySet()){
                BigDecimal add = additionMap.get(field).add(new BigDecimal(x.getOrDefault(field, "0.00").toString()));
                additionMap.put(field,add);

            }
            return x;
        }).collect(Collectors.toList());
        String additionString= JSON.toJSONString(additionMap);
        JSONObject additionMsg = JSONObject.parseObject(additionString);
        returnMsg.put("data",list);
        returnMsg.put("additionMsg",additionMsg);


        return Result.ok(returnMsg);
    }

// ==========================================================================================



    /**
     * 分页列表查询
     *
     * @param queryInvMain
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    @AutoLog(value = "小票主单表-分页列表查询")
    //@ApiOperation(value = "小票主单表-分页列表查询", notes = "小票主单表-分页列表查询")
    @GetMapping(value = "/list")
    public Result<?> queryPageList(QueryInvMain queryInvMain,
                                   @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req) {

        QueryWrapper<InvMain> queryWrapper = new QueryWrapper<>();
        //获取最大数据版本
        String copt = invMainService.getObj(new QueryWrapper<InvMain>().select("max(copt)"), Object::toString);
        if (Strings.isEmpty(copt)) {
            //数据库无数据
            return Result.error("数据查询失败");
        }
        //检查入参并生成查询条件
        CheckResurt checkResurt = invMainService.checkAndput(queryWrapper, queryInvMain, copt);
        queryWrapper = checkResurt.getQueryWrapper();
        //校验不通过
        if (ObjectUtils.isEmpty(queryWrapper)) {
            Result.error(checkResurt.getResultMessage());
        }
        Page<InvMain> page = new Page<InvMain>(pageNo, pageSize);
        IPage<InvMain> pageList = invMainService.page(page, queryWrapper);
        List<InvMain> records = pageList.getRecords();
        //拼接字段
        records.stream().map(x -> {
            //非会员折扣 = 折扣额 + 折让额 + 优惠折扣额
            x.setFhyzk(x.getZzke().add(x.getZzre()).add(x.getYhzke()));
            //零售金额 = 应收金额 + 会员折扣 + 非会员折扣
            x.setLsje(x.getYsje().add(x.getHyzke().add(x.getFhyzk())));
            return x;
        });

        pageList.setRecords(records);
        return Result.ok(pageList);
    }

    /**
     * 通过seqno查询
     *
     * @param seqno
     * @return
     */
    @AutoLog(value = "小票明细查询-通过seqno查询")
    //@ApiOperation(value = "小票明细查询-通过seqno查询", notes = "小票明细查询-通过seqno查询")
    @GetMapping(value = "/queryComById")
    public Result<?> queryComById(@RequestParam(name = "seqno", required = true) String seqno, @RequestParam(name = "storeCode", required = true) String storeCode) {
        //获取最大数据版本
        String copt = invComService.getObj(new QueryWrapper<InvCom>().select("max(copt)"), Object::toString);
        if (Strings.isEmpty(copt)) {
            //数据库无数据
            return Result.error("数据查询失败");
        }
        List<InvCom> list = invComService.list(new QueryWrapper<InvCom>().eq("copt", copt).eq("seqno", seqno).eq("store_code", storeCode).orderByDesc("rqsj"));
        if (!ObjectUtils.isEmpty(list)) {
            //拼接字段
            list.stream().map(x -> {
                //售价金额 = 零售价*数量
                x.setSjje(x.getLsj().multiply(x.getSl()));
                //临时折扣 = 折扣额+折让额
                x.setLszk(x.getZke().add(x.getZre()));
                return x;
            });
        } else {
            return Result.error("未找到对应数据");
        }
        return Result.ok(list);
    }

    /**
     * 通过seqno查询
     *
     * @param seqno
     * @return
     */
    @AutoLog(value = "二级支付介质查询-通过seqno查询")
    //@ApiOperation(value = "二级支付介质查询-通过seqno查询", notes = "二级支付介质查询-通过seqno查询")
    @GetMapping(value = "/queryPayById")
    public Result<?> queryPayById(@RequestParam(name = "seqno", required = true) String seqno, @RequestParam(name = "storeCode", required = true) String storeCode) {
        //获取最大数据版本
        String copt = iInvPay2Service.getObj(new QueryWrapper<InvPay2>().select("max(copt)"), Object::toString);
        if (Strings.isEmpty(copt)) {
            //数据库无数据
            return Result.error("数据查询失败");
        }
        List<InvPay2> list = iInvPay2Service.list(new QueryWrapper<InvPay2>().eq("copt", copt).eq("seqno", seqno).eq("store_code", storeCode).orderByDesc("rqsj"));
        if (!ObjectUtils.isEmpty(list)) {
            //拼接字段
            list.stream().map(x -> {
                //本位币金额 = 金额 * 汇率
                x.setBwbje(x.getJe().multiply(x.getHl()));
                return x;
            });
        } else {
            return Result.error("未找到对应数据");
        }
        return Result.ok(list);
    }


    /**
     * 添加
     *
     * @param invMain
     * @return
     */
    @AutoLog(value = "小票主单表-添加")
    //@ApiOperation(value = "小票主单表-添加", notes = "小票主单表-添加")
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody InvMain invMain) {
        invMainService.save(invMain);
        return Result.ok("添加成功！");
    }

    /**
     * 编辑
     *
     * @param invMain
     * @return
     */
    @AutoLog(value = "小票主单表-编辑")
    // @ApiOperation(value = "小票主单表-编辑", notes = "小票主单表-编辑")
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody InvMain invMain) {
        invMainService.updateById(invMain);
        return Result.ok("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "小票主单表-通过id删除")
    //@ApiOperation(value = "小票主单表-通过id删除", notes = "小票主单表-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
        invMainService.removeById(id);
        return Result.ok("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "小票主单表-批量删除")
    //@ApiOperation(value = "小票主单表-批量删除", notes = "小票主单表-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.invMainService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.ok("批量删除成功!");
    }




    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, InvMain.class);
    }

}
