package com.honguyenthaonguyen.glamshopping;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.honguyenthaonguyen.glamshopping.adapter.ProductListAdapter;
import com.honguyenthaonguyen.glamshopping.model.ProductsResponse;
import com.honguyenthaonguyen.glamshopping.service.WooCommerceService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NGUYEN on 6/24/2016.
 */
public class FragmentProductList extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    TextView textViewQuantity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product_list,container,false);
        //binding
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewProductOnSale);
        //searchView = (SearchView) view.findViewById(R.id.viewSearch);
        textViewQuantity =(TextView) view.findViewById(R.id.textViewQuantity);
        // Create layout manager
        recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        SpacesItemDecoration decoration = new SpacesItemDecoration(17);
        recyclerView.addItemDecoration(decoration);

        Bundle bundle = this.getArguments();
        String catName = bundle.getString("catName");
        // Get Data
        WooCommerceService service = ServiceGenerator.createService(WooCommerceService.class);
        Call<ProductsResponse> productsResponseCall = service.getListProductByCatName(catName);
        productsResponseCall.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                ProductsResponse productsResponse = response.body();
                recyclerViewAdapter = new ProductListAdapter(productsResponse.getProducts());
                recyclerView.setAdapter(recyclerViewAdapter);
                Log.d("Debug", String.valueOf(response.body().getProducts().size()));
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }

        });

        //textViewQuantity.setText(String.valueOf(productListAdapter.count));
        return view;

    }

}
