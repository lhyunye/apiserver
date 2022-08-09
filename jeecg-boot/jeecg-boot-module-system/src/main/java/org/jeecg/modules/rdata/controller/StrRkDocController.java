package org.jeecg.modules.rdata.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.jeecg.common.api.vo.Result;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.util.RedisUtil;
import org.jeecg.modules.rdata.entity.*;
import org.jeecg.modules.rdata.service.IStrRkComService;
import org.jeecg.modules.rdata.service.IStrRkDocService;
import org.jeecg.modules.rdata.util.ElasticsearchUtil;
import org.jeecg.modules.rdata.util.EsPage;
import org.jeecg.modules.rdata.util.ExcelUtils;
import org.jeecg.modules.rdata.util.PubUtil;
import org.jeecg.modules.rdata.vo.*;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 入库退厂单主表
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
@Api(tags="入库退厂单主表")
@RestController
@RequestMapping("/rdata/strRkDoc")
@Slf4j
public class StrRkDocController extends JeecgController<StrRkDoc, IStrRkDocService> {
	@Autowired
	private IStrRkDocService strRkDocService;

	@Autowired
	private IStrRkComService strRkComService;

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private CodeFktj codeFktj;


	 @Value("${esquery.suffix}")
	 private String indexSuffix;

	 //es入库主单表
	 private String indexdoc = "es_str_rk_doc_dd";
	 //es入库明细表
	 private String indexcom = "es_str_rk_com_dd";

	 /*-------------------------------------------------------------------------------------------*/

	 /**
	  * 分页列表查询
	  *
	  * @param queryRkDoc
	  * @param req
	  * @return
	  */
	 @AutoLog(value = "入库退厂单主表-分页列表查询_es")
	 @ApiOperation(value="入库退厂单主表-分页列表查询_es", notes="入库退厂单主表-分页列表查询_es")
	 @PostMapping(value = "/list_es")
	 public Result<?> queryPageList_es(@RequestBody QueryRkDoc queryRkDoc,
									HttpServletRequest req) {
		 if (Strings.isEmpty(queryRkDoc.getStoreCode())) {
			 return Result.error("未填写门店编码");
		 }
		 //获取最大数据版本
//		 String ds = PubUtil.getMaxDs(indexdoc+indexSuffix+"&"+queryRkDoc.getStoreCode(), redisUtil);
//		 if (Strings.isEmpty(ds)) {
//			 //数据库无数据
//			 return Result.error("数据库无数据");
//		 }
		 Integer pageNo = queryRkDoc.getPageNo();
		 Integer pageSize = queryRkDoc.getPageSize();

		 BoolQueryBuilder query = QueryBuilders.boolQuery();
		 //数据校验及查询条件拼接
		 EsCheckResurt esCheckResurt = strRkDocService.checkAndput(query, queryRkDoc);
		 query = esCheckResurt.getQuery();
		 if (ObjectUtils.isEmpty(query)){
			 return Result.error(esCheckResurt.getResultMessage());
		 }
		 //查询入库单、退场单 主体                                                                                                                          shrq
		 EsPage esPage = ElasticsearchUtil.searchDataPage(indexdoc+indexSuffix, "first", pageNo - 1, pageSize, query, "", "shrq,djbh", "");
		 List<Map<String, Object>> recordList = esPage.getRecordList();
		 List<StrRkDoc> records = recordList.stream().map(x ->
				 JSON.toJavaObject((JSON) JSON.toJSON(x), StrRkDoc.class)
		 ).collect(Collectors.toList());

		 //获取订单号
		 List<String> seqnos = records.stream().map(x -> x.getSerialNo()).collect(Collectors.toList());

		 //获取订单明细
		 BoolQueryBuilder comQuery = QueryBuilders.boolQuery();
		 TermsQueryBuilder seqnoQuery = QueryBuilders.termsQuery("seqno", seqnos);
		 comQuery.must(seqnoQuery);
		 MatchPhraseQueryBuilder codeQuery = QueryBuilders.matchPhraseQuery("store_code", queryRkDoc.getStoreCode());
		 comQuery.must(codeQuery);
//		 MatchPhraseQueryBuilder dsQuery = QueryBuilders.matchPhraseQuery("ds", ds);
//		 comQuery.must(dsQuery);
		 List<Map<String, Object>> comRecords = ElasticsearchUtil.searchListData(indexcom+indexSuffix, "first", comQuery, seqnos.size()*50, "seqno,hsjjje,bhsjjje", "", "");
		 Map<Object, List<Map<String, Object>>> seqno = comRecords.stream().collect(Collectors.groupingBy(x -> x.getOrDefault("seqno", "")));
		 //补充数据
		 List<StrRkDoc> newRecords = new ArrayList<>();
		 DecimalFormat decimalFormat = new DecimalFormat("0.00");
		 int rowNo = (pageNo-1)*pageSize+1;
		 for (StrRkDoc strRkDoc :records){
			 if (seqno.containsKey(strRkDoc.getSerialNo())){
				 List<Map<String, Object>> hashMaps = seqno.get(strRkDoc.getSerialNo());
				 Double hsjjje = hashMaps.stream().map(x -> Double.parseDouble(x.getOrDefault("hsjjje","0").toString())).reduce(0.0, Double::sum);
				 Double bhsjjje = hashMaps.stream().map(x -> Double.parseDouble(x.getOrDefault("bhsjjje","0").toString())).reduce(0.0, Double::sum);
				strRkDoc.setCost(decimalFormat.format(bhsjjje));
				strRkDoc.setTaxCost(decimalFormat.format(hsjjje));
				strRkDoc.setTax(decimalFormat.format(hsjjje-bhsjjje));

			 }
			 strRkDoc.setRowNo(rowNo);
			 rowNo++;
			 newRecords.add(strRkDoc);
		 }

		 IPage<StrRkDoc> pageList = new Page<>();
		 pageList.setPages(esPage.getPageCount());
		 pageList.setCurrent(pageNo);
		 pageList.setSize(pageSize);
		 pageList.setTotal(esPage.getRecordCount());
		 pageList.setRecords(newRecords);

		 return Result.ok(pageList);


	 }



