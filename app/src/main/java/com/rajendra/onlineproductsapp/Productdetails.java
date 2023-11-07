package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Productdetails extends AppCompatActivity {

    private int cartItemCount = 0;
    private Button addToCartButton;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);
        sharedPreferences = getSharedPreferences("cart_prefs", MODE_PRIVATE);

        // Retrieve the current cart item count value
        cartItemCount = sharedPreferences.getInt("cartItemCount", 0);

        // Find the "Add to Cart" button based on its ID
        addToCartButton = findViewById(R.id.button2);

        // Set a click listener for the "Add to Cart" button
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Increment the cart item count
                cartItemCount++;

                // Update the button text with the new cart item count
                updateButtonText(cartItemCount);
                // Save the updated cart item count in SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("cartItemCount", cartItemCount);
                editor.apply();
            }
        });

        // Set the initial text of the button
        updateButtonText(cartItemCount);
    }

    private void updateButtonText(int itemCount) {
        // Update the text of the button with the current cart item count
        addToCartButton.setText("Add to Cart (" + itemCount + ")");
    }

}
