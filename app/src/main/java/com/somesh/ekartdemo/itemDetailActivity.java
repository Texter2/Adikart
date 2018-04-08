package com.somesh.ekartdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class itemDetailActivity extends AppCompatActivity {

    Product product;
    TextView productName;
    TextView productPrice;
    TextView productDesc;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_cart:
                    cartActivity();
                    return true;
                case R.id.navigation_buy:
                    buyActivity();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        productName=(TextView)findViewById(R.id.productName);
        productPrice=(TextView)findViewById(R.id.productPrice);
        productDesc=(TextView)findViewById(R.id.productDesc);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        product=(Product) getIntent().getSerializableExtra("Product");
        Log.v("ItemInDetail",product.getProductName());

        productDesc.setText(product.getDescription());
        productName.setText(product.getProductName());
        String price="Cost :"+product.getPrice();
        productPrice.setText(price);

    }

    void buyActivity(){
        Intent intent = new Intent(itemDetailActivity.this,BuyActivity.class);
        intent.putExtra("Product",product);

        startActivity(intent);
    }
    void cartActivity(){
        Intent intent = new Intent(itemDetailActivity.this,CartActivity.class);
        intent.putExtra("Product",product);

        startActivity(intent);
    }

}
