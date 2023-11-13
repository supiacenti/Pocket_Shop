package com.rajendra.onlineproductsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rajendra.onlineproductsapp.model.CartManager;

public class FinalActivity extends AppCompatActivity {

    // ... onCreate e outras configurações ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_activity);

        TextView customerNameView = findViewById(R.id.customerName);
        TextView orderTotalView = findViewById(R.id.orderTotal);
        TextView addressDetails = findViewById((R.id.addressDetails));

        String customerName = "Miranda Priestly";
        double orderTotal = getIntent().getDoubleExtra("ORDER_TOTAL", 0.0);

        customerNameView.setText("Nome do Cliente: " + customerName);
        orderTotalView.setText("Valor Total: R$" + String.format("%.2f", orderTotal));
        addressDetails.setText(("Quinta Avenida, Runway\nNova Iorque, EUA\nCEP: 12345-678"));

        Button button = findViewById(R.id.confirmPurchaseButton); // Substitua 'button' pelo ID real do seu botão
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Ocultar a barra de carregamento
                        progressBar.setVisibility(View.GONE);

                        // Mudar para a próxima página
                        Intent intent = new Intent(FinalActivity.this, ConfirmActivity.class);
                        startActivity(intent);
                    }
                }, 2000);
            }
        });
    }
}

