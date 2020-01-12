package com.example.ocadotest.presentation.presenter.products.impl;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.domain.bean.ItemDetailBO;
import com.example.domain.exception.ErrorBundle;
import com.example.domain.interactor.GetItemDetailUseCase;
import com.example.ocadotest.injector.PerActivity;
import com.example.ocadotest.model.ItemDetailModel;
import com.example.ocadotest.model.ItemDetailModelMapper;
import com.example.ocadotest.presentation.presenter.base.Presenter;
import com.example.ocadotest.presentation.presenter.products.ItemDetailPresenter;

import javax.inject.Inject;

/**
 * {@link Presenter} that controls communication between views and model of the presentation layer.
 */
@PerActivity
public class ItemDetailPresenterImpl implements ItemDetailPresenter {

    private static final String TAG = ItemDetailPresenterImpl.class.getName();

    private View view;

    private final GetItemDetailUseCase getItemDetailUseCase;

    private ItemDetailModel model;

    @Inject
    public ItemDetailPresenterImpl(GetItemDetailUseCase getProductsUseCase) {
        this.getItemDetailUseCase = getProductsUseCase;
    }

    @Override
    public void setView(@NonNull View view) {
        this.view = view;
    }

    @Override
    public void getItemDetail(int itemId) {
        view.showProgress();
        getItemDetailUseCase.execute(itemId, callback);
    }

    private void setModel() {
        if (model != null) {
            view.renderItemDetail(model);
        } else {

        }
    }

    private void stopRefresh() {
        view.hideProgress();
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

    private final GetItemDetailUseCase.Callback callback = new GetItemDetailUseCase.Callback() {

        @Override
        public void onItemDetailLoaded(ItemDetailBO itemDetailBOS) {
            model = ItemDetailModelMapper.toModel(itemDetailBOS);
            setModel();
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
