package com.sandra.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model) {
        //把用户的信息存在session中
        session.setAttribute("userLoginInfo", username);

        model.addAttribute("username", username);

        return "main";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/goLogin")
    public String login(){
        return "login";
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession session) {


        session.removeAttribute("userLoginInfo");

        return "main";
    }
}
