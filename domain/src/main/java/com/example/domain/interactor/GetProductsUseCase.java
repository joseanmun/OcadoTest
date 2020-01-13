/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.domain.interactor;


import com.example.domain.bean.ProductBO;
import com.example.domain.exception.ErrorBundle;

import java.util.Collection;

/**
 * Get products
 */
public interface GetProductsUseCase extends Interactor {

    /**
     * Callback used to be notified when either a product collection has been loaded or an error happened.
     */
    interface Callback {
        void onProductListLoaded(Collection<ProductBO> usersCollection);

        void onError(ErrorBundle errorBundle);
    }

    /**
     * Executes this use case.
     * @param callback    A {@link GetProductsUseCase.Callback} used to notify the client.
     */
    void execute(Callback callback);
}
