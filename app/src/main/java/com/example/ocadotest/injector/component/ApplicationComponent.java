package com.example.ocadotest.injector.component;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.ocadotest.injector.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    ThreadExecutor getThreadExecutor();

    PostExecutionThread getPostExecutionThread();

}
