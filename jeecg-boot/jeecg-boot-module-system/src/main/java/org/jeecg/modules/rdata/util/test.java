package org.jeecg.modules.rdata.util;


import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.annotation.Before;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class test {
    /**
     * 测试索引
     */
    private String indexName = "es_inv_com_dd";

    /**
     * 类型
     */
    private String esType = "first";


public void getesdata(){
//    boolean indexExist = ElasticsearchUtil.isIndexExist(indexName);
//    System.out.println(indexExist);
}


    public static void main(String[] args) {

    String a = "123.1";

        String s = a.contains(".")?a.split("\\.")[0]:a;
        System.out.println(s);



//         DecimalFormat df = new DecimalFormat("0.0");
//String value = "1.2335";
//        if (value != null) {
//            df.setMaximumFractionDigits(3);//显示几位修改几
//            df.setGroupingSize(0);
//            df.setRoundingMode(RoundingMode.HALF_UP);
//
//            //根据实际情况选择使用
//            System.out.println("-------------------------------");
//            System.out.println(df.format(new BigDecimal(value)));
//        }

//        HashMap<String ,Object> a = new HashMap<>();
//        a.put("seqno","1");
//        a.put("x",1.1);
//        a.put("y",3);
//        HashMap<String ,Object> b = new HashMap<>();
//        b.put("seqno","1");
//        b.put("x",2.1);
//        b.put("y",5);
//        HashMap<String ,Object> c = new HashMap<>();
//        c.put("seqno","2");
//        c.put("x",2.1);
//        c.put("y",5);
//
//        List<HashMap<String ,Object>> d = new ArrayList<>();
//        d.add(a);
//        d.add(b);
//        d.add(c);
//
//        Map<Object, List<HashMap<String, Object>>> seqno = d.stream().collect(Collectors.groupingBy(x -> x.get("seqno")));
//        String[] aa = {"1","2"};
//        for (String test :aa){
//            if (seqno.containsKey(test)){
//                List<HashMap<String, Object>> hashMaps = seqno.get(test);
//                Double x1 = hashMaps.stream().map(x -> Double.parseDouble(x.get("x").toString())).reduce(0.0, Double::sum);
//                Double y1 = hashMaps.stream().map(x -> Double.parseDouble(x.get("y").toString())).reduce(0.0, Double::sum);
//                System.out.println(seqno);
//                System.out.println(x1);
//                System.out.println(y1);
//            }
//        }
        JSONObject invMain = new JSONObject();
        invMain.getOrDefault("aa","").toString();

    }
}
