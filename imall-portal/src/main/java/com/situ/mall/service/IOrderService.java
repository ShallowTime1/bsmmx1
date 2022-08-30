package com.situ.mall.service;

import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.VO.OrderVO;

import java.util.List;

public interface IOrderService {
    void add(Order order);

    List<OrderVO> selectOrderVOByUserId(Integer id);
}
