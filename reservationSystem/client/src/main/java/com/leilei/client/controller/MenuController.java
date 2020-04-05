package com.leilei.client.controller;
import com.leilei.client.feign.MenuFeignClient;
import com.leilei.common.Page;
import com.leilei.common.ResultMap;
import com.leilei.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/menu")
public class MenuController {
    @GetMapping(value = "/layUiList")
    @ResponseBody
    public  ResultMap<List<Menu>> backContent(Page page, @RequestParam("limit") int limit){
        System.out.println("menuList feign" );
        System.out.println(page);
        return menuFeignClient.backContent(page,limit);
    }
    @RequestMapping("/hello")
    public String getHello(){
        return "/adminIndex";
    }
    @RequestMapping("/manage")
    public String getManage(){
       return "/menu_manage";
        //return "/menu_edit";
    }
    @GetMapping(value = "/menuList")
    @ResponseBody
    public  List<Menu> getMenuList(String page,String limit){
        System.out.println("test getmenulist");
        return menuFeignClient.getMenuList(page,limit);
    }
    @GetMapping(value = "/menuListUi")
    @ResponseBody
    public  ResultMap<List<Menu>> getMenuListUi(String page,String limit){
        System.out.println("test getmenulist");
        return menuFeignClient.getMenuListUi(page,limit);
    }
    @Autowired
    MenuFeignClient menuFeignClient;
    @GetMapping("/count")
    @ResponseBody
    public Integer getMenuCount(){
        System.out.println("menuFeign  count" );
       return menuFeignClient.getMenuCount();
    }
    @PostMapping("/save")
    public String save(Menu menu){
        menuFeignClient.save(menu);
        return "redirect:/menu/redirect/menu_add";
    }
    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }
    // 上传菜品图片
    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    @ResponseBody
    public Object uploadImg(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String suffix = "";
        String dateStr = "";
        String filepath="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput = null;

        try {
            if (file != null) {
                String originalName = file.getOriginalFilename();
                //System.out.println(originalName);
                suffix = originalName.substring(originalName.lastIndexOf(".") + 1);
                dateStr = new java.text.SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                filepath = "D:\\reservationSystem\\client\\src\\main\\resources\\static\\images\\"+ dateStr + "." + suffix;
                //System.out.println(filepath);
                filepath = filepath.replace("\\", "/");
                File files = new File(filepath);
                //打印查看上传路径
//                System.out.println(filepath);
                if (!files.getParentFile().exists()) {
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
            }
        } catch (Exception e) {
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", map2);
        String realativePath=dateStr + "." + suffix;
        map2.put("src",realativePath );
        return map;
    }
}
