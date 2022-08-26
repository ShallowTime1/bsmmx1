package com.situ.mall.service;

import com.situ.mall.pojo.Product;

import java.util.List;

public interface IProductService {
    Product selectById(Integer id);

    List<Product> selectListByCategoryId(Integer id);
}
