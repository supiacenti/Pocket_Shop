package com.rajendra.onlineproductsapp.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.onlineproductsapp.Productdetails;
import com.rajendra.onlineproductsapp.R;
import com.rajendra.onlineproductsapp.model.Products;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Products> productsList;


    public ProductAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.products_row_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        final Products product = productsList.get(position);
        holder.prodImage.setImageResource(product.getImageUrl());
        holder.prodName.setText(product.getProductName());
        holder.prodQty.setText(product.getProductQty());
        holder.prodPrice.setText(product.getProductPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Productdetails.class);
                i.putExtra("PRODUCT_ID", product.getProductid());
                i.putExtra("PRODUCT_NAME", product.getProductName());
                i.putExtra("PRODUCT_QTY", product.getProductQty());
                i.putExtra("PRODUCT_PRICE", product.getProductPrice());
                i.putExtra("PRODUCT_IMAGE", product.getImageUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView prodImage;
        TextView prodName, prodQty, prodPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImage = itemView.findViewById(R.id.prod_image);
            prodName = itemView.findViewById(R.id.prod_name);
            prodPrice = itemView.findViewById(R.id.prod_price);
            prodQty = itemView.findViewById(R.id.prod_qty);


        }
    }

}
