package org.example.ordermanagementsystem.service;

import org.example.ordermanagementsystem.database.DatabaseStrategy;
import org.example.ordermanagementsystem.entities.Cart;
import org.example.ordermanagementsystem.entities.Coupon;
import org.example.ordermanagementsystem.entities.Order;
import org.example.ordermanagementsystem.entities.Product;
import org.example.ordermanagementsystem.enums.DiscountTypeEnum;
import org.example.ordermanagementsystem.enums.OrderStatusEnum;

public class OrderMngSystemImpl implements OrderManagementSystem {

    private DatabaseStrategy db;

    public OrderMngSystemImpl(DatabaseStrategy db) {
        this.db = db;
    }

    @Override
    public Product addProduct(String productId, String productName, double price) {

        Product product = db.findProductById(productId);
        if (product == null) {
            product = new Product(productId, productName, price);
            return db.createProduct(product);
        }
        return product;

    }

    @Override
    public Coupon addCoupon(String coupon_code, DiscountTypeEnum discountTypeEnum, Double value, Double minPurchaseAmount, Double maxDiscountAmount) {
        Coupon coupon = db.findCouponById(coupon_code);
        if (coupon == null) {
            coupon = new Coupon(coupon_code, discountTypeEnum, value, minPurchaseAmount, maxDiscountAmount);
            db.createCoupon(coupon);
        }
        return coupon;
    }

    @Override
    public Cart addProductToCart(String productId, String cartId) {
        Cart cart = db.findCartById(cartId);
        Product product = db.findProductById(productId);
        Order order;
        if (cart == null) {
            order = new Order(OrderStatusEnum.INITIATED);
            cart = new Cart(order.getOrderId());
            order.setCartId(cartId);
            db.createOrder(order);
        } else {
            order = db.findOrderById(cart.getOrderId());
        }

        order.setOriginalAmount(order.getOriginalAmount() + product.getProductPrice());

        cart.setProductQuantity(productId, 1);

        return db.createCart(cart);

    }

    @Override
    public Order applyCoupon(String cartId, String couponCode) {

        Coupon coupon = db.findCouponById(couponCode);
        Cart cart = db.findCartById(cartId);
        Order order = db.findOrderById(cart.getOrderId());

        if (coupon.getMinPurchaseAmount() <= order.getOriginalAmount()) {

            if (coupon.getDiscountTypeEnum().equals(DiscountTypeEnum.FLAT)) {
                order.setDiscountedAmount(Math.min(coupon.getMaxDiscount(), coupon.getValue()));
            } else {
                order.setDiscountedAmount(Math.min(coupon.getMaxDiscount(), (order.getOriginalAmount() * coupon.getValue()) / 100));
            }

            order.setFinalAmount(order.getOriginalAmount() - order.getDiscountedAmount());
        }

        return order;


    }

    @Override
    public Order completeCart(String cartId) {
        Cart cart = db.findCartById(cartId);
        Order order = db.findOrderById(cart.getOrderId());
        System.out.println("Confirming your order .. : " + order);

        order.setStatus(OrderStatusEnum.COMPLETED);
        System.out.println("ThankYou for purchaisng  : " + order.getFinalAmount());
        return order;
    }

    @Override
    public void viewCart(String cartId) {
        Cart cart = db.findCartById(cartId);
        Order order = db.findOrderById(cart.getOrderId());
        System.out.println("Viewing  your cart  : " + cart);
        System.out.println("Order you are purchasing : " + order);
    }
}
