package com.leilei.client.controller;

import com.leilei.client.feign.UserFeignClient;
import com.leilei.common.ResponseResult;
import com.leilei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserFeignClient userFeignClient;
    @RequestMapping("/add")
    public String add(){
        return "user_add";
    }
    @RequestMapping("/login")
    public String login(){
        return "/login";
    }
    @PostMapping(value = "/register.do")
    public String register(User user){
        userFeignClient.register(user);
        return "redirect:/user/redirect/user_add";
    }
    @PostMapping(value = "login.do")
    @ResponseBody
    ResponseResult<User> login(String username, String password, HttpSession session){
        return userFeignClient.login(username,password,session);
    }
    @RequestMapping("/redirect/{target}") 
    public String redirect(@PathVariable("target") String target){
        return target;
    }

    @RequestMapping("/setSession/{key}/{value}")
    String setSession(@PathVariable("key") String key , @PathVariable("value") String value){
        return userFeignClient.setSession(key,value);
    }
    @RequestMapping("/getSession/{key}")
    @ResponseBody
    String getSession(@PathVariable(name = "key") String key ){
        return userFeignClient.getSession(key);
    }
}
