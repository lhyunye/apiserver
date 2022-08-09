package org.jeecg.modules.rdata.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class StringNameSerialize extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        if (value != null) {
            if(value.contains("$")) {
                gen.writeString(value.split("\\$")[0]);  // 返回出去是字符串
            }else {
                gen.writeString(value);  // 返回出去是字符串
            }


        }
    }
}
