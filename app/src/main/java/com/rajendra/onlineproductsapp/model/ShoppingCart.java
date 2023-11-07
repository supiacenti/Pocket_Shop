package com.rajendra.onlineproductsapp.model;
import java.util.List;
import java.util.ArrayList;
public class ShoppingCart {
    private List<Products> cartItems;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addItem(Products product) {
        cartItems.add(product);
    }

    public List<Products> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }
}
