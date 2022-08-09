package org.jeecg.modules.rdata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.rdata.entity.StrDdCom;
import org.jeecg.modules.rdata.mapper.StrDdComMapper;
import org.jeecg.modules.rdata.service.IStrDdComService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 订单明细表
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class StrDdComServiceImpl extends ServiceImpl<StrDdComMapper, StrDdCom> implements IStrDdComService {

}
