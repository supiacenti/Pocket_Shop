package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.rajendra.onlineproductsapp.adapter.ProductAdapter;
import com.rajendra.onlineproductsapp.adapter.ProductCategoryAdapter;
import com.rajendra.onlineproductsapp.model.ProductCategory;
import com.rajendra.onlineproductsapp.model.Products;

import java.util.ArrayList;
import java.util.List;
import android.view.View;


public class MainActivity extends AppCompatActivity {

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
        productsList.add(new Products(1, "Flower Shower", "Spring", "$ 130.00", R.drawable.prod1));
        productsList.add(new Products(2, "Forever 1", "Spring", "$ 50.00", R.drawable.prod2));
        productsList.add(new Products(3, "Jelly", "Winter", "$ 78.00", R.drawable.prod3));
        productsList.add(new Products(4, "Summer Dreams", "Spring", "$ 98.00", R.drawable.prod4));
        productsList.add(new Products(5, "Blossom", "Winter", "$ 73.00", R.drawable.prod5));
        productsList.add(new Products(6, "Gummy", "Winter", "$ 210.00", R.drawable.prod6));

        setProdItemRecycler(productsList);

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



    // Hi all today we are going to make a online product selling app.
    // basically its a cosmatic selling app.
    // The design is very coll and something new from traditional design.
    // But before getting started lets make sure to subscribe and hit
    // the bell icon to get latest update and notified enerytime i post a new video.
    // so lets get started
    // lets app some font and import some image assets
    // Now we will setup a recyclerview for product category list.
    // now we will ad a model class for our category
    // lets create a adapter class for data model
    // Our adapter class is ready Now we will setup recyclerview
    //now we will add some data to our model class
    // Lets run and see
    // so we have setup category recycler.
    // Now in a same way we create a another recycycler view for products
    // first we make model class then adapter
    // product recycler also setup.
    // now we will setup on clicklistener on products and navigate to details activity.
    // lets do this.
    // before going to details page we need cart button in home page and some layout setup.
    // Now its perfect
    // lets move to the details activity.
    // so lets add some animation in this.
    // So this tutorial has been completed if you love my work plz like share and subscribe
    // and dont forget to comments
    // see you in the next video



}
