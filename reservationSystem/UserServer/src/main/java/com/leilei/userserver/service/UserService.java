package com.leilei.userserver.service;

import com.leilei.common.ResponseResult;
import com.leilei.entity.User;

public interface UserService {
    ResponseResult<User> login(String username, String password);
    ResponseResult<String> register(User user);
    User findUserById(Integer id);
}
