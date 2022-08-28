package com.situ.mall.pojo.VO;

import com.situ.mall.util.ImageServerUtil;

import java.math.BigDecimal;

public class CartVO {

    private Integer id;
    private Integer userId;
    private Integer productId;
    private String productName;
    private String productMainImage;
    private BigDecimal productPrice;
    private Integer quantity;
    private Integer checked;

    public String getMainImageUrl() {
        return ImageServerUtil.getImageUrl(productMainImage);
    }

    public CartVO() {
    }

    public CartVO(Integer id, Integer userId, Integer productId, String productName, String productMainImage, BigDecimal productPrice, Integer quantity, Integer checked) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.productName = productName;
        this.productMainImage = productMainImage;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.checked = checked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductMainImage() {
        return productMainImage;
    }

    public void setProductMainImage(String productMainImage) {
        this.productMainImage = productMainImage;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productMainImage='" + productMainImage + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                ", checked=" + checked +
                '}';
    }
}
