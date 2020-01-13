/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.ocadotest.injector.component;


import com.example.ocadotest.injector.PerActivity;
import com.example.ocadotest.injector.module.ActivityModule;
import com.example.ocadotest.injector.module.ProductsModule;
import com.example.ocadotest.presentation.ui.MainActivity;
import com.example.ocadotest.presentation.ui.products.fragments.ItemDetailFragment;
import com.example.ocadotest.presentation.ui.products.fragments.ProductListFragment;

import dagger.Component;

/**
 * A scoped {@link PerActivity} component.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, ProductsModule.class})
public interface ProductsComponent extends ActivityComponent {

    // injections
    void inject(MainActivity mainActivity);

    void inject(ProductListFragment productListFragment);

    void inject(ItemDetailFragment itemDetailFragment);
}
