package com.situ.mall.service.impl;

import com.situ.mall.mapper.ShippingMapper;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public List<Shipping> selectByUserId(Integer id) {
        return shippingMapper.selectByUserId(id);
    }
}
