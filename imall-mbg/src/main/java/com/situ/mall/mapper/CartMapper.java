package com.situ.mall.mapper;

import com.situ.mall.pojo.Cart;
import com.situ.mall.pojo.VO.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<CartVO> selectByUserId(Integer id);

    int selectCountByUserIdAndProductId(Cart cart);

    void updateQuantityByUserIdAndProductId(Cart cart);

    void updateChecked(@Param("id") Integer id, @Param("checked") Integer checked);

    List<CartVO> selectByUserIdAndChecked(Integer id);
}