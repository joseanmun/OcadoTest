/**
 * Copyright (C) 2016 Sergi Castillo Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
