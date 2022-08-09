package org.jeecg.modules.rdata.vo;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.common.Strings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static boolean checkTimeFormat(String time){
        Boolean result = true;
        if(!Strings.isEmpty(time)){
           return isLegalDate(time.length(),time,"yyyy-MM-dd");
        }
        return result;
    }


    /**
     * 根据时间 和时间格式 校验是否正确
     * @param length 校验的长度
     * @param sDate 校验的日期
     * @param format 校验的格式
     * @return
     */
    private static boolean isLegalDate(int length, String sDate,String format) {
        int legalLen = length;
        if ((sDate == null) || (sDate.length() != legalLen)) {
            return false;
        }
        DateFormat formatter = new SimpleDateFormat(format);
        try {
            Date date = formatter.parse(sDate);
            return sDate.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }

//    public static void main(String[] args) {
//        JSONObject
//    }


}
