/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.ocadotest.presentation.ui;

import android.os.Bundle;

import com.example.ocadotest.R;
import com.example.ocadotest.injector.component.ApplicationComponent;
import com.example.ocadotest.injector.component.DaggerProductsComponent;
import com.example.ocadotest.injector.module.ActivityModule;
import com.example.ocadotest.injector.module.ProductsModule;
import com.example.ocadotest.presentation.ui.base.BaseActivity;
import com.example.ocadotest.presentation.ui.products.fragments.ItemDetailFragment;
import com.example.ocadotest.presentation.ui.products.fragments.ProductListFragment;

public class MainActivity extends BaseActivity implements ProductListFragment.OnProductListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(R.id.container, ProductListFragment.newInstance());
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

    }

    @Override
    public void onProductItemSelected(int itemId) {
        replaceFragment(R.id.container, ItemDetailFragment.newInstance(itemId), ItemDetailFragment.class.getName());
    }
}
