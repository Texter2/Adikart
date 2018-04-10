package com.somesh.ekartdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    List<Product> productList = new ArrayList<>();
    ListView matchesListView;
    FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    TextView usernameTV;
    TextView userIDTV;
    ImageView userImage;
    List<Product> productList1 = new ArrayList<>();
    List<Product> productList2 = new ArrayList<>();
    List<Product> productList3 = new ArrayList<>();
    private ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        userIDTV = (TextView) navigationView.getHeaderView(0).findViewById(R.id.userID);
        usernameTV = (TextView) navigationView.getHeaderView(0).findViewById(R.id.userName);
        userImage = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.navImageView);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {

            firebaseUser = mAuth.getCurrentUser();
            String username = firebaseUser.getDisplayName();
            String email = firebaseUser.getEmail();

            usernameTV.setText(username);
            userIDTV.setText(email);


        }

        matchesListView = (ListView) findViewById(R.id.listView);


        mAdapter = new ProductAdapter(this, R.id.listView, new ArrayList<Product>());


        matchesListView.setAdapter(mAdapter);
        mAdapter.clear();
        Log.v("TAGm1", "done");

        Product product70 = new Product(1, "UNIVERSAL ACTIVE CORD", 2340.00, "");
        Product product71 = new Product(1, "ACUSNARE POLYPECTOMY SNARE", 8234.00, "");
        Product product72 = new Product(1, "CYTOLOGY BRUSH SINGLE. ", 2114.00, "");
        Product product73 = new Product(1, "QUICKSILVER BIPOLAR COAGULATION PROBE", 9834.00, "");
        Product product74 = new Product(1, "COLON DECOMPRESSION SET", 2139, "");
        Product product75 = new Product(1, "CAESAR GRASPING FORCEPS", 8787, "");
        Product product76 = new Product(1, "COTTON-LEUNG BILIARY STENT SET", 6999, "");
        Product product77 = new Product(1, "BILIARY STENT. ", 8499, "");
        Product product78 = new Product(1, "COTTON CANNULATOME II PC PROTECTOR", 2599, "");
        Product product79 = new Product(1, "CAPTURA SERRATED FORCEPS W/O SPIKE", 4789.00, "");


        productList.add(product70);
        productList.add(product71);
        productList.add(product72);
        productList.add(product73);
        productList.add(product74);
        productList.add(product75);
        productList.add(product76);
        productList.add(product77);
        productList.add(product78);
        productList.add(product79);
        mAdapter.addAll(productList);


        Product product3 = new Product(4, "CATHETER ACCESS PERCUTANEOUS ENTRY NEEDLE", 300, "A endoscope is flexible tube attached with a light and a camera. It is equipment which is inserted into the body to give a detailed view of inner parts. It is commonly inserted into body through mouth, anus or a small surgical cut.");

        Product product31 = new Product(5, "AMPLATZ VASCULAR OBSTRUCTION DEVICE", 5100, "Computed Tomography scan commonly known as CT scan is a large ring shaped machine. It makes use of X-Rays to generate clear and detailed pictures of inside of a human body.");
        Product product32 = new Product(4, "ATB ADVANCE BALLOON CATHETER", 6200, "");
        Product product33 = new Product(4, "ANGLED WIRE LOOP RETRIEVER", 2400, "");
        Product product34 = new Product(4, "ONE-PART PERCUTANEOUS ENTRY NEEDLE", 800, "");
        Product product35 = new Product(4, "SPHERE INFLATION DEVICE", 2000, "");
        Product product36 = new Product(4, "APPROACH CTO MICROWIRE GUIDE", 6100, "");
        Product product37 = new Product(4, "CURRY INTRAVASCULAR RETRIEVER SET", 12300, "");
        Product product38 = new Product(4, "CXI-SUPPORT CATHETER", 10000, "");
        Product product39 = new Product(4, "COOK FLEXIBLE BIOPSY FORCEPS", 16231, "");

        productList1.add(product3);
        productList1.add(product31);
        productList1.add(product32);
        productList1.add(product33);
        productList1.add(product34);
        productList1.add(product35);
        productList1.add(product36);
        productList1.add(product37);
        productList1.add(product38);
        productList1.add(product39);

        mAdapter.addAll(productList1);


        Product product68 = new Product(6, "BILIARY DRAINAGE STENT", 850, "");

        Product product60 = new Product(7, "BILIARY PUSHER", 800, "");
        Product product61 = new Product(7, "NBDC CATHETER", 600, "");
        Product product62 = new Product(7, "SCLEROTHERAPY NEEDLE", 1200, "");
        Product product63 = new Product(7, "JEJUNAL FEEDING TUBE WITH GW", 3500, "");
        Product product64 = new Product(7, "JEJUNAL FEEDING TUBE", 2500, "");
        Product product65 = new Product(7, "PTBD CATHETER", 2000, "");
        Product product66 = new Product(7, "ABCESS DRAINAGE CATHETER", 3000, "");
        Product product67 = new Product(7, "ABCESS DRAINAGE CATHETER SET", 4000, "");
        Product product69 = new Product(7, "TWISTER GUIDEWIRE", 8100, "");


        productList2.add(product60);
        productList2.add(product61);
        productList2.add(product62);
        productList2.add(product63);
        productList2.add(product64);
        productList2.add(product65);
        productList2.add(product66);
        productList2.add(product67);
        productList2.add(product68);
        productList2.add(product69);

        mAdapter.addAll(productList2);


        Product product7 = new Product(8, "PTBD CATHETER-PU", 2000, "");
        Product product8 = new Product(9, "BILBAO DOTTER", 4500, "an endoscope to view the urinary passage");
        Product product9 = new Product(10, "FASCIAL DILATOR SET", 2000, "");
        Product product10 = new Product(10, "GUIDEWIRE-PTFE", 2000, "");
        Product product11 = new Product(10, "CHIBA NEEDLE", 2000, "");
        Product product12 = new Product(10, "ABCESS DRAINAGE CATHETER-PU", 2000, "");
        Product product13 = new Product(10, "FULLY Automatic Biopsy gun ( with co-axial)", 4500, "");
        Product product14 = new Product(10, "Semi Automatic Biopsy gun (With Co-Axial)", 3500, "");
        Product product15 = new Product(10, "ABCESS DRAINAGE CATHETER wITH NEEDLE pu", 1500, "");
        Product product16 = new Product(10, "I.P.NEEDLE-PLASTIC", 600, "");


        productList3.add(product7);
        productList3.add(product8);
        productList3.add(product9);
        productList3.add(product10);
        productList3.add(product11);
        productList3.add(product12);
        productList3.add(product13);
        productList3.add(product14);
        productList3.add(product15);
        productList3.add(product15);
        productList3.add(product16);
        mAdapter.addAll(productList3);




        matchesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product item = (Product) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(MainActivity.this, itemDetailActivity.class);
                Log.v("Name", item.getProductName());
                intent.putExtra("Product", item);
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
            mAdapter.clear();
            mAdapter.addAll(productList3);
        } else if (id == R.id.nav_share) {
            FirebaseAuth.getInstance().signOut();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
