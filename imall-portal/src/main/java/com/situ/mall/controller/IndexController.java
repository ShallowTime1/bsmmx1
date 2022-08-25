package com.situ.mall.controller;


import com.situ.mall.pojo.Category;
import com.situ.mall.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("IndexController.index");
        List<Category> topCategoryList = redisTemplate.opsForList().range("topCategoryList", 0, -1);
        if (CollectionUtils.isEmpty(topCategoryList)) {
            topCategoryList = categoryService.selectTopCategoryList();
            redisTemplate.opsForList().rightPushAll("topCategoryList", topCategoryList);
        }
        List<Category> secondCategoryList = redisTemplate.opsForList().range("secondCategoryList", 0, -1);
        if (CollectionUtils.isEmpty(secondCategoryList)) {
            secondCategoryList = categoryService.selectSecondCategoryList();
            redisTemplate.opsForList().rightPushAll("secondCategoryList", secondCategoryList);
        }
//        List<Category> topCategoryList = categoryService.selectTopCategoryList();
//        List<Category> secondCategoryList = categoryService.selectSecondCategoryList();
        model.addAttribute("topCategoryList", topCategoryList);
        model.addAttribute("secondCategoryList", secondCategoryList);
        return "index";
    }


}
