package com.example.hiennv.mystyle.di.component;

import android.content.Context;

import com.example.hiennv.mystyle.di.module.RegisterMvpModule;
import com.example.hiennv.mystyle.di.qualifier.ActivityContext;
import com.example.hiennv.mystyle.di.scope.PerActivity;
import com.example.hiennv.mystyle.ui.register.RegisterActivity;

import javax.inject.Inject;

import dagger.Component;
@PerActivity
@Component(modules = RegisterMvpModule.class, dependencies = AppComponent.class)
public interface RegisterComponent {
    /*@ActivityContext
    Context getContext();*/

    void inject(RegisterActivity registerActivity);
}
