package com.leilei.client.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MesController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = "/sendsmsTest")
    public String sendsmsTest(){
       // https://office.ucpaas.com/controlHtmls/pages/sms/sms_product.html
        //单发短信API
        String url = "https://open.ucpaas.com/ol/sms/sendsms";
        JSONObject jsonObject = new JSONObject();
        //基础配置，在开发平台认证后获取
        jsonObject.put("sid","7dd850d0e229225e308b98388e7ed38c");
        jsonObject.put("token","7527ca3d4db28057ffacc3a1a0d9b992");
        jsonObject.put("appid","3c5bd1b29bcc4c8395b030f9af547e8d");
        //模板ID，在开发平台创建模板对应的模板ID
        jsonObject.put("templateid", "539135");
        //模板对应的参数，参数之间拼接用逗号作为间隔符
        jsonObject.put("param", "7112");
        //要发送的手机号
        jsonObject.put("mobile", "18021067112");
        //用户透传ID，随状态报告返回,可以不填写
        jsonObject.put("uid","");
        String json = JSONObject.toJSONString(jsonObject);
        //使用restTemplate进行访问远程服务
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
        String result = restTemplate.postForObject(url, httpEntity, String.class);
        return result;
    }


}
