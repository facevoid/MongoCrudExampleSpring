package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shaurav on 3/16/2017.
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String showHello(Model model){
        model.addAttribute("message","hello from the controller");
        return "hello";
    }
}
