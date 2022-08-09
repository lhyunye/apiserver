package org.jeecg.modules.rdata.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.jeecg.modules.rdata.entity.StrDdDoc;
import org.jeecg.modules.rdata.vo.CheckResurt;
import org.jeecg.modules.rdata.vo.EsCheckResurt;
import org.jeecg.modules.rdata.vo.QueryDdDoc;

/**
 * @Description: 订单主表
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
public interface IStrDdDocService extends IService<StrDdDoc> {

    public CheckResurt checkAndput(QueryWrapper<StrDdDoc> queryWrapper, QueryDdDoc queryDdDoc,String copt);

    public EsCheckResurt checkAndput(BoolQueryBuilder query, QueryDdDoc queryDdDoc);

}
