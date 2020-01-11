package com.example.data.repository;

import com.example.data.bean.RestProductsResponse;
import com.example.data.bean.RestProductsResponseMapper;
import com.example.data.exception.ProductsNotFoundException;
import com.example.data.exception.RepositoryErrorBundle;
import com.example.data.net.ProductsApiService;
import com.example.domain.repository.ProductsRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsRepositoryImpl implements ProductsRepository {

    private ProductsApiService productsApiService;

    @Inject
    public ProductsRepositoryImpl(ProductsApiService productsApiService) {
        this.productsApiService = productsApiService;
    }

    @Override
    public void getProducts(final ProductListCallback callback) {
        Call<RestProductsResponse> call = productsApiService.getProductList();
        call.enqueue(new Callback<RestProductsResponse>() {
            @Override
            public void onResponse(Call<RestProductsResponse> call, Response<RestProductsResponse> response) {
                if (response != null) {
                    callback.onProductListLoaded(RestProductsResponseMapper.toBo(response.body()));
                } else {
                    callback.onError(new RepositoryErrorBundle(new ProductsNotFoundException()));
                }
            }

            @Override
            public void onFailure(Call<RestProductsResponse> call, Throwable t) {
                callback.onError(new RepositoryErrorBundle(new ProductsNotFoundException(t.getMessage())));
            }
        });
    }
}
