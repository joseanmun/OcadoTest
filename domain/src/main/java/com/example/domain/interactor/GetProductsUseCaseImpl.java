/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/11/20 9:21 PM
 */

package com.example.domain.interactor;

import com.example.domain.bean.ProductBO;
import com.example.domain.exception.ErrorBundle;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.ProductsRepository;

import java.util.Collection;

import javax.inject.Inject;

public class GetProductsUseCaseImpl implements GetProductsUseCase {


    private final ProductsRepository productsRepository;

    private final ThreadExecutor threadExecutor;

    private final PostExecutionThread postExecutionThread;

    private Callback callback;

    @Inject
    public GetProductsUseCaseImpl(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                  ProductsRepository productsRepository) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.productsRepository = productsRepository;
    }

    @Override
    public void execute(Callback callback) {
        this.callback = callback;
        this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        this.productsRepository.getProducts(repositoryCallback);
    }

    private final ProductsRepository.ProductListCallback repositoryCallback = new ProductsRepository.ProductListCallback() {
        @Override
        public void onProductListLoaded(Collection<ProductBO> productList) {
            notifyGetProductListSuccessfully(productList);
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            notifyError(errorBundle);
        }
    };

    private void notifyGetProductListSuccessfully(final Collection<ProductBO> productsList) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onProductListLoaded(productsList);
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
