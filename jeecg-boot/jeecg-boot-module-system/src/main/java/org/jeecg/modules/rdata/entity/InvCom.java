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
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 小票明细表
 * @Author: jeecg-boot
 * @Date:   2021-04-23
 * @Version: V1.0
 */
@Data
@TableName("inv_com")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="inv_com对象", description="小票明细表")
public class InvCom implements Serializable {
    private static final long serialVersionUID = 1L;


	/**小票号*/
	@Excel(name = "小票号", width = 15)
    @ApiModelProperty(value = "小票号")
    private double seqno;
	/**收银机号*/
	@Excel(name = "收银机号", width = 15)
    @ApiModelProperty(value = "收银机号")
    private String syjh;
	/**流水号*/
	@Excel(name = "流水号", width = 15)
    @ApiModelProperty(value = "流水号")
    private String fphm;
	/**数据库保存时间*/
	@Excel(name = "数据库保存时间", width = 15, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据库保存时间")
    private Date rqsj;
	/**营业员号*/
	@Excel(name = "营业员号", width = 15)
    @ApiModelProperty(value = "营业员号")
    private String yyyh;
	/**商品编码*/
	@Excel(name = "商品编码", width = 15)
    @ApiModelProperty(value = "商品编码")
    private String comCode;
	/**商品名称*/
	@Excel(name = "商品名称", width = 15)
    @ApiModelProperty(value = "商品名称")
    private String comName;
	/**货号*/
	@Excel(name = "货号", width = 15)
    @ApiModelProperty(value = "货号")
    private String commodSphh;
	/**规格*/
	@Excel(name = "规格", width = 15)
    @ApiModelProperty(value = "规格")
    private String commodSpec;
	/**商品类别*/
	@Excel(name = "商品类别", width = 15)
    @ApiModelProperty(value = "商品类别")
    private String splb;
	/**柜组*/
	@Excel(name = "柜组", width = 15)
    @ApiModelProperty(value = "柜组")
    private String gz;
	/**柜组名称*/
	@Excel(name = "柜组名称", width = 15)
    @ApiModelProperty(value = "柜组名称")
    private String gzName;
	/**数量*/
	@Excel(name = "数量", width = 15)
    @ApiModelProperty(value = "数量")
    private BigDecimal sl;
	/**零售价（商品表里的零售价）*/
	@Excel(name = "零售价（商品表里的零售价）", width = 15)
    @ApiModelProperty(value = "零售价（商品表里的零售价）")
    private BigDecimal lsj;
	/**零售价*/
	@Excel(name = "零售价", width = 15)
    @ApiModelProperty(value = "零售价")
    private BigDecimal jg;
	/**折扣额、手工折扣*/
	@Excel(name = "折扣额、手工折扣", width = 15)
    @ApiModelProperty(value = "折扣额、手工折扣")
    private BigDecimal zke;
	/**折让额*/
	@Excel(name = "折让额", width = 15)
    @ApiModelProperty(value = "折让额")
    private BigDecimal zre;
	/**会员折扣*/
	@Excel(name = "会员折扣", width = 15)
    @ApiModelProperty(value = "会员折扣")
    private BigDecimal hyzk;
	/**优惠折扣*/
	@Excel(name = "优惠折扣", width = 15)
    @ApiModelProperty(value = "优惠折扣")
    private BigDecimal yhzk;
	/**splb=1 供应商折扣  splb=供应商折扣+临时折扣*/
	@Excel(name = "splb=1 供应商折扣  splb=供应商折扣+临时折扣", width = 15)
    @ApiModelProperty(value = "splb=1 供应商折扣  splb=供应商折扣+临时折扣")
    private String yhzk1;
	/**收银损益*/
	@Excel(name = "收银损益", width = 15)
    @ApiModelProperty(value = "收银损益")
    private BigDecimal sysy;
	/**会员折扣率*/
	@Excel(name = "会员折扣率", width = 15)
    @ApiModelProperty(value = "会员折扣率")
    private BigDecimal yfphm;
	/**大中小类*/
	@Excel(name = "大中小类", width = 15)
    @ApiModelProperty(value = "大中小类")
    private String dzxl;
	/**供应商*/
	@Excel(name = "供应商", width = 15)
    @ApiModelProperty(value = "供应商")
    private String gys;
	/**供应商名称*/
	@Excel(name = "供应商名称", width = 15)
    @ApiModelProperty(value = "供应商名称")
    private String gysName;
	/**品牌*/
	@Excel(name = "品牌", width = 15)
    @ApiModelProperty(value = "品牌")
    private String pp;
	/**会员卡卡面卡号*/
	@Excel(name = "会员卡卡面卡号", width = 15)
    @ApiModelProperty(value = "会员卡卡面卡号")
    private String yjhx;
	/**数据库保存时间*/
	@Excel(name = "数据库保存时间", width = 15, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据库保存时间")
    private Date fsRqsj;
	/**行号*/
	@Excel(name = "行号", width = 15)
    @ApiModelProperty(value = "行号")
    private String lineNo;
	/**基础积分*/
	@Excel(name = "基础积分", width = 15)
    @ApiModelProperty(value = "基础积分")
    private String jcjf;
	/**标准积分*/
	@Excel(name = "标准积分", width = 15)
    @ApiModelProperty(value = "标准积分")
    private String bzjf;
	/**促销积分*/
	@Excel(name = "促销积分", width = 15)
    @ApiModelProperty(value = "促销积分")
    private String cxjf;
	/**门店名称*/
	@Excel(name = "门店名称", width = 15)
    @ApiModelProperty(value = "门店名称")
    private String storeName;
	/**门店编码*/
	@Excel(name = "门店编码", width = 15)
    @ApiModelProperty(value = "门店编码")
    private String storeCode;
	/**数据批次*/
	@Excel(name = "数据批次", width = 15)
    @ApiModelProperty(value = "数据批次")
    private String ds;

    /**售价金额*/
    @ApiModelProperty(value = "售价金额")
    @TableField(exist = false)
    private BigDecimal sjje;

    /**临时折扣*/
    @ApiModelProperty(value = "临时折扣")
    @TableField(exist = false)
    private BigDecimal lszk;



}
