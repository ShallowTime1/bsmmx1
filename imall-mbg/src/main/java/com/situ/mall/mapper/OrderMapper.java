package com.situ.mall.mapper;

import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.VO.OrderVO;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderNo);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderNo);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderVO> selectOrderVOByUserId(Integer id);
}