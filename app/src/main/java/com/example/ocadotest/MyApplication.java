package com.example.ocadotest;

import android.app.Application;

import com.example.ocadotest.injector.component.ApplicationComponent;
import com.example.ocadotest.injector.component.DaggerApplicationComponent;

public class MyApplication extends Application {
    // Reference to the application graph that is used across the whole app
    ApplicationComponent appComponent = DaggerApplicationComponent.builder().build();

}
