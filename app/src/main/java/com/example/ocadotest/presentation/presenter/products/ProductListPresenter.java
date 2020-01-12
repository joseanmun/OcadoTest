package com.example.ocadotest.presentation.presenter.products;

import com.example.ocadotest.model.ProductModel;
import com.example.ocadotest.presentation.presenter.base.Presenter;

import java.util.List;

public interface ProductListPresenter extends Presenter {

    void getComics();

    void setView(View view);

    interface View {
        void setItems(List<ProductModel> productModels);

        void stopRefresh();

        void showMessage(String message);
    }
}
