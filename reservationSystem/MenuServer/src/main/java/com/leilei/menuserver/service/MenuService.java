package com.leilei.menuserver.service;

import com.leilei.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> findAll();
    int count();
    Menu findById(Integer id);
    void save(Menu menu);
    void update(Menu menu);
    void deleteById(Integer id);
}
