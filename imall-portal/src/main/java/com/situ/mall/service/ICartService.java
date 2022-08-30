package com.situ.mall.service;

import com.situ.mall.pojo.Cart;
import com.situ.mall.pojo.VO.CartVO;

import java.util.List;

public interface ICartService {
    void add(Cart cart);

    List<CartVO> selectByUserId(Integer id);

    void updateChecked(Integer id, Integer checked);

    List<CartVO> selectByUserIdAndChecked(Integer id);

    void deleteById(Integer id);
}
