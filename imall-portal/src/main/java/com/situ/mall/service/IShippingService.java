package com.situ.mall.service;

import com.situ.mall.pojo.Shipping;

import java.util.List;

public interface IShippingService {
    List<Shipping> selectByUserId(Integer id);
}
