package org.example.ordermanagementsystem.database;

import org.example.ordermanagementsystem.entities.Cart;
import org.example.ordermanagementsystem.entities.Coupon;
import org.example.ordermanagementsystem.entities.Order;
import org.example.ordermanagementsystem.entities.Product;

import java.util.HashMap;

public class HashMapStrategy implements DatabaseStrategy {

    private HashMap<String, Order> orders;
    private HashMap<String, Product> products;
    private HashMap<String, Coupon> coupons;
    private HashMap<String, Cart> carts;

    public HashMapStrategy() {
        orders = new HashMap<>();
        products = new HashMap<>();
        coupons = new HashMap<>();
        carts = new HashMap<>();
    }

    @Override
    public Order findOrderById(String orderId) {
        return orders.get(orderId);
    }

    @Override
    public Cart findCartById(String cartId) {
        return carts.get(cartId);
    }

    @Override
    public Coupon findCouponById(String couponId) {
        return coupons.get(couponId);
    }

    @Override
    public Product findProductById(String productId) {
        return products.get(productId);
    }

    @Override
    public Order createOrder(Order order) {
        orders.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public Product createProduct(Product product) {
        products.put(product.getProductId(), product);
        return product;
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {
        coupons.put(coupon.getCouponCode(), coupon);
        return coupon;
    }

    @Override
    public Cart createCart(Cart cart) {
        carts.put(cart.getCartId(), cart);
        return cart;
    }
}
