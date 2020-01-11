package com.example.ocadotest.injector.component;

import android.app.Activity;

import com.example.ocadotest.injector.PerActivity;
import com.example.ocadotest.injector.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();
}
