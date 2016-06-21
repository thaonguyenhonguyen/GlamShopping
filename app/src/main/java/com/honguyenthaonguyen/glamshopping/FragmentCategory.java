package com.honguyenthaonguyen.glamshopping;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.honguyenthaonguyen.glamshopping.adapter.CategoryListAdapter;
import com.honguyenthaonguyen.glamshopping.model.ProductCategoryResponse;
import com.honguyenthaonguyen.glamshopping.service.WooCommerceService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 11/06/2016.
 */
public class FragmentCategory extends android.support.v4.app.Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.activity_main,container,false);

         //View binding
        recyclerView = (RecyclerView) viewFragment.findViewById(R.id.recycler_view_category_list);

        // Create layout manager
        recyclerViewLayoutManager = new LinearLayoutManager(getActivity());
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


        return viewFragment;
    }



    @Override
    public void onPause() {
        super.onPause();
    }
}
