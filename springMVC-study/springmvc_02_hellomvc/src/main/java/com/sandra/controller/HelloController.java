package com.sandra.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 注意：这里先导入Controller接口
 */
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        //调用业务层；
        String result = "HelloSpringMVC!";

        //封装对象，放在ModelAndView中
        mv.addObject("msg", result);

        //封装要跳转的视图，放在ModelAndView中；拼接为/WEB-INF/jsp/hellp.jsp，因为配置有前缀和后缀
        mv.setViewName("hello");
        return mv;
    }

}
