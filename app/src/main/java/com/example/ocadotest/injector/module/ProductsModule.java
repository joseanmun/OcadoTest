/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.ocadotest.injector.module;

import com.example.domain.interactor.GetItemDetailUseCase;
import com.example.domain.interactor.GetItemDetailUseCaseImpl;
import com.example.domain.interactor.GetProductsUseCase;
import com.example.domain.interactor.GetProductsUseCaseImpl;
import com.example.ocadotest.injector.PerActivity;
import com.example.ocadotest.presentation.presenter.products.ItemDetailPresenter;
import com.example.ocadotest.presentation.presenter.products.ProductListPresenter;
import com.example.ocadotest.presentation.presenter.products.impl.ItemDetailPresenterImpl;
import com.example.ocadotest.presentation.presenter.products.impl.ProductListPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductsModule {

    @Provides
    @PerActivity
    ProductListPresenter provideProductListPresenter(ProductListPresenterImpl productListPresenter) {
        return productListPresenter;
    }

    @Provides
    @PerActivity
    GetProductsUseCase provideGetProductsUseCase(GetProductsUseCaseImpl getProductsUseCase) {
        return getProductsUseCase;
    }

    @Provides
    @PerActivity
    ItemDetailPresenter provideItemDetailPresenter(ItemDetailPresenterImpl itemDetailPresenter) {
        return itemDetailPresenter;
    }

    @Provides
    @PerActivity
    GetItemDetailUseCase provideGetItemDetailUseCase(GetItemDetailUseCaseImpl getItemDetailUseCase) {
        return getItemDetailUseCase;
    }
}
