
package com.honguyenthaonguyen.glamshopping.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProductResponse {

    @SerializedName("product")
    @Expose
    private Product products = new Product();

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
