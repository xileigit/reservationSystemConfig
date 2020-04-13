package com.leilei.userserver.dao;

import com.leilei.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int addUser(User user);
    User findUserById(Integer id);
    int checkUsername(String username);
    int checkEmail(String email);
    int checkPhone(String email);
    User login(@Param("username") String username, @Param("password") String password);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(User record);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);






    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    int updatePasswordByUsername(@Param("username") String username, @Param("passwordNew") String passwordNew);

    int checkPassword(@Param(value = "password") String password, @Param("userId") Integer userId);

    int checkEmailByUserId(@Param(value = "email") String email, @Param(value = "userId") Integer userId);

    int getMaleCnt();

    int getFemaleCnt();
}
