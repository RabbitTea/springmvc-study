package com.sandra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 被这个注解的类中所有的方法，如果返回值是String，并且有具体页面可跳转，就会被视图解析器解析；
 */
@Controller
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test2(Model model) {

        /**
         * Model是简化版的，专用于传数据的类
         */
        model.addAttribute("msg", "ControllerTest2");

        return "test";
    }
}
