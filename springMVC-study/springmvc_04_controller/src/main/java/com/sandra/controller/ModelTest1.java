package com.sandra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelTest1 {

    /**
     * 这里无法直接拿到HttpServletRequest和HttpServletResponse对象，但是可以直接用;
     * 可以不同过视图解析器来转发，但是不建议这样用
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/m1/t1")
    public String test(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        System.out.println(session.getId());

        return "test";
    }


    public String test1(Model model) {
        model.addAttribute("msg", "ModelTest1");

        /**
         * 没有视图解析器需要写全限定名，这里用了转发的操作 = forward前缀；即url地址不变；
         * 重定向 = redirect前缀
         */
        //return "/WEB-INF/jsp/test.jsp";
        return "forward:/WEB-INF/jsp/test.jsp";
    }
}
