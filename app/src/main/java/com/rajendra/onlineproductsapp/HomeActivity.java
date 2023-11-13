package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rajendra.onlineproductsapp.adapter.ProductAdapter;
import com.rajendra.onlineproductsapp.adapter.ProductCategoryAdapter;
import com.rajendra.onlineproductsapp.model.ProductCategory;
import com.rajendra.onlineproductsapp.model.Products;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Trending"));
        productCategoryList.add(new ProductCategory(2, "Mais Populares"));
        productCategoryList.add(new ProductCategory(3, "Todos os Produtos"));
        productCategoryList.add(new ProductCategory(4, "Vestidos"));
        productCategoryList.add(new ProductCategory(5, "Sapatos"));
        setProductRecycler(productCategoryList);

        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Flower Shower", "Spring", "R$ 130.00", R.drawable.prod1));
        productsList.add(new Products(2, "Forever 1", "Spring", "R$ 50.00", R.drawable.prod2));
        productsList.add(new Products(3, "Jelly", "Winter", "R$ 78.00", R.drawable.prod3));
        productsList.add(new Products(4, "Summer Dreams", "Spring", "R$ 98.00", R.drawable.prod4));
        productsList.add(new Products(5, "Blossom", "Winter", "R$ 73.00", R.drawable.prod5));
        productsList.add(new Products(6, "Gummy", "Winter", "R$ 210.00", R.drawable.prod6));

        setProdItemRecycler(productsList);

        Button button = findViewById(R.id.button); // Substitua 'button' pelo ID real do seu botão
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setProductRecycler(List<ProductCategory> productCategoryList){

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);

    }

    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

    }
}
