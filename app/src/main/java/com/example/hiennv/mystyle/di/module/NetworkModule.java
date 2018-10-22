package com.example.hiennv.mystyle.di.module;

import com.example.hiennv.mystyle.di.scope.PerApp;
import com.example.hiennv.mystyle.network.ApiService;
import com.example.hiennv.mystyle.utils.AppConstants;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @PerApp
    public ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    @PerApp
    public Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @PerApp
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(AppConstants.TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(AppConstants.TIME_OUT,TimeUnit.SECONDS)
                .writeTimeout(AppConstants.TIME_OUT,TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @PerApp
    public HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
