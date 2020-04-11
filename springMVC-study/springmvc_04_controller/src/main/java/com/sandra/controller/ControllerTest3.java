package com.sandra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 比如这里要进admin的页面，类上加注解RequestMapping添加/admin目录，关于admin的操作都在这个类中编写
 */
@Controller
@RequestMapping("/admin")
public class ControllerTest3 {

    @RequestMapping("/t3")
    public String test3() {
        return "test";
    }
}
