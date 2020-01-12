package com.example.ocadotest.presentation.presenter.products;

import com.example.ocadotest.model.ItemDetailModel;
import com.example.ocadotest.presentation.presenter.base.Presenter;

public interface ItemDetailPresenter extends Presenter {

    void getItemDetail(int itemId);

    void setView(View view);

    interface View {
        void renderItemDetail(ItemDetailModel itemDetailModel);

        void stopRefresh();

        void showMessage(String message);
    }
}
