package org.jeecg.modules.rdata.vo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.elasticsearch.index.query.BoolQueryBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="check_resurt", description="参数检测结果")
public class EsCheckResurt {

    /** 返回信息 */
    @ApiModelProperty(value = "返回信息")
    private String resultMessage;

    /** 查询条件 */
    @ApiModelProperty(value = "查询条件")
    private BoolQueryBuilder query;
}
