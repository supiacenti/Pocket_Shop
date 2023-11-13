package com.rajendra.onlineproductsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.rajendra.onlineproductsapp.model.CartManager;

public class ConfirmActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);

        Button button = findViewById(R.id.button6); // Substitua 'button' pelo ID real do seu botão
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartManager.getInstance().clearCart();
                Intent intent = new Intent(ConfirmActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
