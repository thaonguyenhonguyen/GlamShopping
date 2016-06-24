package com.honguyenthaonguyen.glamshopping;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.honguyenthaonguyen.glamshopping.model.Product;
import com.honguyenthaonguyen.glamshopping.model.ProductResponse;
import com.honguyenthaonguyen.glamshopping.service.WooCommerceService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NGUYEN on 6/24/2016.
 */
public class FragmentProductDetails extends Fragment {
    TextView textViewTenSanPham, textViewGiaSanPham, textViewMotaSanPham;
    ImageView imageViewHinhSanPham;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_product_details, container, false);
        textViewTenSanPham = (TextView) view.findViewById(R.id.textViewProductName);
        textViewGiaSanPham = (TextView) view.findViewById(R.id.textViewProductPrice);
        textViewMotaSanPham = (TextView) view.findViewById(R.id.textViewProductDescription);
        imageViewHinhSanPham = (ImageView) view.findViewById(R.id.imageViewProductDetails);

        Bundle bundle = this.getArguments();
        Integer productID = bundle.getInt("productID");
        WooCommerceService service = ServiceGenerator.createService(WooCommerceService.class);
        Call<ProductResponse> productResponseCall = service.getProductById(productID);
        productResponseCall.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                Product product = response.body().getProducts();
                textViewTenSanPham.setText(product.getTitle());
                textViewGiaSanPham.setText("$ " + product.getPrice());
                textViewMotaSanPham.setText(product.getDescription());
                Glide.with(view.getContext()).load(product.getImages().get(0).getSrc()).into(imageViewHinhSanPham);
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Log.e("Error", t.getMessage());

            }
        });

        return view;
    }
}
