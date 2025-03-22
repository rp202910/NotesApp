package org.example.ordermanagementsystem.service;

import org.example.ordermanagementsystem.entities.Cart;
import org.example.ordermanagementsystem.entities.Coupon;
import org.example.ordermanagementsystem.entities.Order;
import org.example.ordermanagementsystem.entities.Product;
import org.example.ordermanagementsystem.enums.DiscountTypeEnum;

public interface OrderManagementSystem {

    /*
  1. addProduct(product_id, name, price)
                - Adds a new product to the store.

            2. addCoupon(coupon_code, discount_type, value, min_purchase_amount, max_discount)
                - Creates a new coupon.

        3. addProductToCart(cart_id, product_id, quantity)
                - Adds a product to a cart. If the cart does not exist, create a new one.

        4. applyCoupon(cart_id, coupon_code)
                - Applies the coupon to the cart.
            - Should print:
            - Original Amount
                    - Discounted Amount
                    - Final Amount

        5. completeCart(cart_id)
                - Completes the order and finalizes the purchase.

        6. viewCart(cart_id)
                - Displays cart details including products, quantities, and applied discounts.
        */


    public Product addProduct(String productId, String productName, double price);

    public Coupon addCoupon(String coupon_code, DiscountTypeEnum discountTypeEnum, Double value, Double minPurchaseAmount, Double maxDiscountAmount);

    public Cart addProductToCart(String productId, String cartId);

    public Order applyCoupon(String cartId, String couponCode);

    public Order completeCart(String cartId);

    public void viewCart(String cartId);


}

