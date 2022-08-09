package org.jeecg.modules.rdata.vo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/*
* 各门店付款代码字典
*
* */
@Component
public class CodeFktj {

   private static HashMap<String,String> code1 = new HashMap<String,String>(){{
       put("1001","货到付款");
       put("1002","帐期付款");
       put("1003","预付100%");
       put("1004","买二结一");
       put("1005","帐期30天");
   }};
    private static HashMap<String,String> code2 = new HashMap<String,String>(){{
        put("1001","买二结一");
        put("1002","货到付50%帐期50%");
        put("1003","货到付20%帐期80%");
        put("1004","货到付30%帐期70%");
        put("1006","7天后货到付100%");
        put("1007","15天后货到付100%");
        put("1008","预付货款100%");
        put("1009","货到付100%");
    }};

    private static HashMap<String,String> code3 = new HashMap<String,String>(){{
        put("1001","货到付款");
        put("1002","预付100%");
        put("1003","买二结一");
        put("1004","帐期7天");
        put("1005","帐期15天");
        put("1006","帐期30天");
    }};
    private static HashMap<String,String> code4 = new HashMap<String,String>(){{
        put("1001","货到付款");
        put("1002","预付100%");
        put("1003","帐期30天");
        put("1004","买二结一");

    }};

    private static HashMap<String,String> code5 = new HashMap<String,String>(){{
        put("1001","帐期30天");
        put("1002","预付20%货到付80%帐期0%");


    }};

    private static HashMap<String,String> code6 = new HashMap<String,String>(){{
        put("1001","货到付款");
        put("1002","帐期付款");
        put("1003","预付100%");
        put("1004","买二结一");
        put("1005","预付50%货到50%");
    }};
    public static HashMap<String, HashMap<String,String>> FKTJ_CODE = new HashMap<String, HashMap<String,String>>(){{
        put("41031",code1);//焦作
        put("21011",code1);//大楼
        put("21012",code1);//双安
        put("21014",code1);//东安
        put("21013",code1);//长安
        put("51011",code2);//贵州
        put("61011",code3);//成都
        put("26011",code4);//包头
        put("42011",code5);//武汉
        put("40101",code1);//洛阳
        put("74011",code1);//西宁
        put("24011",code6);//太原
        put("72011",code1);//兰州
        put("62011",code1);//昆明
        put("26031",code1);//鄂尔多斯
        put("41021",code1);//郑州
        put("40301",code1);//长沙
        put("61031",code3);//乐山
        put("73011",code1);//银川
        put("71011",code1);//西安
        put("71012",code1);//西安2
        put("61012",code3);//成都2
        put("26012",code1);//包头2
        put("61022",code1);//重庆2
        put("41012",code1);//洛阳2
        put("74012",code1);//西宁2
        put("74013",code1);//西宁3
        put("41022",code1);//郑州2
        put("43012",code1);//长沙2
        put("21018",code1);//右安门

    }};

    public String getMsg(String store ,String code){
        String msg = "";
        //选择门店
        if (FKTJ_CODE.containsKey(store)){
            //获取对应的付款方式
            HashMap<String, String> fktjs = FKTJ_CODE.get(store);
            msg = fktjs.getOrDefault(code.split("\\.")[0],"");
        }
        return msg;
    }


}
