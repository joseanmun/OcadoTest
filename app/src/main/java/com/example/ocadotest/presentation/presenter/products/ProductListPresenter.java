package com.example.ocadotest.presentation.presenter.products;

import com.example.ocadotest.model.ProductModel;
import com.example.ocadotest.presentation.presenter.base.Presenter;

import java.util.List;

public interface ProductListPresenter extends Presenter {

    void getProducts();

    void setView(View view);

    interface View {
        void setItems(List<ProductModel> productModels);

        void showProgress();

        void hideProgress();

        void showMessage(String message);
    }
}
