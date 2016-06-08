
package com.honguyenthaonguyen.glamshopping.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class ProductCategoryResponse {

    @SerializedName("product_categories")
    @Expose
    private List<ProductCategory> productCategories = new ArrayList<ProductCategory>();

    /**
     * 
     * @return
     *     The productCategories
     */
    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    /**
     * 
     * @param productCategories
     *     The product_categories
     */
    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

}
