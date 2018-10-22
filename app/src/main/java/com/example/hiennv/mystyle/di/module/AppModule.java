package com.example.hiennv.mystyle.di.module;

import android.app.Application;
import android.content.Context;

import com.example.hiennv.mystyle.R;
import com.example.hiennv.mystyle.di.qualifier.ApplicationContext;
import com.example.hiennv.mystyle.di.scope.PerApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class AppModule {
    private Context context;

    public AppModule(Application context){
        this.context = context;
    }

    @Provides
    @PerApp
    @ApplicationContext
    public Context provideContext(){
        return this.context;
    }

    //Provide CalligraphyConfig
    @Provides
    @Singleton
    public CalligraphyConfig provideCalligraphyDefaultConfig(){
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
