package com.leilei.orderserver.service;

import com.leilei.common.Page;
import com.leilei.entity.Menu;
import com.leilei.entity.MonthSales;
import com.leilei.entity.OrderVo;
import com.leilei.entity.Ordert;

import java.util.List;

public interface OrderService {
    List<Ordert> findAll();
    int count();
    Ordert findById(Integer id);
    void save(Ordert ordert);
    void update(Ordert menu);
    void deleteById(Integer id);
    //分页数据
    List<Ordert> selectPageList(Page page);
    //分页数据总数
    Integer selectPageCount(Page page);

    List<Ordert> findOrderlist(Integer rows);

    List<MonthSales> getMonthSales();

    Integer decbaofangCount();

    Integer decdatingCount();

    List<OrderVo> findOrderVolist(int i);
}
