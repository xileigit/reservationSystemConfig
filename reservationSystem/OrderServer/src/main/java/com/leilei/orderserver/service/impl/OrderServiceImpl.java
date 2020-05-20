package com.leilei.orderserver.service.impl;

import com.leilei.common.Page;
import com.leilei.entity.MonthSales;
import com.leilei.entity.Ordert;
import com.leilei.orderserver.dao.OrdertMapper;
import com.leilei.orderserver.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrdertMapper ordertMapper;
    @Override
    public List<Ordert> findAll() {
        return ordertMapper.selectAll();
    }

    @Override
    public int count() {
        return ordertMapper.count();
    }

    @Override
    public Ordert findById(Integer id) {
        return ordertMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Ordert ordert) {
        ordertMapper.insert(ordert);
    }

    @Override
    public void update(Ordert ordert) {
        ordertMapper.updateByPrimaryKey(ordert);
    }

    @Override
    public void deleteById(Integer id) {
        ordertMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Ordert> selectPageList(Page page) {
        return ordertMapper.selectPageList(page);
    }

    @Override
    public Integer selectPageCount(Page page) {
        return ordertMapper.selectPageCount(page);
    }

    @Override
    public List<Ordert> findOrderlist(Integer rows) {
        return ordertMapper.findOrderlist(rows);
    }

    @Override
    public List<MonthSales> getMonthSales() {
        return ordertMapper.getMonthSales();
    }

    @Override
    public Integer decbaofangCount() {
        ordertMapper.decbaofangCount();
        return 0;
    }

    @Override
    public Integer decdatingCount() {
        ordertMapper.decdatingCount();
        return 0;
    }
}
