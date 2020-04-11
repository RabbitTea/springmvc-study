package com.sandra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingController {

    /**
     * 使用过滤器解决乱码，这里POST方法没有生效，但GET方法生效了
     * @param name
     * @param model
     * @return
     */
    //@PostMapping("/e/t1")
    @GetMapping("/e/t1")
    public String test1(String name, Model model) {
        model.addAttribute("msg", name);
        return "test";
    }
}
