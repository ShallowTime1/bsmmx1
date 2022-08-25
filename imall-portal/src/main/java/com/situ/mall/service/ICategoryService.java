package com.situ.mall.service;

import com.situ.mall.pojo.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> selectTopCategoryList();

    List<Category> selectSecondCategoryList();
}
