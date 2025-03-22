package org.example.ordermanagementsystem.entities;

import org.example.ordermanagementsystem.enums.OrderStatusEnum;
import org.example.ordermanagementsystem.utils.RandomKeyGenerator;

public class Order {

    private String orderId;
    private double originalAmount;
    private double discountedAmount;
    private double finalAmount;
    private String couponid;
    private OrderStatusEnum status;
    private String cartId;

    public Order(OrderStatusEnum status) {
        orderId = RandomKeyGenerator.generateRandomKey("order");
        this.status = status;
    }

    public Double getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public Double getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(Double discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getCouponid() {
        return couponid;
    }

    public void setCouponid(String couponid) {
        this.couponid = couponid;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", originalAmount=" + originalAmount +
                ", discountedAmount=" + discountedAmount +
                ", finalAmount=" + finalAmount +
                ", couponid='" + couponid + '\'' +
                ", status=" + status +
                ", cartId='" + cartId + '\'' +
                '}';
    }
}
