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
