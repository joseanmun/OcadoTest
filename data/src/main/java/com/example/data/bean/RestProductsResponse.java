package com.example.data.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestProductsResponse {

    @SerializedName("clusters")
    private List<RestProduct> products;

    public RestProductsResponse() {
    }

    public List<RestProduct> getProducts() {
        return products;
    }

    public void setProducts(List<RestProduct> products) {
        this.products = products;
    }
}
