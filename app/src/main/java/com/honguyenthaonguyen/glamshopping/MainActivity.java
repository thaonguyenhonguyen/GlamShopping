package com.honguyenthaonguyen.glamshopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.honguyenthaonguyen.glamshopping.adapter.CategoryListAdapter;
import com.honguyenthaonguyen.glamshopping.model.ProductCategoryResponse;
import com.honguyenthaonguyen.glamshopping.service.WooCommerceService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    // Declare recycler view vars

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View binding
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_category_list);

        // Create layout manager
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        // Get Data
        WooCommerceService service = ServiceGenerator.createService(WooCommerceService.class);
        Call<ProductCategoryResponse> productCategoryResponseCall = service.getProductCategoryList();
        productCategoryResponseCall.enqueue(new Callback<ProductCategoryResponse>() {
            @Override
            public void onResponse(Call<ProductCategoryResponse> call, Response<ProductCategoryResponse> response) {
                ProductCategoryResponse productCategoryResponse = response.body();
                Log.d("Debug", String.valueOf(productCategoryResponse.getProductCategories().size()));
                recyclerViewAdapter = new CategoryListAdapter(productCategoryResponse.getProductCategories());
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<ProductCategoryResponse> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });

    }
}
