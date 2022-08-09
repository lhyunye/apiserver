package org.jeecg.modules.rdata.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DoubleSerialize4 extends JsonSerializer<String> {
    private DecimalFormat df = new DecimalFormat("0.0000");
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        if (value != null) {
            df.setMaximumFractionDigits(4);//显示几位修改几
            df.setGroupingSize(0);
            df.setRoundingMode(RoundingMode.HALF_UP);

            //根据实际情况选择使用
             gen.writeString(df.format(new BigDecimal(value)));  // 返回出去是字符串
            //gen.writeNumber(df.format(value));  // 返回出去是数字形式 2018年12月27日17:17:21 更新

        }
    }
}
