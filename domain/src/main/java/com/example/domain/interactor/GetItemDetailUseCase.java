package com.example.domain.interactor;


import com.example.domain.bean.ItemDetailBO;
import com.example.domain.exception.ErrorBundle;

/**
 * Get comics by character identifier use case.
 */
public interface GetItemDetailUseCase extends Interactor {

    /**
     * Callback used to be notified when either a product detail has been loaded or an error happened.
     */
    interface Callback {
        void onItemDetailLoaded(ItemDetailBO itemDetailBOS);

        void onError(ErrorBundle errorBundle);
    }

    /**
     * Executes this use case.
     *
     * @param callback A {@link GetItemDetailUseCase.Callback} used to notify the client.
     */
    void execute(int itemId, Callback callback);
}
