package com.example.hiennv.mystyle.app;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.example.hiennv.mystyle.R;

import io.fabric.sdk.android.Fabric;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath("fonts/Roboto-Bold.ttf")
        .setFontAttrId(R.attr.fontPath)
        .build());
    }
}
