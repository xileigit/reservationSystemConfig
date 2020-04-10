package com.leilei.client.feign;

import com.leilei.common.ResponseResult;
import com.leilei.entity.Menu;
import com.leilei.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@FeignClient(name = "USERSERVER")
public interface UserFeignClient {
    @PostMapping("/user/save")
    void save(@RequestBody User user);
    @PostMapping(value = "/user/register.do")
    @ResponseBody
    ResponseResult<String> register(User user);
    @PostMapping(value = "login.do")
    @ResponseBody
    //https://blog.csdn.net/niemingming/article/details/80862949
    ResponseResult<User> login(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session);



    @RequestMapping("/user/setSession/{key}/{value}")
    String setSession(@PathVariable("key") String key , @PathVariable("value") String value);
    @RequestMapping("/user/getSession/{key}")
    String getSession(@PathVariable(name = "key") String key );

}
