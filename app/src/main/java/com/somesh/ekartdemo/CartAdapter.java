package com.somesh.ekartdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Somesh on 08-04-2018.
 */

public class CartAdapter  extends ArrayAdapter<Product> {

    ArrayList<Product> productList = new ArrayList<>();



    public CartAdapter(Context context, int resource, ArrayList<Product> productList) {
        super(context, resource,productList);
        this.productList = productList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.cart_list,parent,false);
        }


        Product currentProduct= getItem(position);


        String productName= currentProduct.getProductName();
        TextView productNameView = (TextView) convertView.findViewById(R.id.productName);
        productNameView.setText(productName.toString());
        double price= currentProduct.getPrice();
        TextView priceView = (TextView) convertView.findViewById(R.id.productPrice);
        priceView.setText(""+Double.toString(price));
        return convertView;

    }
}
