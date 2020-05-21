package com.leilei.client.controller;

import com.leilei.client.feign.UserFeignClient;
import com.leilei.common.ResponseResult;
import com.leilei.common.ResultMap;
import com.leilei.entity.Menu;
import com.leilei.entity.User;
import com.leilei.entity.UserGender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserFeignClient userFeignClient;
    @RequestMapping("/add")
    public String add(){
        return "register";
    }

    @GetMapping(value = "/userListUi")
    @ResponseBody
    public  ResultMap<List<User>> getUserListUi(String page, String limit){
        System.out.println("test getmenulist");
        return userFeignClient.getUserListUi(page,limit);
    }
    @RequestMapping("/genderU")
    public String gender(){
        return "user_gender";
    }
    @GetMapping("/gender")
    @ResponseBody
    UserGender genderdo(){
        return userFeignClient.gender();
    }
    @RequestMapping("/login1")
    public String login1(){
        return "/login1";
    }
    @RequestMapping("/login")
    public String login(){
        return "/login";
    }
    @PostMapping(value = "/register.do")
    public String register(User user){
        System.out.println(user+"incontroller");
        userFeignClient.register(user);
        return "/index";
    }
    @PostMapping(value = "login.do")
    String login(String username, String password, HttpSession session){
        System.out.println(username+"login");
        userFeignClient.login(username,password,session);
        return "/order_add";
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
