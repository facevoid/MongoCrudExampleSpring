package com.example.controller;

import com.example.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shaurav on 3/17/2017.
 */
@Controller
public class UserController {
    @Autowired
    UserMongoRepository userMongoRepository;

    @RequestMapping("/user")
    public String user(Model model){
        model.addAttribute("userlist",userMongoRepository.findAll());
        return "user";
    }


}
