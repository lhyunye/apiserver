package org.jeecg.modules.rdata.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import cn.afterturn.easypoi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 小票主单表
 * @Author: jeecg-boot
 * @Date:   2021-04-23
 * @Version: V1.0
 */
@Data
@TableName("inv_main")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="inv_main对象", description="小票主单表")
public class InvMain implements Serializable {
    private static final long serialVersionUID = 1L;
    /**单据类别 1、6销售  2、7退货*/
    @Excel(name = "交易类别", width = 15,replace = {"正常_1","正常_6","退货_2","退货_7"})
    @ApiModelProperty(value = "单据类别 1、6销售  2、7退货")
    private String djlb;

    /**门店名称*/
    @Excel(name = "门店名称", width = 15)
    @ApiModelProperty(value = "门店名称")
    private String storeName;


	/**小票号*/
	@Excel(name = "小票号", width = 15)
    @ApiModelProperty(value = "小票号")
    private String seqno;

    /**数据库保存时间*/
    @Excel(name = "开票时间", width = 15, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据库保存时间")
    private Date rqsj;


	/**收银机号*/
	@Excel(name = "收银机号", width = 15)
    @ApiModelProperty(value = "收银机号")
    private String syjh;

    /**收银员号*/
    @Excel(name = "收银员号", width = 15)
    @ApiModelProperty(value = "收银员号")
    private String syyh;

    /**班次*/
    @Excel(name = "班次", width = 15)
    @ApiModelProperty(value = "班次")
    private String bc;


    /**会员卡号id*/
    @Excel(name = "会员卡号", width = 15)
    @ApiModelProperty(value = "会员卡号id")
    private String hykh;

    /**零售金额*/
    @ApiModelProperty(value = "零售金额")
    @Excel(name = "零售金额", width = 15)
    @TableField(exist = false)
    private BigDecimal lsje;
    /**应收金额*/
    @Excel(name = "应收金额", width = 15)
    @ApiModelProperty(value = "应收金额")
    private BigDecimal ysje;

    /**实际付款*/
    @Excel(name = "实际付款", width = 15)
    @ApiModelProperty(value = "实际付款")
    private BigDecimal sjfk;
    /**找零*/
    @Excel(name = "找零", width = 15)
    @ApiModelProperty(value = "找零")
    private BigDecimal zl;

    /**会员折扣额*/
    @Excel(name = "会员折扣", width = 15)
    @ApiModelProperty(value = "会员折扣额")
    private BigDecimal hyzke;

    /**非会员折扣*/
    @Excel(name = "非会员折扣", width = 15)
    @ApiModelProperty(value = "非会员折扣")
    @TableField(exist = false)
    private BigDecimal fhyzk;

    /**收银损益*/
    @Excel(name = "收银损益", width = 15)
    @ApiModelProperty(value = "收银损益")
    private BigDecimal sysy;

    /**人民币支付金额*/
    @Excel(name = "人民币", width = 15)
    @ApiModelProperty(value = "人民币支付金额")
    private BigDecimal rmb;
    /**dz回馈支付金额*/
    @Excel(name = "DZ回馈", width = 15)
    @ApiModelProperty(value = "dz回馈支付金额")
    private BigDecimal usd;
    /**dz折扣支付金额*/
    @Excel(name = "DZ折扣", width = 15)
    @ApiModelProperty(value = "dz折扣支付金额")
    private BigDecimal hkd;
    /**支票支付金额*/
    @Excel(name = "支票", width = 15)
    @ApiModelProperty(value = "支票支付金额")
    private BigDecimal xjzp;
    /**ick支付金额*/
    @Excel(name = "IC卡", width = 15)
    @ApiModelProperty(value = "ick支付金额")
    private BigDecimal zzzp;
    /**信用卡支付金额*/
    @Excel(name = "信用卡", width = 15)
    @ApiModelProperty(value = "信用卡支付金额")
    private BigDecimal xyk;

    /**lq支付金额（hy回报）*/
    @Excel(name = "HY回报", width = 15)
    @ApiModelProperty(value = "lq支付金额（hy回报）")
    private BigDecimal lq;
    /**mzk支付金额（提货单）*/
    @Excel(name = "提货单", width = 15)
    @ApiModelProperty(value = "mzk支付金额（提货单）")
    private BigDecimal mzk;
    /**支付方式*/
    @Excel(name = "IC卡换货", width = 15)
    @ApiModelProperty(value = "支付方式")
    private BigDecimal ick;

    /**sz(回馈)支付金额*/
    @Excel(name = "SG回馈", width = 15)
    @ApiModelProperty(value = "sz(回馈)支付金额")
    private BigDecimal sz;
    /**（代收）支付金额*/
    @Excel(name = "代收", width = 15)
    @ApiModelProperty(value = "（代收）支付金额")
    private BigDecimal pay11;
    /**支付金额*/
    @Excel(name = "电商", width = 15)
    @ApiModelProperty(value = "支付金额")
    private BigDecimal pay12;
    /**（e支付）支付金额*/
    @Excel(name = "E支付", width = 15)
    @ApiModelProperty(value = "（e支付）支付金额")
    private BigDecimal pay13;


    /**支付金额*/
    @Excel(name = "PAY14", width = 15)
    @ApiModelProperty(value = "支付金额")
    private BigDecimal pay14;
    /**支付金额*/
    @Excel(name = "PAY15", width = 15)
    @ApiModelProperty(value = "支付金额")
    private BigDecimal pay15;


	/**流水号*/
	//@Excel(name = "流水号", width = 15)
    @ApiModelProperty(value = "流水号")
    private String fphm;





	/**标志*/
	//@Excel(name = "标志", width = 15)
    @ApiModelProperty(value = "标志")
    private String flag;


	/**折扣额*/
	//@Excel(name = "折扣额", width = 15)
    @ApiModelProperty(value = "折扣额")
    private BigDecimal zke;

	/**优惠折扣额*/
	//@Excel(name = "优惠折扣额", width = 15)
    @ApiModelProperty(value = "优惠折扣额")
    private BigDecimal yhzke;




	/**随机数+发票金额*/
	//@Excel(name = "随机数+发票金额", width = 15)
    @ApiModelProperty(value = "随机数+发票金额")
    private String dyfp;
	/**副卡卡类别*/
	//@Excel(name = "副卡卡类别", width = 15)
    @ApiModelProperty(value = "副卡卡类别")
    private String tsbz;
	/**授权卡号*/
	//@Excel(name = "授权卡号", width = 15)
    @ApiModelProperty(value = "授权卡号")
    private String sqgh;



	/**总折扣额*/
	//@Excel(name = "总折扣额", width = 15)
    @ApiModelProperty(value = "总折扣额")
    private BigDecimal zzke;
	/**总折让额*/
	//@Excel(name = "总折让额", width = 15)
    @ApiModelProperty(value = "总折让额")
    private BigDecimal zzre;
	/**数据库存库时间*/
	//@Excel(name = "数据库存库时间", width = 15, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据库存库时间")
    private Date fsRqsj;
	/**数据库存库日期*/
	//@Excel(name = "数据库存库日期", width = 15, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据库存库日期")
    private Date wkRq;
	/**会员卡类别*/
	//@Excel(name = "会员卡类别", width = 15)
    @ApiModelProperty(value = "会员卡类别")
    private String hyklb;
	/**订单号*/
	//@Excel(name = "订单号", width = 15)
    @ApiModelProperty(value = "订单号")
    private String orderid;
	/**渠道号*/
	//@Excel(name = "渠道号", width = 15)
    @ApiModelProperty(value = "渠道号")
    private String channel;
	/**门店编码*/
	//@Excel(name = "门店编码", width = 15)
    @ApiModelProperty(value = "门店编码")
    private String storeCode;

	/**数据批次*/

    @ApiModelProperty(value = "数据批次")
    private String ds;




}
