package com.leilei.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseResult<T> implements Serializable {
    private int code;
    private String message;
    private T data;
    private ResponseResult(int code, String message){
        this(code,message,null);
    }
    public static <T> ResponseResult<T> createBySuccess(String message,T data){
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(),message,data);
    }
    public static <T> ResponseResult<T> createByErrorMessage(String message){
        return new ResponseResult<T>(ResponseCode.UNAUTHORIZED.getCode(),message);
    }
    public  boolean isSuccess(){
        return code == ResponseCode.SUCCESS.getCode();
    }









}
