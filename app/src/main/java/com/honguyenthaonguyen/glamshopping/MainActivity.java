package com.honguyenthaonguyen.glamshopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    // Declare recycler view vars
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navigationView;
//    android.app.FragmentManager fragmentManager;
//    android.app.FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private Session session;

//    RecyclerView recyclerView;
//    RecyclerView.Adapter recyclerViewAdapter;
//    RecyclerView.LayoutManager recyclerViewLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glamshopping);

        //Set Tollbar
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // set session
        session = new Session(this);
        if (!session.loggedin()){
            logout();
        }


        //Drawer view
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        actionBarDrawerToggle.syncState();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int i = item.getItemId();
                switch (i){
                    case R.id.explore:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        FragmentCategory fragmentCategory = new FragmentCategory();
                        fragmentTransaction.replace(R.id.lnGlamShopping,fragmentCategory);
                        fragmentTransaction.commit();

                        drawerLayout.closeDrawer(GravityCompat.START);
                    ;break;

                    case R.id.favourites:
                        ;break;

                    case R.id.cart:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        FragmentCheckout fragmentCheckout = new FragmentCheckout();
                        fragmentTransaction.replace(R.id.lnGlamShopping,fragmentCheckout);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        ;break;

                    case R.id.settings:
                        //fragmentManager= getFragmentManager();
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        FragmentSettings fragmentSettings = new FragmentSettings();
                        fragmentTransaction.replace(R.id.lnGlamShopping,fragmentSettings);
                        fragmentTransaction.commit();

                        drawerLayout.closeDrawer(GravityCompat.START);
                        ;break;

                    case R.id.logout:
                        logout();
                        ;break;
                }
                return false;
            }
        });


        fragmentManager = getSupportFragmentManager();
        //fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction = fragmentManager.beginTransaction();
        FragmentCategory fragmentCategory = new FragmentCategory();
        fragmentTransaction.replace(R.id.lnGlamShopping,fragmentCategory);
        fragmentTransaction.commit();
//
////        // View binding
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_category_list);
//
//        // Create layout manager
//        recyclerViewLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(recyclerViewLayoutManager);
//        // Get Data
//        WooCommerceService service = ServiceGenerator.createService(WooCommerceService.class);
//        Call<ProductCategoryResponse> productCategoryResponseCall = service.getProductCategoryList();
//        productCategoryResponseCall.enqueue(new Callback<ProductCategoryResponse>() {
//            @Override
//            public void onResponse(Call<ProductCategoryResponse> call, Response<ProductCategoryResponse> response) {
//                ProductCategoryResponse productCategoryResponse = response.body();
//                Log.d("Debug", String.valueOf(productCategoryResponse.getProductCategories().size()));
//                recyclerViewAdapter = new CategoryListAdapter(productCategoryResponse.getProductCategories());
//                recyclerView.setAdapter(recyclerViewAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<ProductCategoryResponse> call, Throwable t) {
//                Log.e("Error", t.getMessage());
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        MenuItem searchview = menu.findItem(R.id.item_search);
        SearchView searchView = (SearchView) searchview.getActionView();
        searchView.setOnQueryTextListener(MainActivity.this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item_search:
                Toast.makeText(MainActivity.this, "Ban da click vao "+ item.getTitle(), Toast.LENGTH_SHORT).show();
                ;break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Toast.makeText(MainActivity.this,newText, Toast.LENGTH_SHORT).show();
        return false;
    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
