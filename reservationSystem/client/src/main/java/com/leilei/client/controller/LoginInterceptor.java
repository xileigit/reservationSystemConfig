package com.leilei.client.controller;

import com.leilei.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        User user = (User) request.getSession().getAttribute("CURRENT_USER");
        if(user == null){
            //请求转发到登录界面
            try {
                response.sendRedirect("/user/login1");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }else {
            return true;
        }
    }
}
