package org.jeecg.modules.rdata.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.checkerframework.checker.formatter.qual.Format;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 订单主表
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
@Data
@TableName("str_dd_doc")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="str_dd_doc对象", description="订单主表")
public class StrDdDoc implements Serializable {
    private static final long serialVersionUID = 1L;


	/**单据编号、订单编号*/
	@Excel(name = "单据编号、订单编号", width = 15)
    @ApiModelProperty(value = "单据编号、订单编号")
    @JSONField(name = "djbh")
    private String orderNo="";
	/**订货日期*/
    @ApiModelProperty(value = "订货日期")
    @JSONField(name = "dhrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date orderDate;
	/**合同编号、邀约编号*/
	@Excel(name = "合同编号、邀约编号", width = 15)
    @ApiModelProperty(value = "合同编号、邀约编号")
    @JSONField(name = "htbh")
    private String contractNO;
	/**订货地点、收货地点*/
	@Excel(name = "订货地点、收货地点", width = 15)
    @ApiModelProperty(value = "订货地点、收货地点")
    @JSONField(name = "store")
    private String orderPlace;
	/**供应商*/
	@Excel(name = "供应商", width = 15)
    @ApiModelProperty(value = "供应商")
    @JSONField(name = "gys")
    private String supplierCode;

	/**订单类型：1:一次到货,2:多次到货,3:永续订单,*/
	@Excel(name = "订单类型：1:一次到货,2:多次到货,3:永续订单,", width = 15)
    @ApiModelProperty(value = "订单类型：1:一次到货,2:多次到货,3:永续订单,")
    private String type;

	/**送货日期、进货日期*/
	@Excel(name = "送货日期、进货日期", width = 15)
    @ApiModelProperty(value = "送货日期、进货日期")
    @JSONField(name = "jhrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date purchaseDate;
	/**手工单号*/
	@Excel(name = "手工单号", width = 15)
    @ApiModelProperty(value = "手工单号")
    @JSONField(name = "handno")
    private String manualNo;

	/**柜组*/
	@Excel(name = "柜组", width = 15)
    @ApiModelProperty(value = "柜组")
    @JSONField(name = "gz")
    private String groupNo;
	/**经营方式*/
	@Excel(name = "经营方式", width = 15)
    @ApiModelProperty(value = "经营方式")
    @JSONField(name = "jyfs")
    private String businessPractice;
	/**审核标志*/
	@Excel(name = "审核标志", width = 15)
    @ApiModelProperty(value = "审核标志")
    @JSONField(name = "shbz")
    private String auditStatus;
	/**最迟送货日期*/
    @ApiModelProperty(value = "最迟送货日期")
    @JSONField(name = "xdrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date lastPurchaseDate;

    /**单据类别*/
	@Excel(name = "单据类别", width = 15)
    @ApiModelProperty(value = "单据类别")
    @JSONField(name = "djlb")
    private String documentsCategory;
	/**录入员*/
	@Excel(name = "录入员", width = 15)
    @ApiModelProperty(value = "录入员")
    @JSONField(name = "lry")
    private String keyboarder;
	/**录入日期*/
	@Excel(name = "录入日期", width = 15)
    @ApiModelProperty(value = "录入日期")
    @JSONField(name = "lrrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date entryDate;

	/**采购员*/
	@Excel(name = "采购员", width = 15)
    @ApiModelProperty(value = "采购员")
    @JSONField(name = "cgy")
    private String buyer;
	/**供应商名称*/
	@Excel(name = "供应商名称", width = 15)
    @ApiModelProperty(value = "供应商名称")
    @JSONField(name = "gysName")
    private String supplierName;
	/**柜组名称*/
	@Excel(name = "柜组名称", width = 15)
    @ApiModelProperty(value = "柜组名称")
    @JSONField(name = "gzName")
    private String groupName;
	/**录入员名称*/
	@Excel(name = "录入员名称", width = 15)
    @ApiModelProperty(value = "录入员名称")
    @JSONField(name = "lryName")
    private String keyboarderName;
	/**采购员名称*/
	@Excel(name = "采购员名称", width = 15)
    @ApiModelProperty(value = "采购员名称")
    @JSONField(name = "cgyName")
    private String buyerName;
	/**付款代码*/
	@Excel(name = "账单期限", width = 15)
    @ApiModelProperty(value = "账单期限")
    @JSONField(name = "zqqx")
    private String billDeadline;
    /**付款代码*/
    @Excel(name = "付款代码", width = 15)
    @ApiModelProperty(value = "付款代码")
    @JSONField(name = "fktj")
    private String payCode;
    /**付款代码*/
    @Excel(name = "付款代码字典值", width = 15)
    @ApiModelProperty(value = "付款代码字典值")
    private String payCodeValue;
	/**审核员*/
	@Excel(name = "审核员", width = 15)
    @ApiModelProperty(value = "审核员")
    @JSONField(name = "shr")
    private String auditor;
	/**审核员名称*/
	@Excel(name = "审核员名称", width = 15)
    @ApiModelProperty(value = "审核员名称")
    @JSONField(name = "shrName")
    private String auditorName;
	/**审核日期*/
	@Excel(name = "审核日期", width = 15)
    @ApiModelProperty(value = "审核日期")
    @JSONField(name = "operrq2")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date auditDate;
	/**系列号*/
	@Excel(name = "系列号", width = 15)
    @ApiModelProperty(value = "系列号")
    @JSONField(name = "seqno")
    private String serialNo;
	/**门店编号*/
	@Excel(name = "门店编号", width = 15)
    @ApiModelProperty(value = "门店编号")
    private String storeCode;


    @Excel(name = "门店名称", width = 15)
    @ApiModelProperty(value = "门店名称")
    @JSONField(name = "storeName")
    private String storeName;
	/**数据版本*/
	@Excel(name = "数据版本", width = 15)
    @ApiModelProperty(value = "数据版本")
    @JSONField(name = "ds")
    private String dataVersion;
	/**外仓*/
	@Excel(name = "外仓", width = 15)
    @ApiModelProperty(value = "外仓")
    @JSONField(name = "ck")
    private String externalWarehouse="";
	/**付款总计*/
	@Excel(name = "付款总计", width = 15)
    @ApiModelProperty(value = "付款总计")
    @JSONField(name = "fkzj")
    private String totalPayment;
	/**应付*/
	@Excel(name = "应付", width = 15)
    @ApiModelProperty(value = "应付")
    @JSONField(name = "yf")
    private String accountsPayable;
	/**保险费*/
	@Excel(name = "保险费", width = 15)
    @ApiModelProperty(value = "保险费")
    @JSONField(name = "bxf")
    @JsonFormat(pattern = "%.2f")
    private String premium;
    /**审核经理*/
    @Excel(name = "审核经理", width = 15)
    @ApiModelProperty(value = "审核经理")
    @JSONField(name = "operusr2_name")
    private String checkManager;
    /**行号*/
    @Excel(name = "行号", width = 15)
    @ApiModelProperty(value = "行号")
    private int rowNo;
}
