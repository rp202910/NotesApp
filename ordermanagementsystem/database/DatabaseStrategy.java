package org.example.ordermanagementsystem.database;

import org.example.ordermanagementsystem.entities.Cart;
import org.example.ordermanagementsystem.entities.Coupon;
import org.example.ordermanagementsystem.entities.Order;
import org.example.ordermanagementsystem.entities.Product;

public interface DatabaseStrategy {


    public Order findOrderById(String orderId);
    public Cart findCartById(String cartId);
    public Coupon findCouponById(String couponId);
    public Product findProductById(String productId);

    public Order createOrder(Order order);
    public Product createProduct(Product product);
    public Coupon createCoupon(Coupon coupon);
    public Cart createCart(Cart cart);


}
