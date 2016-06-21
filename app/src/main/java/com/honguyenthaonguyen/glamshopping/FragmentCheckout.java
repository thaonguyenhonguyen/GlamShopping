package com.honguyenthaonguyen.glamshopping;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.honguyenthaonguyen.glamshopping.adapter.ProductListAdapter;
import com.honguyenthaonguyen.glamshopping.model.Product;
import com.honguyenthaonguyen.glamshopping.service.WooCommerceService;

import java.util.ArrayList;

/**
 * Created by NGUYEN on 6/14/2016.
 */
public class FragmentCheckout extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    //SearchView searchView;
    ArrayList<Product> arrayList;
    TextView textViewTotal;
    ProductListAdapter productListAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_out,container,false);
        //binding
        recyclerView = (RecyclerView) view.findViewById(R.id.viewCheckOutProducts);
        //searchView = (SearchView) view.findViewById(R.id.viewSearch);

        // Create layout manager
        recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        SpacesItemDecoration decoration = new SpacesItemDecoration(17);
        recyclerView.addItemDecoration(decoration);

//        Bundle bundle = this.getArguments();
//        int productID = bundle.getInt("productID");
        // Get Data
        ArrayList<Integer> listProductID = ProductListAdapter.PRODUCT_ID_LIST;
        textViewTotal = (TextView) view.findViewById(R.id.textViewTotal);
        textViewTotal.setText(ProductListAdapter.PRODUCT_ID_LIST.toString());

        WooCommerceService service = ServiceGenerator.createService(WooCommerceService.class);
//
//        for (int i = 0; i <= listProductID.size(); i++)
//        {
//            Call<ProductResponse> productResponseCall = service.getProductById(i);
//            productResponseCall.enqueue(new Callback<ProductResponse>() {
//
//                @Override
//                public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
//                    ProductResponse productResponse = response.body();
//
//                    //String a = productResponse.getProducts().getTitle();
//
//                    recyclerViewAdapter = new ProductListAdapter(arrayList);
//                    //recyclerView.setAdapter(recyclerViewAdapter);
//                    // Log.d("Debug", String.valueOf(response.body().getProducts().size()));
//                }
//
//                @Override
//                public void onFailure(Call<ProductResponse> call, Throwable t) {
//                    Log.e("Error", t.getMessage());
//                }
//
//            });
//        }


        return view;
    }

}
