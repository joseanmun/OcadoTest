package com.example.ocadotest.injector.component;

import com.example.ocadotest.domain.executor.PostExecutionThread;
import com.example.ocadotest.domain.executor.ThreadExecutor;
import com.example.ocadotest.injector.module.ApplicationModule;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    ThreadExecutor getThreadExecutor();

    PostExecutionThread getPostExecutionThread();

}
