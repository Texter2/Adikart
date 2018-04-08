package com.somesh.ekartdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ProductAdapter  mAdapter;
    List<Product> productList= new ArrayList<>();
    ListView matchesListView;
    FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    TextView usernameTV;
    TextView userIDTV;

    List<Product> productList1= new ArrayList<>();
    List<Product> productList2= new ArrayList<>();
    List<Product> productList3= new ArrayList<>();
    List<Product> productList4= new ArrayList<>();
    List<Product> productList5= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userIDTV=(TextView) findViewById(R.id.userID);
        usernameTV=(TextView)findViewById(R.id.userName);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null){

            firebaseUser=mAuth.getCurrentUser();
            String username=firebaseUser.getDisplayName();
            String email=firebaseUser.getEmail();

       //     usernameTV.setText("U");
        //    userIDTV.setText("V");

        }

         matchesListView = (ListView) findViewById(R.id.listView);


        mAdapter = new ProductAdapter(this, R.id.listView, new ArrayList<Product>());


        matchesListView.setAdapter(mAdapter);
        mAdapter.clear();
        Log.v("TAGm1","done");

        Product product = new Product(1,"Medicine",234.00,"It is simple medicine");
        Product product1 = new Product(2,"Syringe",121.00,"It is simple medicine");
        Product product2 = new Product(3,"Tablet",22.00,"It is simple medicine");




        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        mAdapter.addAll(productList);


        Product product3=new Product(4,"Endoscope",2311,"A endoscope is flexible tube attached with a light and a camera. It is equipment which is inserted into the body to give a detailed view of inner parts. It is commonly inserted into body through mouth, anus or a small surgical cut.");

        Product product4=new Product(5,"CT SACN machine",234000,"Computed Tomography scan commonly known as CT scan is a large ring shaped machine. It makes use of X-Rays to generate clear and detailed pictures of inside of a human body.");

        productList1.add(product3);
        productList1.add(product4);
        Product product5=new Product(6,"Ultrasonic stone disintegration apparatus",2300,"used to break down kidney stones into smaller fragments to allow them to pass out without the need of any surgery");

        Product product6=new Product(7,"Cystoscope",21200,"an endoscope to view the urinary passage");
        productList2.add(product5);
        productList2.add(product6);
        Product product7=new Product(8,"Gastroscope",21200,"an endoscope to view the urinary passage");
        Product product8=new Product(9,"Colonoscope",21200,"an endoscope to view the urinary passage");
        Product product9=new Product(10,"Balloon dilator",21200,"an endoscope to view the urinary passage");
        productList3.add(product7);
        productList3.add(product8);
        productList3.add(product9);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        matchesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Product item = (Product) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(MainActivity.this,itemDetailActivity.class);
                Log.v("Name",item.getProductName());
                intent.putExtra("Product",item);
                startActivity(intent);

            }
        });
        }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_radiology) {
mAdapter.clear();
mAdapter.addAll(productList1);
        } else if (id == R.id.nav_urology) {
            mAdapter.clear();
            mAdapter.addAll(productList2);
        } else if (id == R.id.nav_gastroenterology) {
            mAdapter.clear();
            mAdapter.addAll(productList3);
        } else if (id == R.id.nav_orthopedics) {

        } else if (id == R.id.nav_reproductive) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }









}
