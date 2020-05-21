package com.leilei.orderserver.controller;

import com.leilei.common.Page;
import com.leilei.common.ResultMap;
import com.leilei.entity.MonthSales;
import com.leilei.entity.OrderVo;
import com.leilei.entity.Ordert;
import com.leilei.orderserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping(value = "/layUiList")
    public ResultMap<List<Ordert>> backContent(Page page, @RequestParam("limit") int limit){
        System.out.println("menuList server");
        System.out.println("backContent========================"+limit);
        page.setRows(limit);
        System.out.println("page:"+page.toString());
        List<Ordert> productList=orderService.selectPageList(page);
        int totals=orderService.count();
        // page.setTotalRecord(totals);

//        for (Product p:productList) {
//            System.out.println(p);
//        }
        return new ResultMap<List<Ordert>>("",productList,0,totals);
    }
    @GetMapping(value = "/orderList")
    public  List<Ordert> getOrderList(String page,String limit){
        return orderService.findAll();
    }
    @GetMapping(value = "/orderVoListUi")
    ResultMap<List<OrderVo>> getOrderVoListUi(@RequestParam("page") String page, @RequestParam("limit") String limit){
        List<OrderVo> productList=orderService.findOrderVolist(Integer.parseInt(limit));
        int totals=orderService.count();
        // page.setTotalRecord(totals);
//        for (Product p:productList) {
//            System.out.println(p);
//        }
        return new ResultMap<List<OrderVo>>("",productList,0,totals);
    }


    @GetMapping(value = "/orderListUi")
    public  ResultMap<List<Ordert>> getOrderListui(String page,String limit){
        System.out.println("menuList server");
        System.out.println("backContent========================"+limit);
//        page.setRows(limit);
        System.out.println("page:"+page.toString());
        List<Ordert> productList=orderService.findOrderlist(Integer.parseInt(limit));
        int totals=orderService.count();
        // page.setTotalRecord(totals);

//        for (Product p:productList) {
//            System.out.println(p);
//        }
        return new ResultMap<List<Ordert>>("",productList,0,totals);
    }



    @GetMapping("/count")
    public Integer getOrderCount(){
        System.out.println("menuServer  count" );
        return orderService.count();
    }
    @PostMapping("/save")
    public void save( Ordert ordert){
        System.out.println("order save");
        System.out.println(ordert);
        orderService.save(ordert);
    }

    @RequestMapping("/monthSales")
    @ResponseBody
    public List<MonthSales> getMonthSales(){
        List<MonthSales> monthSalesList=  orderService.getMonthSales();
        for (MonthSales monthSales:monthSalesList){
            System.out.println(monthSales);
        }
        return monthSalesList;
    }

    @GetMapping("/baofangDec")
    public Integer decbaofangCount(){
        System.out.println("定保方  count" );
        return orderService.decbaofangCount();
    }
    @GetMapping("/datingDec")
    public Integer decdatingCount(){
        System.out.println("定保方  count" );
        return orderService.decdatingCount();
    }

}
