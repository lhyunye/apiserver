package org.jeecg.modules.rdata.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.jeecg.modules.rdata.util.DoubleSerialize2;
import org.jeecg.modules.rdata.util.DoubleSerialize4;
import org.jeecg.modules.rdata.util.StringNameSerialize;
import org.jeecg.modules.rdata.util.StringRateSerialize;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 订单明细表
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
@Data
@TableName("str_dd_com")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="str_dd_com对象", description="订单明细表")
public class StrDdCom implements Serializable {
    private static final long serialVersionUID = 1L;


	/**商品编码*/
	@Excel(name = "商品编码", width = 15)
    @ApiModelProperty(value = "商品编码")
    @JSONField(name = "comCode")
    private String productCode;

	/**销售条码*/
	@Excel(name = "销售条码", width = 15)
    @ApiModelProperty(value = "销售条码")
    @JSONField(name = "xstm")
    private String marketBarCode;
	/**品名*/
	@Excel(name = "品名", width = 15)
    @ApiModelProperty(value = "品名")
    @JSONField(name = "name")
    @JsonSerialize(using = StringNameSerialize.class)
    private String productName;
	/**规格*/
	@Excel(name = "规格", width = 15)
    @ApiModelProperty(value = "规格")
    @JSONField(name = "commodSpec")
    private String specification;
	/**货号*/
	@Excel(name = "货号", width = 15)
    @ApiModelProperty(value = "货号")
    @JSONField(name = "commodSphh")
    private String productNo;
	/**应收数量、订货数量*/
	@Excel(name = "应收数量、订货数量", width = 15)
    @ApiModelProperty(value = "应收数量、订货数量")
    @JSONField(name = "jysl")
    @JsonSerialize(using = DoubleSerialize4.class)
    private String orderNumber;
	/**含税进价*/
	@Excel(name = "含税进价", width = 15)
    @ApiModelProperty(value = "含税进价")
    @JSONField(name = "hsjj")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String taxPrice;
    /**税额*/
    @Excel(name = "税额", width = 15)
    @ApiModelProperty(value = "税额")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String tax;
	/**进项税率*/
	@Excel(name = "进项税率", width = 15)
    @ApiModelProperty(value = "进项税率")
    @JSONField(name = "jxtax")
    @JsonSerialize(using = StringRateSerialize.class)
    private String taxRate;
	/**不含税进价*/
	@Excel(name = "不含税进价", width = 15)
    @ApiModelProperty(value = "不含税进价")
    @JSONField(name = "bhsjj")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String price;
	/**订货金额*/
	@Excel(name = "订货金额", width = 15)
    @ApiModelProperty(value = "订货金额")
    @JSONField(name = "jyhsje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String orderAmount;
	/**销售单位*/
	@Excel(name = "销售单位", width = 15)
    @ApiModelProperty(value = "销售单位")
    private String unit;
	/**零售价*/
	@Excel(name = "零售价", width = 15)
    @ApiModelProperty(value = "零售价")
    @JSONField(name = "lsj")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String retailPrice;
//	/**收货数量、实收数量*/
//	@Excel(name = "收货数量、实收数量", width = 15)
//    @ApiModelProperty(value = "收货数量、实收数量")
//    @JSONField(name = "shsl")
//    private String quantityReceived;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String memo;
	/**系列号*/
	@Excel(name = "系列号", width = 15)
    @ApiModelProperty(value = "系列号")
    @JSONField(name = "seqno")
    private String serialNo;
	/**订单编号*/
	@Excel(name = "订单编号", width = 15)
    @ApiModelProperty(value = "订单编号")
    @JSONField(name = "ddbh")
    private String orderNo;
	/**行号*/
	@Excel(name = "行号", width = 15)
    @ApiModelProperty(value = "行号")
    @JSONField(name = "rowno")
    private int rowNo;
	/**商品类别*/
	@Excel(name = "商品类别", width = 15)
    @ApiModelProperty(value = "商品类别")
    @JSONField(name = "splb")
    private String productType;
	/**包装含量*/
	@Excel(name = "包装含量", width = 15)
    @ApiModelProperty(value = "包装含量")
    @JSONField(name = "bzhl")
    private String packingContent;
	/**产地*/
	@Excel(name = "产地", width = 15)
    @ApiModelProperty(value = "产地")
    @JSONField(name = "cd")
    private String productionPlace;
	/**数量*/
	@Excel(name = "数量", width = 15)
    @ApiModelProperty(value = "数量")
    @JSONField(name = "sl")
    @JsonSerialize(using = DoubleSerialize4.class)
    private String amount;
	/**零售金额*/
	@Excel(name = "零售金额", width = 15)
    @ApiModelProperty(value = "零售金额")
    @JSONField(name = "lsje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String retailAmount;
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
	/**毛利率*/
	@Excel(name = "毛利率", width = 15)
    @ApiModelProperty(value = "毛利率")
    @JSONField(name = "mll")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String interestRate;

	/**收货含税金额*/
	@Excel(name = "收货含税金额", width = 15)
    @ApiModelProperty(value = "收货含税金额")
    @JSONField(name = "shhsje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String receivedTaxPrice;
	/**收货不含税金额*/
	@Excel(name = "收货不含税金额", width = 15)
    @ApiModelProperty(value = "收货不含税金额")
    @JSONField(name = "shbhsje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String receivedPrice;
	/**收货零售金额*/
	@Excel(name = "收货零售金额", width = 15)
    @ApiModelProperty(value = "收货零售金额")
    @JSONField(name = "shlsje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String receivedRetailAmount;
	/**应收零售金额*/
	@Excel(name = "应收零售金额", width = 15)
    @ApiModelProperty(value = "应收零售金额")
    @JSONField(name = "jylsje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String dealRetailAmount;
	/**生产日期*/
	@Excel(name = "生产日期", width = 15)
    @ApiModelProperty(value = "生产日期")
    @JSONField(name = "scrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date producedDate;
	/**保质期天数*/
	@Excel(name = "保质期天数", width = 15)
    @ApiModelProperty(value = "保质期天数")
    @JSONField(name = "bzqts")
    private String shelfLifeDays;
	/**保利期天数*/
	@Excel(name = "保利期天数", width = 15)
    @ApiModelProperty(value = "保利期天数")
    @JSONField(name = "blqts")
    private String shelfProfitDays;
	/**库存数量*/
	@Excel(name = "库存数量", width = 15)
    @ApiModelProperty(value = "库存数量")
    @JSONField(name = "kcsl")
    @JsonSerialize(using = DoubleSerialize4.class)
    private String stockQty;
	/**库存金额*/
	@Excel(name = "库存金额", width = 15)
    @ApiModelProperty(value = "库存金额")
    @JSONField(name = "kchsjjje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String stockAmount;
	/**商品货号*/
	@Excel(name = "商品货号", width = 15)
    @ApiModelProperty(value = "商品货号")
    @JSONField(name = "sphh")
    private String goodsNo;
	/**采购单位*/
	@Excel(name = "采购单位", width = 15)
    @ApiModelProperty(value = "采购单位")
    @JSONField(name = "buyunit")
    private String purchasingUnit;
	/**采购价格*/
	@Excel(name = "采购价格", width = 15)
    @ApiModelProperty(value = "采购价格")
    @JSONField(name = "buyjj")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String purchasingPrice;
	/**采购包装*/
	@Excel(name = "采购包装", width = 15)
    @ApiModelProperty(value = "采购包装")
    @JSONField(name = "buybzhl")
    private String purchasingPack;
	/**门店编码*/
	@Excel(name = "门店编码", width = 15)
    @ApiModelProperty(value = "门店编码")
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
}
