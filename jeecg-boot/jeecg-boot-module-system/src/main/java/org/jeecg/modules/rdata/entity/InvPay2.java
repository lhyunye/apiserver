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
 * @Description: 小票2级支付介质表
 * @Author: jeecg-boot
 * @Date:   2021-04-23
 * @Version: V1.0
 */
@Data
@TableName("inv_pay2")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="inv_pay2对象", description="小票2级支付介质表")
public class InvPay2 implements Serializable {
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
	/**收银员号*/
	@Excel(name = "收银员号", width = 15)
    @ApiModelProperty(value = "收银员号")
    private String syyh;
	/**存库时间*/
	@Excel(name = "存库时间", width = 15, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "存库时间")
    private Date rqsj;
	/**一级介质编码*/
	@Excel(name = "一级介质编码", width = 15)
    @ApiModelProperty(value = "一级介质编码")
    private String paycode;
	/**二级介质编码*/
	@Excel(name = "二级介质编码", width = 15)
    @ApiModelProperty(value = "二级介质编码")
    private String mxcode;
	/**一级介质名称*/
	@Excel(name = "一级介质名称", width = 15)
    @ApiModelProperty(value = "一级介质名称")
    private String payName;
	/**二级介质名称*/
	@Excel(name = "二级介质名称", width = 15)
    @ApiModelProperty(value = "二级介质名称")
    private String mxName;
	/**原始凭证*/
	@Excel(name = "原始凭证", width = 15)
    @ApiModelProperty(value = "原始凭证")
    private String zpno;
	/**经办人*/
	@Excel(name = "经办人", width = 15)
    @ApiModelProperty(value = "经办人")
    private String xm;
	/**身份证号*/
	@Excel(name = "身份证号", width = 15)
    @ApiModelProperty(value = "身份证号")
    private String sfz;
	/**开户行或单位*/
	@Excel(name = "开户行或单位", width = 15)
    @ApiModelProperty(value = "开户行或单位")
    private String bank;
	/**原币金额*/
	@Excel(name = "原币金额", width = 15)
    @ApiModelProperty(value = "原币金额")
    private BigDecimal je;
	/**汇率*/
	@Excel(name = "汇率", width = 15)
    @ApiModelProperty(value = "汇率")
    private BigDecimal hl;
	/**数据库时间*/
	@Excel(name = "数据库时间", width = 15, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据库时间")
    private Date fsRqsj;
	/**数据库日期*/
	@Excel(name = "数据库日期", width = 15, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据库日期")
    private Date wkRq;
	/**行号*/
	@Excel(name = "行号", width = 15)
    @ApiModelProperty(value = "行号")
    private String lineNo;
	/**门店编码*/
	@Excel(name = "门店编码", width = 15)
    @ApiModelProperty(value = "门店编码")
    private String storeCode;
	/**门店名称*/
	@Excel(name = "门店名称", width = 15)
    @ApiModelProperty(value = "门店名称")
    private String storeName;
	/**数据批次*/
	@Excel(name = "数据批次", width = 15)
    @ApiModelProperty(value = "数据批次")
    private String ds;

    /**本位币金额*/
    @ApiModelProperty(value = "本位币金额")
    @TableField(exist = false)
    private BigDecimal bwbje;

}
