package com.sandra.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.sandra.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */

@RestController  //自动返回一个字符串
public class AjaxController {

    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    /**
     * name对应jQuery data中的key
     * @param name
     * @param response
     * @throws IOException
     */
    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>"+name);

        if ("sandra".equals(name)) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2() {
        List<User> users = new ArrayList<User>();

        //添加数据
        users.add(new User("sandra", 3, "女"));
        users.add(new User("beibei", 7, "女"));
        users.add(new User("xiaobai", 9, "男"));

        return users;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd) {
        String msg = "";
        if (name != null) {

            // admin这些数据应该在数据库中查
            if ("admin".equals(name)) {
                msg = "ok";
            } else {
                msg = "用户名有误";
            }
        }

        if (pwd != null) {

            // admin这些数据应该在数据库中查
            if ("123456".equals(pwd)) {
                msg = "ok";
            } else {
                msg = "密码有误";
            }
        }

        return msg;
    }
}
