package com.sandra.controller;

import com.sandra.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * localhost:8080/user/t1?username=xxx;
     * 加上@RequestParam有助于和前端域名称对应
     * @param name
     * @return
     */
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {

        //1.接收前端参数
        System.out.println("接收到前端的参数为：" + name);

        //2.将返回的结果传递给前端
        model.addAttribute("msg", name);

        //3.视图跳转
        return "test";
    }

    /**
     * 前端接收的是一个对象：id，name，age;
     *
     * 这里会匹配User对象中的字段名，必须要名字一致；
     *
     * @return
     */
    @GetMapping("/t2")
    public String test2(User user) {

        System.out.println(user);

        return "test";
    }

    public String test3(ModelMap map) {

        return "test";
    }
}
