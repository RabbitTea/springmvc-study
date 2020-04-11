package com.sandra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

    /**
     * 地址拼接为/add；
     * a和b为前端页面传参，传统方式在网址上写：localhost:8080/add?a=1&b=2
     *
     * 这里定义的参数和名字就是前端要传的参数和名字；
     * 这种是原来传统的方式；
     *
     *
     * RestFul：localhost:8080/add/add/a/b
     * 通过注解@PathVariable；配合注解里的value属性；
     * method属性指定了请求方式，这里限定了只能通过DELETE方式去请求。
     * @param a
     * @param b
     * @param model
     * @return
     */
    //@RequestMapping("/add")   传统方式
    //@RequestMapping(value="/add/{a}/{b}", method = RequestMethod.DELETE)   //RestFul风格

    @GetMapping("/add/{a}/{b}")  //经典的RestFul风格，表示以GET方式去请求，等同于@RequestMapping(value="/add/{a}/{b}", method = RequestMethod.GET)
    //@DeleteMapping   delete方式请求
    public String restFul(@PathVariable int a, @PathVariable int b, Model model) {

        int res = a + b;

        model.addAttribute("msg", "结果为" + res);

        return "test";
    }
}
