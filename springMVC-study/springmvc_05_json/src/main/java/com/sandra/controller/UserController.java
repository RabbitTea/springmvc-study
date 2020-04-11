package com.sandra.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sandra.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller 加该注解会走视图解析器
 */
@Controller
//@RestController  等同于下面的ResponseBody
public class UserController {


    //produces用于解决json乱码，但一般使用SpringMVC提供的统一解决乱码的方式
    @RequestMapping(value = "/j1", produces = "application/json;charset=utf-8")
    @ResponseBody  //表示不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User("sandra", 3, "女");

        String var = mapper.writeValueAsString(user);

        return var;
    }

    /**
     * 返回多个对象
     * @return
     */
    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = new ArrayList<>();

        User user1 = new User("sandra1", 7, "女");
        User user2 = new User("sandra2", 7, "女");
        User user3 = new User("sandra3", 7, "女");
        User user4 = new User("sandra4", 7, "女");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str = mapper.writeValueAsString(userList);

        return str;
    }

    /**
     * 日期对象返回
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        //Date date = new Date();

        //使用ObjectMapper来格式化输出；其会默认展示时间戳的格式，这里将其关闭即可
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);

        //自定义日期的格式  使用日期对象的格式化方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //自行注入日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();

        //ObjectMapper，时间解析后的默认格式为：Timestamp,时间戳
        //return mapper.writeValueAsString(sdf.format(date));

        return mapper.writeValueAsString(date);
    }

    /**
     * fastjson
     * @return
     */
    public String json4() {
        List<User> userList = new ArrayList<>();

        User user1 = new User("sandra1", 7, "女");
        User user2 = new User("sandra2", 7, "女");
        User user3 = new User("sandra3", 7, "女");
        User user4 = new User("sandra4", 7, "女");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        //java对象 转 JSON字符串
        String str1 = JSON.toJSONString(userList);
        String str2 = JSON.toJSONString(user1);

        //json字符串 转 Java对象
        User jp_user = JSON.parseObject(str2, User.class);

        //Java对象 转 JSON对象
        JSONObject jsonObject = (JSONObject)JSON.toJSON(user2);

        //JSON对象 转 Java对象
        User to_java_user = JSON.toJavaObject(jsonObject, User.class);

        return str1;
    }
}
