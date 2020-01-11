package com.example.ocadotest.injector.module;

import com.example.domain.interactor.GetProductsUseCase;
import com.example.domain.interactor.GetProductsUseCaseImpl;
import com.example.ocadotest.injector.PerActivity;
import com.example.ocadotest.presenter.ProductListPresenter;
import com.example.ocadotest.presenter.ProductListPresenterImpl;

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
}
