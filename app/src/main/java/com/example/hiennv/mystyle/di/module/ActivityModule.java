package com.example.hiennv.mystyle.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.hiennv.mystyle.di.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity){
        this.activity = activity;
    }
    @Provides
    @ActivityContext
    public Context provideContext(){
        return activity;
    }



}
