package com.ketai.house.controller;

import com.alibaba.fastjson.JSON;
import com.ketai.house.service.DistrictService;
import com.ketai.house.service.HouseService;
import com.ketai.house.service.TypesService;
import com.ketai.house.utils.PageUtils;
import com.ketai.house.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author naruto
 * @date 2018/10/17 11:50
 */
@Controller
public class HouseController {

    @Autowired
    HouseService houseService;
    @Autowired
    DistrictService districtService;
    @Autowired
    TypesService typesService;

    @RequestMapping("/list.html")
    public String getAll(@RequestParam Map<String,String> searchMap, Model model){
        System.out.println("************searchHouse参数为" + searchMap);
        Integer indexPage = 1;
        int rowCount = houseService.getRowCount(searchMap);
        if(StringUtils.isNotBlank(searchMap,StringUtils.INDEX_PAGE)){
            indexPage = Integer.valueOf(searchMap.get(StringUtils.INDEX_PAGE));
        }
        if(indexPage!=1 && indexPage>rowCount){
            indexPage=rowCount;
            searchMap.put(StringUtils.INDEX_PAGE,indexPage.toString());
        }
        PageUtils page = new PageUtils();
        page.setCurrentPage(indexPage);
        page.setRowCount(rowCount);

        model.addAttribute("typeList",typesService.findAll());
        model.addAttribute("districtList",districtService.findAll());
        model.addAttribute("houseList",houseService.findSearch(searchMap));
        model.addAttribute("searchMap",searchMap);
        System.out.println("page"+JSON.toJSONString(page));
        model.addAttribute("page",page);
        return "index";
    }

    @GetMapping("")
    @ResponseBody
    public String deleteHouse(Integer hid){
        return houseService.deleteById(hid)?"true":"false";
    }
}
