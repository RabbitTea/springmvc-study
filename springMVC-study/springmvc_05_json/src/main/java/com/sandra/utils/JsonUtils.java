package com.sandra.utils;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Jackson工具类
 */
public class JsonUtils {

    /**
     * 开源工具的技能之一为方法重载：方法调方法；不重复造轮子;
     * 经常看源码;
     * @return
     */
    public static String getJson(Object object) throws JsonProcessingException {
        return getJson(object, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object, String dataFormat) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);

        //自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);

        mapper.setDateFormat(sdf);

        return mapper.writeValueAsString(object);
    }
}
