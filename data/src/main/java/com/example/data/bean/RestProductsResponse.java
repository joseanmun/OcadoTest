/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

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
