package com.leilei.orderserver.controller;

import com.leilei.common.Page;
import com.leilei.common.ResultMap;
import com.leilei.entity.Menu;
import com.leilei.orderserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(value = "/getIndexMenu")
    public List<Menu> getIndexMenu(){
        return menuService.getIndexMenu();
    }
    @GetMapping(value = "AllMenuList")
    public List<Menu> getAllMenuList(){
        return menuService.getAllMenuList();
    }
    @GetMapping("/count")
    public Integer getMenuCount(){
        System.out.println("menuServer  count" );
        return menuService.count();
    }
    @GetMapping("/datingCount")
    public Integer getdatingCount(){
        System.out.println("menuServer  count" );
        return menuService.getdatingCount();
    }
    @PostMapping("/delete")
    public void deleteById(Integer id) {
//        System.out.println("guhfghqh");
        System.out.println(id + "in8002");
        menuService.deleteById(id);
    }
    @GetMapping("/baofangCount")
    public Integer getbaofangCount(){
        System.out.println("menuServer  count" );
        return menuService.getbaofangCount();
    }

    @PostMapping("/save")
    public void save( Menu menu){
        System.out.println("save menu");
        System.out.println(menu);
        menuService.save(menu);
    }
    @PostMapping("/edit")
    public void edit( Menu menu){

        menuService.update(menu);
    }

}
