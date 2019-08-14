package com.example.login.controller;

import com.example.login.pojo.User;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*@RequestMapping("/")
    public String init(){
        return "login";
    }*/

    @RequestMapping("{page}")
    public String main(@PathVariable String page){
        return page;
    }


    @RequestMapping("input")
    public String input(String username, String password, HttpSession session){
        User user = this.userService.selectByNameAndPassword(username,password);
        if (user != null){
            session.setAttribute("user",user);
            return "main";
        }else {
            return null;
        }
    }
}
