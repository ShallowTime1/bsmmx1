package com.situ.mall.service.impl;

import com.situ.mall.mapper.CartMapper;
import com.situ.mall.pojo.Cart;
import com.situ.mall.pojo.VO.CartVO;
import com.situ.mall.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void add(Cart cart) {
        int count = cartMapper.selectCountByUserIdAndProductId(cart);
        if (count >= 1) {
            cartMapper.updateQuantityByUserIdAndProductId(cart);
        } else {
            cartMapper.insert(cart);
        }
    }

    @Override
    public List<CartVO> selectByUserId(Integer id) {
        return cartMapper.selectByUserId(id);
    }

    @Override
    public void updateChecked(Integer id, Integer checked) {
        cartMapper.updateChecked(id, checked);
    }

    @Override
    public List<CartVO> selectByUserIdAndChecked(Integer id) {
        return cartMapper.selectByUserIdAndChecked(id);
    }
}
