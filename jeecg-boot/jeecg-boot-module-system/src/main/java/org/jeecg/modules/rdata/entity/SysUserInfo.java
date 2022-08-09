package org.jeecg.modules.rdata.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
@Data
@TableName("inv_com")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="测试类", description="测试类")
public class SysUserInfo {

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Excel(name = "姓名", width = 15)
    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @Excel(name = "电话", width = 15)
    @ApiModelProperty(value = "电话")
    @TableField("phone")
    private String phone;

    @Excel(name = "性别", width = 15, dict = "sex")
    @TableField("sex")
    private Integer sex;

    @Excel(name = "状态", width = 15, dict = "status")
    @TableField("status")
    private Integer status;

}
