package com.situ.mall.pojo.VO;

import com.situ.mall.pojo.OrderItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderVO {
    private Long orderNo;

    private Date createTime;

    private BigDecimal payment;

    private Integer status;

    private List<OrderItem> list;


    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "orderNo=" + orderNo +
                ", createTime=" + createTime +
                ", payment=" + payment +
                ", status=" + status +
                ", list=" + list +
                '}';
    }
}
