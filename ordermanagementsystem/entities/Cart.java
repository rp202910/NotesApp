package org.example.ordermanagementsystem.entities;

import org.example.ordermanagementsystem.utils.RandomKeyGenerator;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private String cartId;
    private final Map<String, Integer> productQuantity;
    private String orderId;


    public Cart(String orderId) {
        this.cartId = RandomKeyGenerator.generateRandomKey("cart");
        this.productQuantity = new HashMap<>();
        this.orderId = orderId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, Integer> getProductQuantities() {
        return productQuantity;
    }

    public Integer getProductQuantity(String productId) {
        return productQuantity.get(productId);
    }

    public void setProductQuantity(String productId, Integer quantity) {
        productQuantity.put(productId, quantity + productQuantity.getOrDefault(productId, 0));
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", productQuantity=" + productQuantity +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
