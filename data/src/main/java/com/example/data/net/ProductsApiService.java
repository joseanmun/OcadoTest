/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:25 PM
 */

package com.example.data.net;


import com.example.data.bean.RestItemDetailResponse;
import com.example.data.bean.RestProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Interface representing the products API service.
 */
public interface ProductsApiService {

    /**
     * Get all products.
     */
    @GET("products")
    Call<RestProductsResponse> getProductList();

    /**
     * Get all products.
     */
    @GET("product/{itemId}/")
    Call<RestItemDetailResponse> getItemDetailById(@Path("itemId") int itemId);

}
