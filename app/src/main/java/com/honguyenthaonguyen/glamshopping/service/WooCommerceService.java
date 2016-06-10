package com.honguyenthaonguyen.glamshopping.service;

import com.honguyenthaonguyen.glamshopping.model.ProductCategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by NGUYEN on 6/7/2016.
 */
public interface WooCommerceService {
    @GET("products/categories")
    Call<ProductCategoryResponse> getProductCategoryList();
//
//    @GET("products")
//    Call<ProductsResponse> getProductList();
//
//    @GET("products/{id}")
//    Call<ProductsResponse> getProduct(@Path("id") int id);
}
