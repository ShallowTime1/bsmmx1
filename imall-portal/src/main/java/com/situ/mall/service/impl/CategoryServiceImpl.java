package com.situ.mall.service.impl;

import com.situ.mall.mapper.CategoryMapper;
import com.situ.mall.pojo.Category;
import com.situ.mall.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> selectTopCategoryList() {
        return categoryMapper.selectTopCategoryList();
    }

    @Override
    public List<Category> selectSecondCategoryList() {
        return categoryMapper.selectSecondCategoryList();
    }
}
