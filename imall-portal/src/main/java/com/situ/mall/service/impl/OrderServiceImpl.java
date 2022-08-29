package com.situ.mall.service.impl;

import com.situ.mall.mapper.CartMapper;
import com.situ.mall.mapper.OrderItemMapper;
import com.situ.mall.mapper.OrderMapper;
import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.OrderItem;
import com.situ.mall.pojo.VO.CartVO;
import com.situ.mall.service.IOrderService;
import com.situ.mall.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private SnowFlake snowFlake;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public void add(Order order) {
        long id = snowFlake.nextId();
        order.setOrderNo(id);
        order.setStatus(10);
        List<CartVO> cartVOList = cartMapper.selectByUserIdAndChecked(order.getUserId());
        BigDecimal payment = BigDecimal.valueOf(0.0);
        for (CartVO cartVO : cartVOList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderNo(id);
            orderItem.setUserId(order.getUserId());
            orderItem.setQuantity(cartVO.getQuantity());
            orderItem.setProductId(cartVO.getProductId());
            orderItem.setProductName(cartVO.getProductName());
            orderItem.setCurrentUnitPrice(cartVO.getProductPrice());
            orderItem.setProductImage(cartVO.getProductMainImage());
            BigDecimal productPrice = cartVO.getProductPrice();
            BigDecimal productQuantity = BigDecimal.valueOf(cartVO.getQuantity());
            BigDecimal totalPrice = productPrice.multiply(productQuantity);
            orderItem.setTotalPrice(totalPrice);

            payment = payment.add(totalPrice);
            orderItemMapper.insert(orderItem);
        }
        orderMapper.insert(order);
    }
}
