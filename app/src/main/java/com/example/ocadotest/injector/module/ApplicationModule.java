package com.example.ocadotest.injector.module;


import android.content.Context;

import com.example.data.executor.JobExecutor;
import com.example.data.net.ApiConstants;
import com.example.data.net.ProductsApiService;
import com.example.data.repository.ProductsRepositoryImpl;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.ProductsRepository;
import com.example.ocadotest.MyApplication;
import com.example.ocadotest.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    @Provides
    @Singleton
    ProductsRepository provideComicsRepository(ProductsRepositoryImpl productsRepository) {
        return productsRepository;
    }


    @Provides
    @Singleton
    ProductsApiService provideProductsApiService() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.ENDPOINT)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ProductsApiService.class);
    }
}
