package org.jeecg.modules.rdata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.rdata.entity.InvPay2;
import org.jeecg.modules.rdata.mapper.InvPay2Mapper;
import org.jeecg.modules.rdata.service.IInvPay2Service;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 小票2级支付介质表
 * @Author: jeecg-boot
 * @Date:   2021-04-23
 * @Version: V1.0
 */
@DS("multi-datasource1")
@Service
public class InvPay2ServiceImpl extends ServiceImpl<InvPay2Mapper, InvPay2> implements IInvPay2Service {

}
