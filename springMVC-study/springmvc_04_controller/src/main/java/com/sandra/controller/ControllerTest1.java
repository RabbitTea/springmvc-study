package com.sandra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 只要实现了Controller接口的类，说明这就是一个控制器了；
 * 就是返回一个ModelAndView对象
 */
public class ControllerTest1 implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        //1. 封装数据
        mv.addObject("msg", "ControllerTest1");
        //2. 设置跳转视图的名字
        mv.setViewName("test");

        return mv;
    }
}
