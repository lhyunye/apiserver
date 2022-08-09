package org.jeecg.modules.rdata.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.checkerframework.checker.formatter.qual.Format;
import org.jeecg.modules.rdata.util.DoubleSerialize2;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 入库退厂单主表
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
@Data
@TableName("str_rk_doc")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="str_rk_doc对象", description="入库退厂单主表")
public class StrRkDoc implements Serializable {
    private static final long serialVersionUID = 1L;


	/**审核人*/
	@Excel(name = "审核人", width = 15)
    @ApiModelProperty(value = "审核人")
    @JSONField(name = "shr")
    private String auditor;
	/**审核日期*/
	@Excel(name = "审核日期", width = 15)
    @ApiModelProperty(value = "审核日期")
    @JSONField(name = "shrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date auditDate;
	/**审核人名称*/
	@Excel(name = "审核人名称", width = 15)
    @ApiModelProperty(value = "审核人名称")
    @JSONField(name = "shrName")
    private String auditorName;
	/**供应商*/
	@Excel(name = "供应商", width = 15)
    @ApiModelProperty(value = "供应商")
    @JSONField(name = "gys")
    private String supplierCode;
	/**供应商名称*/
	@Excel(name = "供应商名称", width = 15)
    @ApiModelProperty(value = "供应商名称")
    @JSONField(name = "gysName")
    private String supplierName;
	/**单据编号、入库单编号*/
	@Excel(name = "单据编号、入库单编号", width = 15)
    @ApiModelProperty(value = "单据编号、入库单编号")
    @JSONField(name = "djbh")
    private String voucherNo;
	/**单据类别1入库2退厂*/
	@Excel(name = "单据类别1入库2退厂", width = 15)
    @ApiModelProperty(value = "单据类别1入库2退厂")
    @JSONField(name = "djlb")
    private String documentsCategory;
	/**经营方式*/
	@Excel(name = "经营方式", width = 15)
    @ApiModelProperty(value = "经营方式")
    @JSONField(name = "jyfs")
    private String manageManner;
	/**合同编号*/
	@Excel(name = "合同编号", width = 15)
    @ApiModelProperty(value = "合同编号")
    @JSONField(name = "htbh")
    private String contractNo;
	/**订单编号*/
	@Excel(name = "订单编号", width = 15)
    @ApiModelProperty(value = "订单编号")
    @JSONField(name = "ddbh")
    private String orderNo;
	/**录入员*/
	@Excel(name = "录入员", width = 15)
    @ApiModelProperty(value = "录入员")
    @JSONField(name = "lry")
    private String keyboarder;
	/**录入员名称*/
	@Excel(name = "录入员名称", width = 15)
    @ApiModelProperty(value = "录入员名称")
    @JSONField(name = "lryName")
    private String keyboarderName;

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
	/**采购员名称*/
	@Excel(name = "采购员名称", width = 15)
    @ApiModelProperty(value = "采购员名称")
    @JSONField(name = "cgyName")
    private String buyerName;
	/**账期期限*/
	@Excel(name = "账期期限", width = 15)
    @ApiModelProperty(value = "账期期限")
    @JSONField(name = "zqqx")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date deadline;
	/**最迟到货日期*/
	@Excel(name = "最迟到货日期", width = 15)
    @ApiModelProperty(value = "最迟到货日期")
    @JSONField(name = "xdrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date lastPurchaseDate;
	/**订货日期*/
	@Excel(name = "订货日期", width = 15)
    @ApiModelProperty(value = "订货日期")
    @JSONField(name = "dhrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date orderDate;
	/**进货日期*/
	@Excel(name = "进货日期", width = 15)
    @ApiModelProperty(value = "进货日期")
    @JSONField(name = "jhrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date purchaseDate;
	/**应收日期*/
	@Excel(name = "应收日期", width = 15)
    @ApiModelProperty(value = "应收日期")
    @JSONField(name = "ysrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date receivableDate;
	/**送货地点*/
	@Excel(name = "送货地点", width = 15)
    @ApiModelProperty(value = "送货地点")
    @JSONField(name = "store")
    private String orderPlace;
	/**柜组*/
	@Excel(name = "柜组", width = 15)
    @ApiModelProperty(value = "柜组")
    @JSONField(name = "gz")
    private String groupNo;
	/**柜组名称*/
	@Excel(name = "柜组名称", width = 15)
    @ApiModelProperty(value = "柜组名称")
    @JSONField(name = "gzName")
    private String groupName;
	/**发票号码*/
	@Excel(name = "发票号码", width = 15)
    @ApiModelProperty(value = "发票号码")
    @JSONField(name = "fphm")
    private String invoiceNo;
	/**系列号*/
	@Excel(name = "系列号", width = 15)
    @ApiModelProperty(value = "系列号")
    @JSONField(name = "seqno")
    private String serialNo;
	/**付款总计*/
	@Excel(name = "付款总计编码", width = 15)
    @ApiModelProperty(value = "付款总计编码")
    @JSONField(name = "fkzj")
    private String totalPayment;
    /**付款总计*/
    @Excel(name = "付款总计值", width = 15)
    @ApiModelProperty(value = "付款总计值")
    private String totalPaymentValue;

	/**外仓*/
	@Excel(name = "外仓", width = 15)
    @ApiModelProperty(value = "外仓")
    @JSONField(name = "ck")
    private String externalWarehouse;
	/**审核标志*/
	@Excel(name = "审核标志", width = 15)
    @ApiModelProperty(value = "审核标志")
    @JSONField(name = "shbz")
    private String auditStatus;
	/**应付金额*/
	@Excel(name = "应付金额", width = 15)
    @ApiModelProperty(value = "应付金额")
    @JSONField(name = "yf")
    private String accountsPayable;
	/**保险费*/
	@Excel(name = "保险费", width = 15)
    @ApiModelProperty(value = "保险费")
    @JSONField(name = "bxf")
    private String premium;
	/**到货批次*/
	@Excel(name = "到货批次", width = 15)
    @ApiModelProperty(value = "到货批次")
    @JSONField(name = "dhpici")
    private String batch;
	/**门店编码*/
	@Excel(name = "门店编码", width = 15)
    @ApiModelProperty(value = "门编码")
    private String storeCode;
	/**门店名称*/
	@Excel(name = "门店名称", width = 15)
    @ApiModelProperty(value = "门店名称")
    private String storeName;
	/**数据版本*/
	@Excel(name = "数据版本", width = 15)
    @ApiModelProperty(value = "数据版本")
    @JSONField(name = "ds")
    private String dataVersion;
    /**数据版本*/
    @Excel(name = "原单据编号", width = 15)
    @ApiModelProperty(value = "原单据编号")
    @JSONField(name = "ydjbh")
    private String oldVoucherNo;

    /**价款*/
    @Excel(name = "价款", width = 15)
    @ApiModelProperty(value = "价款")
    @JSONField(name = "bhsjjje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String cost;

    /**价税合计*/
    @Excel(name = "价税合计", width = 15)
    @ApiModelProperty(value = "价税合计")
    @JSONField(name = "hsjjje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String taxCost;

    /**税额*/
    @Excel(name = "税额", width = 15)
    @ApiModelProperty(value = "税额")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String tax;

    /**收货负责人*/
    @Excel(name = "收货负责人", width = 15)
    @ApiModelProperty(value = "收货负责人、实物负责人")
    @JSONField(name = "operusr1_name")
    private String receivingManager;
    /**制单人、理货负责人*/
    @Excel(name = "制单人、理货负责人", width = 15)
    @ApiModelProperty(value = "制单人、理货负责人")
    @JSONField(name = "operusr2_name")
    private String tallyingManager;
    /**退厂单理货负责人*/
    @Excel(name = "理货负责人", width = 15)
    @ApiModelProperty(value = "退厂单理货负责人")
    @JSONField(name = "operusr4_name")
    private String backTallyingManager;
    /**行号*/
    @Excel(name = "行号", width = 15)
    @ApiModelProperty(value = "行号")
    private int rowNo;


}
