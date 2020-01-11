package com.example.ocadotest.injector.module;


import android.app.Activity;

import com.example.ocadotest.injector.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jofre on 7/07/16.
 */
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