	 /**
	  * 通过id查询
	  *
	  * @param seqno
	  * @return
	  */
	 @AutoLog(value = "入库退厂单主表-通过id查询_es")
	 @ApiOperation(value="入库退厂单主表-通过id查询_es", notes="入库退厂单主表-通过id查询_es")
	 @GetMapping(value = "/queryById_es")
	 public Result<?> queryById_es(@RequestParam(name="serialNo",required=true) String seqno,@RequestParam(name = "storeCode",required = true) String storeCode) {
		 if (Strings.isEmpty(storeCode)) {
			 return Result.error("未填写门店编码");
		 }
		 if (Strings.isEmpty(seqno)) {
			 return Result.error("未填写订单号");
		 }
		 //获取最大数据版本
//		 String ds = PubUtil.getMaxDs(indexcom+indexSuffix+"&"+storeCode,redisUtil);
//		 if (Strings.isEmpty(ds)) {
//			 //数据库无数据
//			 return Result.error("数据库无数据");
//		 }


		 //获取主表详情
		 BoolQueryBuilder queryDoc = QueryBuilders.boolQuery();
		 MatchPhraseQueryBuilder seqnoQuery = QueryBuilders.matchPhraseQuery("seqno", seqno);
		 queryDoc.must(seqnoQuery);
		 MatchPhraseQueryBuilder codeQuery = QueryBuilders.matchPhraseQuery("store_code", storeCode);
		 queryDoc.must(codeQuery);
//		 MatchPhraseQueryBuilder dsQuery = QueryBuilders.matchPhraseQuery("ds", ds);
//		 queryDoc.must(dsQuery);
		 List<Map<String, Object>> doclist = ElasticsearchUtil.searchListData(indexdoc+indexSuffix, "first", queryDoc, null, "", "", "");
		 List<StrRkDoc> records = doclist.stream().map(x ->
				 JSON.toJavaObject((JSON) JSON.toJSON(x), StrRkDoc.class)
		 ).collect(Collectors.toList());
		 if(ObjectUtils.isEmpty(records)||records.size()<1) {
			 return Result.error("未找到对应数据");
		 }
		 //主表详情
		 StrRkDoc strRkDoc = records.get(0);
		 //获取明细详情列表
		 BoolQueryBuilder queryCom = QueryBuilders.boolQuery();
		 MatchPhraseQueryBuilder ddbhQuery = QueryBuilders.matchPhraseQuery("seqno", seqno);
		 queryCom.must(ddbhQuery);
		 queryCom.must(codeQuery);
//		 queryCom.must(dsQuery);
		 DecimalFormat decimalFormat = new DecimalFormat("0.00");
		 List<Map<String, Object>> comlist = ElasticsearchUtil.searchListData(indexcom+indexSuffix, "first", queryCom, 200, "", "rowno,asc", "");

		 List<StrRkCom> comRecords = comlist.stream().map(x ->
				 JSON.toJavaObject((JSON) JSON.toJSON(x), StrRkCom.class)
		 ).map(x->{
		 	//补充数据
			x.setTax(decimalFormat.format( Double.parseDouble(x.getTaxCost())-Double.parseDouble(x.getCost())));
			return x;
		 }).collect(Collectors.toList());

		 StrRkDocModel strDdDocModel = new StrRkDocModel();
		 strDdDocModel.setStrRkDoc(strRkDoc);
		 strDdDocModel.setStrRkComs(comRecords);
		 return Result.ok(strDdDocModel);
	 }

	 /*-------------------------------------------下面接口无用--------------------------------------*/






	/**
	 *   添加
	 *
	 * @param strRkDoc
	 * @return
	 */
	@AutoLog(value = "入库退厂单主表-添加")
	//@ApiOperation(value="入库退厂单主表-添加", notes="入库退厂单主表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody StrRkDoc strRkDoc) {
		strRkDocService.save(strRkDoc);
		return Result.ok("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param strRkDoc
	 * @return
	 */
	@AutoLog(value = "入库退厂单主表-编辑")
	//@ApiOperation(value="入库退厂单主表-编辑", notes="入库退厂单主表-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody StrRkDoc strRkDoc) {
		strRkDocService.updateById(strRkDoc);
		return Result.ok("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "入库退厂单主表-通过id删除")
	//@ApiOperation(value="入库退厂单主表-通过id删除", notes="入库退厂单主表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		strRkDocService.removeById(id);
		return Result.ok("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "入库退厂单主表-批量删除")
	//@ApiOperation(value="入库退厂单主表-批量删除", notes="入库退厂单主表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.strRkDocService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}



    /**
    * 导出excel
    *
    * @param request
    * @param strRkDoc
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, StrRkDoc strRkDoc) {
        return super.exportXls(request, strRkDoc, StrRkDoc.class, "入库退厂单主表");
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
        return super.importExcel(request, response, StrRkDoc.class);
    }

}
