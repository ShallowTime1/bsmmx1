package com.situ.mall.service.impl;

import com.situ.mall.mapper.ProductMapper;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product selectById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> selectListByCategoryId(Integer id) {
        return productMapper.selectListByCategoryId(id);
    }
}
