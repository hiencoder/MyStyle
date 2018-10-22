package com.example.hiennv.mystyle.di.component;

import android.content.Context;

import com.example.hiennv.mystyle.app.MyApplication;
import com.example.hiennv.mystyle.di.module.AppModule;
import com.example.hiennv.mystyle.di.module.NetworkModule;
import com.example.hiennv.mystyle.di.qualifier.ApplicationContext;
import com.example.hiennv.mystyle.di.scope.PerApp;
import com.example.hiennv.mystyle.network.ApiService;

import dagger.Component;
@PerApp
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    //Get ApiService
    ApiService getService();

    @ApplicationContext
    Context getContext();

    void inject(MyApplication myApplication);
}
