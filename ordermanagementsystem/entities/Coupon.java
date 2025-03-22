package org.example.ordermanagementsystem.entities;

import org.example.ordermanagementsystem.enums.DiscountTypeEnum;
import org.example.ordermanagementsystem.utils.RandomKeyGenerator;

public class Coupon {


    private String couponCode;
    private DiscountTypeEnum discountTypeEnum;
    private Double value;
    private Double minPurchaseAmount;
    private Double maxDiscount;

    public Coupon(String couponCode, DiscountTypeEnum discountTypeEnum, Double value, Double minPurchaseAmount, Double maxDiscount) {
        this.couponCode = couponCode;
        this.discountTypeEnum = discountTypeEnum;
        this.value = value;
        this.minPurchaseAmount = minPurchaseAmount;
        this.maxDiscount = maxDiscount;
    }

    public DiscountTypeEnum getDiscountTypeEnum() {
        return discountTypeEnum;
    }

    public void setDiscountTypeEnum(DiscountTypeEnum discountTypeEnum) {
        this.discountTypeEnum = discountTypeEnum;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getMinPurchaseAmount() {
        return minPurchaseAmount;
    }

    public void setMinPurchaseAmount(Double minPurchaseAmount) {
        this.minPurchaseAmount = minPurchaseAmount;
    }

    public Double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }


    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponid='" + couponCode + '\'' +
                ", discountTypeEnum=" + discountTypeEnum +
                ", value=" + value +
                ", minPurchaseAmount=" + minPurchaseAmount +
                ", maxDiscount=" + maxDiscount +
                '}';
    }

}
