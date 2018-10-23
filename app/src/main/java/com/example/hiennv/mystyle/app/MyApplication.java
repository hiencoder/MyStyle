package com.example.hiennv.mystyle.app;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.example.hiennv.mystyle.R;
import com.example.hiennv.mystyle.di.component.AppComponent;
//import com.example.hiennv.mystyle.di.component.DaggerAppComponent;
import com.example.hiennv.mystyle.di.component.DaggerAppComponent;
import com.example.hiennv.mystyle.di.module.AppModule;
import com.example.hiennv.mystyle.utils.AppLogger;
import com.squareup.leakcanary.LeakCanary;

import io.fabric.sdk.android.Fabric;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApplication extends Application{
    //private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath("fonts/Roboto-Bold.ttf")
        .setFontAttrId(R.attr.fontPath)
        .build());
        /*appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();*/
        //Logger
        AppLogger.init(this);

        //LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);

    }

    /*public AppComponent getAppComponent() {
        return appComponent;
    }

    public static MyApplication getApplication(Context context){
        return (MyApplication)context.getApplicationContext();
    }*/
}
