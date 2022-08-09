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
import org.jeecg.modules.rdata.util.DoubleSerialize2;
import org.jeecg.modules.rdata.util.DoubleSerialize4;
import org.jeecg.modules.rdata.util.StringNameSerialize;
import org.jeecg.modules.rdata.util.StringRateSerialize;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 入库退厂单明细
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
@Data
@TableName("str_rk_com")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="str_rk_com对象", description="入库退厂单明细")
public class StrRkCom implements Serializable {
    private static final long serialVersionUID = 1L;


	/**系列号*/
	@Excel(name = "系列号", width = 15)
    @ApiModelProperty(value = "系列号")
    @JSONField(name = "seqno")
    private String serialNo;
	/**行号*/
	@Excel(name = "行号", width = 15)
    @ApiModelProperty(value = "行号")
    @JSONField(name = "rowno")
    private int rowNo;
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
	/**商品类别*/
	@Excel(name = "商品类别", width = 15)
    @ApiModelProperty(value = "商品类别")
    @JSONField(name = "splb")
    private String productType;
	/**品名*/
	@Excel(name = "品名", width = 15)
    @ApiModelProperty(value = "品名")
    @JSONField(name = "name")
    @JsonSerialize(using = StringNameSerialize.class)
    private String productName;
	/**单位*/
	@Excel(name = "单位", width = 15)
    @ApiModelProperty(value = "单位")
    private String unit;
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
	/**应收数量*/
	@Excel(name = "应收数量", width = 15)
    @ApiModelProperty(value = "应收数量")
    @JSONField(name = "yssl")
    @JsonSerialize(using = DoubleSerialize4.class)
    private String orderNumber;
	/**实收数量*/
	@Excel(name = "实收数量", width = 15)
    @ApiModelProperty(value = "实收数量")
    @JSONField(name = "sssl")
    @JsonSerialize(using = DoubleSerialize4.class)
    private String quantityReceived;
	/**赠品数量*/
	@Excel(name = "赠品数量", width = 15)
    @ApiModelProperty(value = "赠品数量")
    @JSONField(name = "zpsl")
    @JsonSerialize(using = DoubleSerialize4.class)
    private String giftNumber;
	/**进项税率*/
	@Excel(name = "进项税率", width = 15)
    @ApiModelProperty(value = "进项税率")
    @JSONField(name = "jxtax")
    @JsonSerialize(using = StringRateSerialize.class)
    private String taxRate;
	/**含税进价*/
	@Excel(name = "含税进价", width = 15)
    @ApiModelProperty(value = "含税进价")
    @JSONField(name = "hsjj")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String taxPrice;
	/**含税进价金额*/
	@Excel(name = "含税进价金额", width = 15)
    @ApiModelProperty(value = "含税进价金额")
    @JSONField(name = "hsjjje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String taxCost;
    /**不含税进价金额*/
    @Excel(name = "不含税进价金额", width = 15)
    @ApiModelProperty(value = "不含税进价金额")
    @JSONField(name = "bhsjjje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String cost;
	/**不含税进价*/
	@Excel(name = "不含税进价", width = 15)
    @ApiModelProperty(value = "不含税进价")
    @JSONField(name = "bhsjj")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String price;
	/**零售价*/
	@Excel(name = "零售价", width = 15)
    @ApiModelProperty(value = "零售价")
    @JSONField(name = "lsj")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String retailPrice;
	/**零售金额*/
	@Excel(name = "零售金额", width = 15)
    @ApiModelProperty(value = "零售金额")
    @JSONField(name = "lsje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String retailAmount;
	/**柜台数量*/
	@Excel(name = "柜台数量", width = 15)
    @ApiModelProperty(value = "柜台数量")
    @JSONField(name = "kcsl")
    @JsonSerialize(using = DoubleSerialize4.class)
    private String stockQty;
	/**柜台含税进价金额*/
	@Excel(name = "柜台含税进价金额", width = 15)
    @ApiModelProperty(value = "柜台含税进价金额")
    @JSONField(name = "kchsjjje")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String stockAmount;
	/**毛利率*/
	@Excel(name = "毛利率", width = 15)
    @ApiModelProperty(value = "毛利率")
    @JSONField(name = "mll")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String interestRate;
	/**成立日期、生产日期*/
	@Excel(name = "成立日期、生产日期", width = 15)
    @ApiModelProperty(value = "成立日期、生产日期")
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
	/**日期*/
	@Excel(name = "日期", width = 15)
    @ApiModelProperty(value = "日期")
    @JSONField(name = "jbrq")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date inDate;
	/**未知*/
	@Excel(name = "未知", width = 15)
    @ApiModelProperty(value = "未知")
    @JSONField(name = "jbkcsl")
    private String unknown;
	/**商品扣率*/
	@Excel(name = "商品扣率", width = 15)
    @ApiModelProperty(value = "商品扣率")
    @JSONField(name = "kl")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String discount;
	/**会员价*/
	@Excel(name = "会员价", width = 15)
    @ApiModelProperty(value = "会员价")
    @JSONField(name = "hyj")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String memberPrice;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String memo;
	/**重量*/
	@Excel(name = "金饰个数", width = 15)
    @ApiModelProperty(value = "金饰个数")
    @JsonSerialize(using = DoubleSerialize4.class)
    private String weight;
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
	/**采购价*/
	@Excel(name = "采购价", width = 15)
    @ApiModelProperty(value = "采购价")
    @JSONField(name = "buyjj")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String purchasingPrice;
	/**采购包装、转换系数*/
	@Excel(name = "采购包装、转换系数", width = 15)
    @ApiModelProperty(value = "采购包装、转换系数")
    @JSONField(name = "buybzhl")
    private String purchasingPack;

    /**批次*/
    @Excel(name = "批次", width = 15)
    @ApiModelProperty(value = "批次")
    @JSONField(name = "pici")
    private String batch;
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
    private String ds;
    /**税额*/
    @Excel(name = "税额", width = 15)
    @ApiModelProperty(value = "税额")
    @JsonSerialize(using = DoubleSerialize2.class)
    private String tax;
}
