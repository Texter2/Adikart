package com.somesh.ekartdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {


    Product product;
    static List<Product> productList= new ArrayList<>();
    CartAdapter mAdapter;
    ListView cartListView;
    TextView amount;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_buy:
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        amount=(TextView)findViewById(R.id.amount);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        product=(Product) getIntent().getSerializableExtra("Product");
        productList.add(product);
        cartListView = (ListView) findViewById(R.id.cartListView);
        mAdapter = new CartAdapter(this, R.id.cartListView, new ArrayList<Product>());


        cartListView.setAdapter(mAdapter);

        mAdapter.clear();
        Log.e("Cart",""+productList.size());
        calculateCartAmount();


        mAdapter.addAll(productList);

        cartListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product item = (Product) adapterView.getItemAtPosition(i);

                productList.remove(item);
                mAdapter.remove(item);

                calculateCartAmount();

            }
        });
    }





    void calculateCartAmount(){
        double price=0.0;

        for (Product p:productList){
            price=price+p.getPrice();
        }
        if(price==0.0){
            amount.setText("");
        }
        else {
            Log.v("Cart Price", "" + price);
            String total = "Total Amount :" + price;
            amount.setText(total);


        }


    }

}
