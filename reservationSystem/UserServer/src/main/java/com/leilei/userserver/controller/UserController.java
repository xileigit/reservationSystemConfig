package com.leilei.userserver.controller;
import com.leilei.common.ResponseCode;
import com.leilei.common.ResponseResult;
import com.leilei.entity.User;
import com.leilei.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "get/{id}")
    public User get(@PathVariable("id") Integer id)
    {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<User> login(String username, String password, HttpSession session){
        ResponseResult<User> response = userService.login(username,password);
        if(response.isSuccess()){
            session.setAttribute("CURRENT_USER",response.getData());
        }
        return response;
    }
    @GetMapping(value = "logout.do")
    @ResponseBody
    public ResponseResult<String> logout(HttpSession session){
        session.removeAttribute("CURRENT_USER");
        return ResponseResult.createBySuccess("注销成功",null);
    }
    @PostMapping(value = "register.do")
    @ResponseBody
    public ResponseResult<String> register( User user){
        return userService.register(user);
    }


    @ResponseBody
    @RequestMapping("/setSession/{key}/{value}")
    public String setSession(@PathVariable String key , @PathVariable String value,
                             HttpServletRequest request){
        request.getSession().setAttribute(key,value);
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()){
            String name = headers.nextElement();
            System.out.println(name + ":"+ request.getHeader(name));
        }
        System.out.println(request.getSession().getId());
        System.out.println(request.getSession().getAttribute(key));
        return request.getSession().getId();
    }

    /**
     * 读取session
     * @param key
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSession/{key}")
    public String getSession(@PathVariable String key ,HttpServletRequest request){
        return request.getSession().getAttribute(key) + "---- sessionId:" + request.getSession().getId() ;
    }

}
