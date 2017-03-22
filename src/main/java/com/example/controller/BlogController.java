package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shaurav on 3/18/2017.
 */
@Controller
public class BlogController {
    @RequestMapping("/blog")
    public String blog(){
        return "blog2";
    }

    @RequestMapping("/blog2")
    public String showBlog() {return "blog";}
}
