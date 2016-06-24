
package com.honguyenthaonguyen.glamshopping.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProductResponse {

    @SerializedName("product")
    @Expose
    private Product product = new Product();

    public Product getProducts() {
        return product;
    }

    public void setProducts(Product products) {
        this.product = products;
    }

}
