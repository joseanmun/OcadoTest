package com.example.ocadotest.presenter;

import com.example.ocadotest.model.ProductModel;

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
