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
     *
     * @param characterId int character identifier which we want to retrieve comics from.
     * @param refresh     boolean true if the request should be done to the cloud.
     * @param callback    A {@link GetProductsUseCase.Callback} used to notify the client.
     */
    void execute(int characterId, boolean refresh, Callback callback);
}
