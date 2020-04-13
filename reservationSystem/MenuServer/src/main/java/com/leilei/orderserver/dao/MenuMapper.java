package com.leilei.orderserver.dao;
import com.leilei.common.Page;
import com.leilei.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Menu record);
    Menu selectByPrimaryKey(Integer id);
    List<Menu> selectAll();
    int updateByPrimaryKey(Menu record);

    int count();

    List<Menu> selectPageList(Page page);

    Integer selectPageCount(Page page);

    List<Menu> findMenulist(Integer rows);
}