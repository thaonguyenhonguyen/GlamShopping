package com.honguyenthaonguyen.glamshopping.service;

import com.honguyenthaonguyen.glamshopping.model.ProductCategoryResponse;
import com.honguyenthaonguyen.glamshopping.model.ProductResponse;
import com.honguyenthaonguyen.glamshopping.model.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by NGUYEN on 6/7/2016.
 */
public interface WooCommerceService {
    @GET("products/categories")
    Call<ProductCategoryResponse> getProductCategoryList();

    // get product list by category name
    @GET("products")
    Call<ProductsResponse> getListProductByCatName(@Query("filter[category]") String catName);
//
//    @GET("products")
//    Call<ProductsResponse> getProductList();
//
    // get product list by product id
    @GET("products/{id}")
    Call<ProductResponse> getProductById(@Path("id") int id);
}
