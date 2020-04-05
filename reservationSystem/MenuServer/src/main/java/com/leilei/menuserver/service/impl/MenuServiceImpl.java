package com.leilei.menuserver.service.impl;

import com.leilei.common.Page;
import com.leilei.entity.Menu;
import com.leilei.menuserver.dao.MenuMapper;
import com.leilei.menuserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    MenuMapper menuMapper;
    @Override
    public List<Menu> findAll() {
        return menuMapper.selectAll();
    }
    @Override
    public List<Menu> selectPageList(Page page) {
        List<Menu>list=menuMapper.selectPageList(page);
        return list;
    }

    @Override
    public Integer selectPageCount(Page page) {
        return menuMapper.selectPageCount(page);
    }

    @Override
    public List<Menu> findMenulist(Integer rows) {
        return menuMapper.findMenulist(rows);
    }

    @Override
    public int count() {
        return menuMapper.count();
    }

    @Override
    public Menu findById(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public void update(Menu menu) {
        menuMapper.updateByPrimaryKey(menu);
    }

    @Override
    public void deleteById(Integer id) {
        menuMapper.deleteByPrimaryKey(id);
    }
}
