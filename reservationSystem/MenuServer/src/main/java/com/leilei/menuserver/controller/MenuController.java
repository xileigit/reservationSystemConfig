package com.leilei.menuserver.controller;

import com.leilei.common.Page;
import com.leilei.common.ResponseResult;
import com.leilei.common.ResultMap;
import com.leilei.entity.Menu;
import com.leilei.menuserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    @GetMapping(value = "/layUiList")
    public  ResultMap<List<Menu>> backContent(Page page, @RequestParam("limit") int limit){
        System.out.println("menuList server");
        System.out.println("backContent========================"+limit);
        page.setRows(limit);
        System.out.println("page:"+page.toString());
        List<Menu> productList=menuService.selectPageList(page);
        int totals=menuService.count();
       // page.setTotalRecord(totals);

//        for (Product p:productList) {
//            System.out.println(p);
//        }
        return new ResultMap<List<Menu>>("",productList,0,totals);
    }
    @GetMapping(value = "/menuList")
    public  List<Menu> getMenuList(String page,String limit){
            return menuService.findAll();
    }
    @GetMapping(value = "/menuListUi")
    public  ResultMap<List<Menu>> getMenuListui(String page,String limit){
        System.out.println("menuList server");
        System.out.println("backContent========================"+limit);
//        page.setRows(limit);
        System.out.println("page:"+page.toString());
        List<Menu> productList=menuService.findMenulist(Integer.parseInt(limit));
        int totals=menuService.count();
        // page.setTotalRecord(totals);

//        for (Product p:productList) {
//            System.out.println(p);
//        }
        return new ResultMap<List<Menu>>("",productList,0,totals);
    }

    @GetMapping("/count")
    public Integer getMenuCount(){
        System.out.println("menuServer  count" );
        return menuService.count();
    }
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuService.save(menu);
    }

}
