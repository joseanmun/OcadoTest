/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/11/20 8:35 PM
 */

package com.example.ocadotest.injector.module;


import android.app.Activity;

import com.example.ocadotest.injector.PerActivity;

import dagger.Module;
import dagger.Provides;
@Module
public class ActivityModule {
    private final Activity activity;


    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return this.activity;
    }
}
