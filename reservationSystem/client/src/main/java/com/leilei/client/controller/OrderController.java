package com.leilei.client.controller;
import com.leilei.client.feign.OrderFeignClient;
import com.leilei.common.Page;
import com.leilei.common.ResultMap;
import com.leilei.entity.Menu;
import com.leilei.entity.MonthSales;
import com.leilei.entity.Ordert;
import com.leilei.entity.SeatOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping("/order")
public class OrderController {
    @GetMapping(value = "/layUiList")
    @ResponseBody
    public  ResultMap<List<Ordert>> backContent(Page page, @RequestParam("limit") int limit){
//        System.out.println("menuList feign" );
//        System.out.println(page);
        return orderFeignClient.backContent(page,limit);
    }
    @RequestMapping("/hello")
    public String getHello(){
        System.out.println("submit form");
        return "/adminIndex";
    }
    @RequestMapping("/manage")
    public String getManage(){
        return "/menu_manage";
        //return "/menu_edit";
    }
    @GetMapping(value = "/menuList")
    @ResponseBody
    public  List<Ordert> getMenuList(String page,String limit){
        System.out.println("test getmenulist");
        return orderFeignClient.getMenuList(page,limit);
    }
    @GetMapping(value = "/menuListUi")
    @ResponseBody
    public  ResultMap<List<Ordert>> getMenuListUi(String page,String limit){
        System.out.println("test getmenulist");
        return orderFeignClient.getMenuListUi(page,limit);
    }
    @Autowired
    OrderFeignClient orderFeignClient;
    @GetMapping("/count")
    @ResponseBody
    public Integer getMenuCount(){
        System.out.println("menuFeign  count" );
        return orderFeignClient.getMenuCount();
    }
    @GetMapping("/getMonthSales")
    @ResponseBody
    List<MonthSales> getMonthSales(){
        return orderFeignClient.getMonthSales();
    }
    @PostMapping("/save")
    public String save(SeatOrder ordert, HttpServletRequest request){
        request.getSession().setAttribute("SEAT_ORDER",ordert);
        System.out.println(ordert);
        if(ordert.getType()==1){
            orderFeignClient.decbaofangCount();
        }
        else if (ordert.getType()==0){
            orderFeignClient.decdatingCount();
        }
        //orderFeignClient.save(ordert);
        return "blog";
//        return "order_add";
    }
    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }
}
