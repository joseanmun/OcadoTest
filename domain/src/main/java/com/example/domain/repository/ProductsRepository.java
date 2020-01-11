package com.example.domain.repository;

import com.example.domain.bean.ProductBO;
import com.example.domain.exception.ErrorBundle;

import java.util.Collection;

public interface ProductsRepository {
    /**
     * Callback used to be notified when either a comic list has been loaded or an error happened.
     */
    interface ProductListCallback {
        void onProductListLoaded(Collection<ProductBO> comicBoCollection);

        void onError(ErrorBundle errorBundle);
    }

    void getProducts(ProductListCallback callback);
}
