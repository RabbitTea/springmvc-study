package com.sandra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Controller 表示该类被Spring自动装配管理了
 * @RequestMapping 放在类上，表示下面所有的方法上的RequestMapping在拼接地址时，都要先拼接类上该注解()中的地址
 * @RestController 表示该类不会被视图解析器解析，返回的是一个字符串（json）
 */
@Controller
@RequestMapping("MyController")
public class HelloController {

    /**
     * 类上有注解的真实访问地址：localhost:8080/MyController/hello
     * 类上无注解的真实访问地址：localhost:8080/项目名/HelloController/hello
     * @param model
     * @return
     */
    @RequestMapping("/hello")
    public String hello(Model model) {

        //封装数据：向模型中添加属性msg与值，可以在jsp页面中取出并渲染
        model.addAttribute("msg", "Hello, SpringMVC Annotation!");

        //结果会被视图解析器处理
        return "hello";
    }

}
