package com.example.ocadotest.presentation.presenter.products.impl;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.domain.bean.ProductBO;
import com.example.domain.exception.ErrorBundle;
import com.example.domain.interactor.GetProductsUseCase;
import com.example.ocadotest.injector.PerActivity;
import com.example.ocadotest.model.ProductModel;
import com.example.ocadotest.model.ProductModelMapper;
import com.example.ocadotest.presentation.presenter.base.Presenter;
import com.example.ocadotest.presentation.presenter.products.ProductListPresenter;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * {@link Presenter} that controls communication between views and models of the presentation layer.
 */
@PerActivity
public class ProductListPresenterImpl implements ProductListPresenter {

    private static final String TAG = ProductListPresenterImpl.class.getName();

    private ProductListPresenter.View view;

    private final GetProductsUseCase getProductsUseCase;

    private List<ProductModel> models;

    @Inject
    public ProductListPresenterImpl(GetProductsUseCase getProductsUseCase) {
        this.getProductsUseCase = getProductsUseCase;
    }

    @Override
    public void setView(@NonNull ProductListPresenter.View view) {
        this.view = view;
    }

    @Override
    public void getComics() {
        getProductsUseCase.execute(productListCallback);
    }

    private void setModels() {
        if (models != null && !models.isEmpty()) {
            view.setItems(models);
        } else {

        }
    }

    private void stopRefresh() {
        view.stopRefresh();
    }

    private void showMessage(String message) {
        view.showMessage(message);
    }

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    @Override
    public void resume() {

    }

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    @Override
    public void pause() {

    }

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    @Override
    public void destroy() {

    }

    private final GetProductsUseCase.Callback productListCallback = new GetProductsUseCase.Callback() {

        @Override
        public void onProductListLoaded(Collection<ProductBO> products) {
            models = ProductModelMapper.toModel(products);
            setModels();
            stopRefresh();
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            Log.e(TAG, errorBundle.getErrorMessage());
            showMessage(errorBundle.getErrorMessage());
            stopRefresh();

        }
    };
}
