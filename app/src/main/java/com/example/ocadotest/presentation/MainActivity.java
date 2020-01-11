package com.example.ocadotest.presentation;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ocadotest.R;
import com.example.ocadotest.injector.component.ApplicationComponent;
import com.example.ocadotest.injector.component.DaggerProductsComponent;
import com.example.ocadotest.injector.module.ActivityModule;
import com.example.ocadotest.injector.module.ProductsModule;
import com.example.ocadotest.model.ProductModel;
import com.example.ocadotest.presenter.ProductListPresenter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements ProductListPresenter.View {

    @Inject
    ProductListPresenter productListPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializePresenter();
    }

    @Override
    protected void initializeInjector(ApplicationComponent applicationComponent) {

        // PerActivity injector initialization
        DaggerProductsComponent.builder()
                .applicationComponent(applicationComponent) // Main component must be set
                .activityModule(new ActivityModule(this)) // Initialize dependencies
                .productsModule(new ProductsModule()).build().inject(this); // Make PerActivity module
    }

    private void initializePresenter() {
        productListPresenter.setView(this);
        productListPresenter.getComics();
    }

    @Override
    public void setItems(List<ProductModel> productModels) {
        ((TextView) findViewById(R.id.tvtest)).setText("size" + productModels.size());
    }

    @Override
    public void stopRefresh() {

    }

    @Override
    public void showMessage(String message) {

    }
}
