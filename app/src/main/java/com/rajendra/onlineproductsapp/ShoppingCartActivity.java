package com.rajendra.onlineproductsapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.rajendra.onlineproductsapp.adapter.CartItemAdapter;
import com.rajendra.onlineproductsapp.model.CartManager;
import com.rajendra.onlineproductsapp.model.Products;

import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity{
    private ListView listViewShoppingCart;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);

        listViewShoppingCart = findViewById(R.id.listViewShoppingCart);

        List<Products> cartItems = CartManager.getInstance().getCartItems();
        CartItemAdapter adapter = new CartItemAdapter(this, cartItems);
        listViewShoppingCart.setAdapter(adapter);

        Button button = findViewById(R.id.buttonCheckout); // Substitua 'button' pelo ID real do seu botão
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = CartManager.getInstance().calculateTotal();
                Intent intent = new Intent(ShoppingCartActivity.this, FinalActivity.class);
                intent.putExtra("ORDER_TOTAL", total);
                startActivity(intent);
            }
        });
    }
}
