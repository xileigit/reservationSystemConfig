package com.leilei.client.feign;

import com.leilei.common.Page;
import com.leilei.common.ResultMap;
import com.leilei.entity.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
@FeignClient(name = "MENUSERVER")
public interface MenuFeignClient {
    @GetMapping("/menu/count")
    Integer getMenuCount();
    @PostMapping("/menu/save")
    void save( Menu menu);
    @GetMapping(value = "/menu/layUiList")
    ResultMap<List<Menu>> backContent(Page page, @RequestParam("limit") int limit);
    @GetMapping(value = "/menu/menuList")
    List<Menu> getMenuList(@RequestParam("page") String page,@RequestParam("limit") String limit);

    @GetMapping(value = "/menu/menuListUi")
    ResultMap<List<Menu>> getMenuListUi(@RequestParam("page") String page,@RequestParam("limit") String limit);
    @GetMapping(value = "/menu/getIndexMenu")
    List<Menu> getIndexMenu();
    @GetMapping(value = "/menu/datingCount")
    Integer getdatingCount();
    @GetMapping(value = "/menu/baofangCount")
    Integer getbaofangCount();
    @PostMapping(value = "/menu/delete")
    void deleteById(Integer id);
    @GetMapping(value = "/menu/AllMenuList")
    List<Menu> getAllMenuList();
    @PostMapping("/menu/edit")
    void edit(Menu menu);
    // @GetMapping(value = "/menu/layUiList" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
   // ResultMap<List<Menu>> backContent(@RequestParam("page") Page page, @RequestParam("limit") int limit);
}
