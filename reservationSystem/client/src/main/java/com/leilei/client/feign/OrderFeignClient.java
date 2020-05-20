package com.leilei.client.feign;

import com.leilei.common.Page;
import com.leilei.common.ResultMap;
import com.leilei.entity.MonthSales;
import com.leilei.entity.Ordert;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "ORDERSERVER")
public interface OrderFeignClient {
    @GetMapping("/order/baofangDec")
   Integer decbaofangCount();
    @GetMapping("/order/datingDec")
    Integer decdatingCount();
    @GetMapping("/order/count")
    Integer getMenuCount();
    @PostMapping("/order/save")
    void save( Ordert order);
    @GetMapping(value = "/order/layUiList")
    ResultMap<List<Ordert>> backContent(Page page, @RequestParam("limit") int limit);
    @GetMapping(value = "/order/orderList")
    List<Ordert> getMenuList(@RequestParam("page") String page,@RequestParam("limit") String limit);
    @GetMapping("/order/monthSales")
    List<MonthSales> getMonthSales();
    @GetMapping(value = "/order/orderListUi")
    ResultMap<List<Ordert>> getMenuListUi(@RequestParam("page") String page,@RequestParam("limit") String limit);
}
