/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.domain.repository;

import com.example.domain.bean.ItemDetailBO;
import com.example.domain.bean.ProductBO;
import com.example.domain.exception.ErrorBundle;

import java.util.Collection;

public interface ProductsRepository {
    /**
     * Callback used to be notified when either a product list has been loaded or an error happened.
     */
    interface ProductListCallback {
        void onProductListLoaded(Collection<ProductBO> productBOS);

        void onError(ErrorBundle errorBundle);
    }

    /**
     * Callback used to be notified when either a product detail has been loaded or an error happened.
     */
    interface ItemDetailCallback {
        void onItemDetailLoaded(ItemDetailBO itemDetailBO);

        void onError(ErrorBundle errorBundle);
    }

    void getProducts(ProductListCallback callback);

    void getItemDetail(int id, ItemDetailCallback callback);
}
