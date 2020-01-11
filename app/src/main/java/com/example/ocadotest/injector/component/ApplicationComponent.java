package com.example.ocadotest.injector.component;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.ProductsRepository;
import com.example.ocadotest.injector.module.ApplicationModule;
import com.example.ocadotest.presentation.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    ThreadExecutor getThreadExecutor();

    PostExecutionThread getPostExecutionThread();

    ProductsRepository getProductsRepository();

}
