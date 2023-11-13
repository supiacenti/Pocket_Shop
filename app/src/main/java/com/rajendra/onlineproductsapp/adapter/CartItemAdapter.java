package com.rajendra.onlineproductsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rajendra.onlineproductsapp.R;
import com.rajendra.onlineproductsapp.model.Products;

import java.util.List;

public class CartItemAdapter extends ArrayAdapter<Products> {
    public CartItemAdapter(Context context, List<Products> cartItems) {
        super(context, 0, cartItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Products product = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_item_layout, parent, false);
        }

        TextView productName = convertView.findViewById(R.id.cart_item_name);
        TextView productPrice = convertView.findViewById(R.id.cart_item_price);

        productName.setText(product.getProductName());
        productPrice.setText(product.getProductPrice());

        return convertView;
    }
}

