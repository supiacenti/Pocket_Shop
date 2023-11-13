package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rajendra.onlineproductsapp.model.CartManager;
import com.rajendra.onlineproductsapp.model.Products;

public class Productdetails extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);

        ImageView productImage = findViewById(R.id.imageView7);
        TextView productName = findViewById(R.id.textView12);
        TextView productPrice = findViewById(R.id.textView11);
        Button addToCartButton = findViewById(R.id.button2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("PRODUCT_NAME");
        String price = intent.getStringExtra("PRODUCT_PRICE");
        int imageResId = intent.getIntExtra("PRODUCT_IMAGE", 0);

        productName.setText(name);
        productPrice.setText(price);
        if (imageResId != 0) {
            productImage.setImageResource(imageResId);
        }

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String name = intent.getStringExtra("PRODUCT_NAME");
                String marca = intent.getStringExtra("PRODUCT_QTY");
                String price = intent.getStringExtra("PRODUCT_PRICE");
                int imageResId = intent.getIntExtra("PRODUCT_IMAGE", 0);
                int productId = intent.getIntExtra("PRODUCT_ID", -1);

                Products product = new Products(productId, name, marca, price, imageResId);
                CartManager.getInstance().addToCart(product);

                Toast.makeText(Productdetails.this, "Produto adicionado ao carrinho", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
