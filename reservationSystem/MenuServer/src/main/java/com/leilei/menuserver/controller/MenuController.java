package com.leilei.menuserver.controller;

import com.leilei.common.ResponseResult;
import com.leilei.entity.Menu;
import com.leilei.menuserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    @GetMapping("/count")
    Integer getMenuCount(){
        return menuService.count();
    }
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuService.save(menu);
    }

}
