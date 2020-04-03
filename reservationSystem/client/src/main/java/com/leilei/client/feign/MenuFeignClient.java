package com.leilei.client.feign;

import com.leilei.entity.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@FeignClient(name = "MENUSERVER")
public interface MenuFeignClient {
    @GetMapping("/menu/count")
    Integer getMenuCount();
    @PostMapping("/menu/save")
    void save(@RequestBody Menu menu);
}
