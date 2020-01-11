package com.example.domain.interactor;


import com.example.domain.bean.ProductBO;
import com.example.domain.exception.ErrorBundle;

import java.util.Collection;

/**
 * Get comics by character identifier use case.
 */
public interface GetProductsUseCase extends Interactor {

    /**
     * Callback used to be notified when either a comics collection has been loaded or an error happened.
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
