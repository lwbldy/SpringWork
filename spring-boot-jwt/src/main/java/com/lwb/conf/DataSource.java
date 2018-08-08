package com.lwb.conf;

import java.util.HashMap;
import java.util.Map;

public class DataSource {

    private static Map<String,Map<String,String>> data;


    public static Map<String, Map<String, String>> getData() {
        if(data == null){
            data = new HashMap<>();
            Map<String,String> smithMap = new HashMap<>();

//            data.put("smith")
        }
        return data;
    }

    public static void setData(Map<String, Map<String, String>> data) {
        DataSource.data = data;
    }



}
