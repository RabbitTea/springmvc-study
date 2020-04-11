package com.sandra.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {

        HttpSession session = request.getSession();

        //放行：判断什么情况下登录了
        if (session.getAttribute("userLoginInfo") != null){
            return true;
        }

        //第一次登录，也是没有session的
        if (request.getRequestURI().contains("goLogin")) {
            return true;
        }
        //说明用户在提交登录
        if (request.getRequestURI().contains("login")) {
            return true;
        }

        //判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);


        return false;
    }
}
