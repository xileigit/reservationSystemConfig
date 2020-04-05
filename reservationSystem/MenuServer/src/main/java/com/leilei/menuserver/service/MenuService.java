package com.leilei.menuserver.service;

import com.leilei.common.Page;
import com.leilei.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> findAll();
    int count();
    Menu findById(Integer id);
    void save(Menu menu);
    void update(Menu menu);
    void deleteById(Integer id);
    //分页数据
    List<Menu> selectPageList(Page page);
    //分页数据总数
    Integer selectPageCount(Page page);

    List<Menu> findMenulist(Integer rows);
}
