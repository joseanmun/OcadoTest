package com.example.ocadotest.injector.module;


import android.content.Context;

import com.example.ocadotest.MyApplication;
import com.example.ocadotest.UIThread;
import com.example.ocadotest.data.executor.JobExecutor;
import com.example.ocadotest.domain.executor.PostExecutionThread;
import com.example.ocadotest.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final MyApplication application;

    public ApplicationModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }


}
