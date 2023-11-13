package com.rajendra.onlineproductsapp.model;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance = new CartManager();
    private List<Products> cartItems = new ArrayList<>();

    private CartManager() {}

    public static CartManager getInstance() {
        return instance;
    }

    public void addToCart(Products product) {
        cartItems.add(product);
    }

    public List<Products> getCartItems() {
        return cartItems;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Products product : cartItems) {
            String priceString = product.getProductPrice().replace("R$", "").trim(); // Ajuste conforme necessário
            try {
                double price = Double.parseDouble(priceString);
                total += price;
            } catch (NumberFormatException e) {
                // Lidar com o erro, caso o preço não seja um número válido
            }
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
    }

    // Outros métodos relacionados ao carrinho...
}
