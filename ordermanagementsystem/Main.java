package org.example.ordermanagementsystem;

import org.example.ordermanagementsystem.database.DatabaseStrategy;
import org.example.ordermanagementsystem.database.HashMapStrategy;
import org.example.ordermanagementsystem.entities.Cart;
import org.example.ordermanagementsystem.entities.Coupon;
import org.example.ordermanagementsystem.entities.Product;
import org.example.ordermanagementsystem.enums.DiscountTypeEnum;
import org.example.ordermanagementsystem.service.OrderManagementSystem;
import org.example.ordermanagementsystem.service.OrderMngSystemImpl;

public class Main {

    public static void main(String[] args) {

        DatabaseStrategy db = new HashMapStrategy();


        OrderManagementSystem orderManagementSystem = new OrderMngSystemImpl(db);


        Product cloth = orderManagementSystem.addProduct("tshirt-1", "Polo", 1000);
        Product pant = orderManagementSystem.addProduct("pant-1", "Raymond", 1200);


        Cart cart = orderManagementSystem.addProductToCart(cloth.getProductId(), "cart1");
        cart = orderManagementSystem.addProductToCart(pant.getProductId(), cart.getCartId());

        Coupon mbkCoupon = orderManagementSystem.addCoupon("WELMBK", DiscountTypeEnum.FLAT, 10.0, 1000.0, 5.0);

        orderManagementSystem.applyCoupon(cart.getCartId(), mbkCoupon.getCouponCode());

        orderManagementSystem.viewCart(cart.getCartId());

        orderManagementSystem.completeCart(cart.getCartId());
        orderManagementSystem.viewCart(cart.getCartId());


    }

}


/*

        Products -> product_id , name , price
        Coupons -> discount_type , value , min_purchase_amount , max_discount ,
        cart -> id , {productid , quantiy} , orderId
        Order -> { Original Amount  , Discounted Amount ,  Final Amount ,  couponid , status }






        Question: Order Management System
        A store has Products and Coupons. You can create products and coupons, add products to a cart, apply a coupon, and complete the order.

         Functional Flow:
            Create Products & Coupons:

            You can create a product and a coupon in the system.
            Add Products to Cart:

            If a cart with the given cart_id does not exist, a new cart should be created.
                    Products can be added to the cart with a specified quantity.
            Apply Coupon to Cart:

            Once products are added, a coupon code can be applied to the cart.
            Coupons have:
            discount_type: (percentage or flat)
            value: Discount amount or percentage
            min_purchase_amount: Minimum amount required for the coupon to apply
            max_discount: Maximum discount allowed
            Calculate Discounts:

            After applying a coupon, the system should return:
            Original Amount (Total price before discount)
            Discounted Amount (Total discount applied)
            Final Amount (Price after discount)
            Complete Order:

            Once a coupon is applied, the order can be completed successfully.
                    View Cart:

            The user can view the cart details, including the products, quantities, and applied discounts.
            Functions to Implement:

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