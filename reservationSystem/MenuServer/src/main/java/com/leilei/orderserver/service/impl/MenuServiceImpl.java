package com.leilei.orderserver.service.impl;

import com.leilei.common.Page;
import com.leilei.entity.Menu;
import com.leilei.orderserver.dao.MenuMapper;
import com.leilei.orderserver.service.MenuService;
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
    public List<Menu> getIndexMenu() {
        return menuMapper.getIndexMenu() ;
    }

    @Override
    public Integer getdatingCount() {
        return menuMapper.getdatingCount();
    }

    @Override
    public Integer getbaofangCount() {
        return menuMapper.getbaofangCount();
    }

    @Override
    public List<Menu> getAllMenuList() {
        return menuMapper.selectAll();
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
