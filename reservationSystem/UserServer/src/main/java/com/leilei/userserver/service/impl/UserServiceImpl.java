package com.leilei.userserver.service.impl;

import com.leilei.common.ResponseResult;
import com.leilei.entity.User;
import com.leilei.userserver.dao.UserMapper;
import com.leilei.userserver.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseResult<User> login(String username, String password) {
        int resultCount  = userMapper.checkUsername(username);
        if(resultCount == 0 ){
            return ResponseResult.createByErrorMessage("用户名不存在");
        }
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(md5Password);
        User user  = userMapper.login(username,md5Password);
        if(user == null){
            return ResponseResult.createByErrorMessage("密码错误");
        }
        user.setPassword(Strings.EMPTY);
        return ResponseResult.createBySuccess("登录成功",user);
    }

    @Override
    public ResponseResult<String> register(User user) {
        int resultCount  = userMapper.checkUsername(user.getUsername());
        if(resultCount > 0 ){
            return ResponseResult.createByErrorMessage("用户已存在");
        }
        resultCount = userMapper.checkEmail(user.getEmail());
        if(resultCount > 0 ){
            return ResponseResult.createByErrorMessage("邮箱已存在");
        }
        resultCount = userMapper.checkPhone(user.getPhone());
        if(resultCount > 0 ){
            return ResponseResult.createByErrorMessage("电话已存在");
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        resultCount = userMapper.addUser(user);
        if(resultCount == 0){
            return ResponseResult.createByErrorMessage("注册失败");
        }
        return ResponseResult.createBySuccess("注册成功",null);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public int getMaleCnt() {
        return userMapper.getMaleCnt();
    }


    @Override
    public int getFemaleCnt() {
        return userMapper.getFemaleCnt();
    }

    @Override
    public List<User> findUserlist(Integer rows) {
        return userMapper.findUserlist(rows);
    }

    @Override
    public int count() {
        return userMapper.count();
    }


}
