/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

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
