package com.example.domain.interactor;

import com.example.domain.bean.ItemDetailBO;
import com.example.domain.exception.ErrorBundle;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.ProductsRepository;

import javax.inject.Inject;

public class GetItemDetailUseCaseImpl implements GetItemDetailUseCase {

    private int itemId;

    private final ProductsRepository productsRepository;

    private final ThreadExecutor threadExecutor;

    private final PostExecutionThread postExecutionThread;

    private Callback callback;

    @Inject
    public GetItemDetailUseCaseImpl(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                    ProductsRepository productsRepository) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.productsRepository = productsRepository;
    }

    @Override
    public void execute(int itemId, Callback callback) {
        this.callback = callback;
        this.threadExecutor.execute(this);
        this.itemId = itemId;
    }

    @Override
    public void run() {
        this.productsRepository.getItemDetail(itemId, repositoryCallback);
    }

    private final ProductsRepository.ItemDetailCallback repositoryCallback = new ProductsRepository.ItemDetailCallback() {

        @Override
        public void onItemDetailLoaded(ItemDetailBO itemDetailBO) {
            notifyGetItemDetailSuccessfully(itemDetailBO);
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            notifyError(errorBundle);
        }
    };

    private void notifyGetItemDetailSuccessfully(final ItemDetailBO itemDetailBO) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onItemDetailLoaded(itemDetailBO);
            }
        });
    }

    private void notifyError(final ErrorBundle errorBundle) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(errorBundle);
            }
        });
    }
}
