package com.leilei.orderserver.dao;

import com.leilei.common.Page;
import com.leilei.entity.MonthSales;
import com.leilei.entity.Ordert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrdertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ordert record);

    Ordert selectByPrimaryKey(Integer id);

    List<Ordert> selectAll();

    int updateByPrimaryKey(Ordert record);

    int count();

    List<Ordert> selectPageList(Page page);

    Integer selectPageCount(Page page);

    List<Ordert> findOrderlist(Integer rows);

    List<MonthSales> getMonthSales();
}