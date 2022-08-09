package org.jeecg.modules.rdata.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableMap;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class StringRateSerialize extends JsonSerializer<String> {
    private DecimalFormat df = new DecimalFormat("0.00");
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {

        ImmutableMap<String, String> rateMap = new ImmutableMap.Builder<String, String>()
                .put("0","0.00")
                .put("0.0291262136", "0.03")
                .put("0.0384615384", "0.04")
                .put("0.050000000","0.05")
                .put("0.0566037735", "0.06")
                .put("0.0825688073", "0.09")
                .put("0.0909090909", "0.10")
                .put("0.0990990991", "0.11")
                .put("0.1150442478", "0.13")
                .put("0.1379310345", "0.16")
                .put("0.1452991453", "0.17")
                .build();
        df.setMaximumFractionDigits(2);//显示几位修改几
        df.setGroupingSize(0);
        df.setRoundingMode(RoundingMode.HALF_UP);
        if (value != null) {
            if(rateMap.containsKey(value)) {
                gen.writeString(rateMap.get(value));  // 数值转换
            }else {
                gen.writeString(df.format(new BigDecimal(value)));  // 保留两位小数，四舍五入
            }


        }
    }
}
