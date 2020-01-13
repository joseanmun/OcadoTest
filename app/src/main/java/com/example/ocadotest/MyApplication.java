/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/11/20 8:52 PM
 */

package com.example.ocadotest;

import android.app.Application;

import com.example.ocadotest.injector.component.ApplicationComponent;
import com.example.ocadotest.injector.component.DaggerApplicationComponent;
import com.example.ocadotest.injector.module.ApplicationModule;

public class MyApplication extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeInjector();
    }

    private void initializeInjector() {
        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
