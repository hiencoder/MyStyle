package com.example.hiennv.mystyle.di.module;

import android.content.Context;

import com.example.hiennv.mystyle.di.qualifier.ActivityContext;
import com.example.hiennv.mystyle.di.scope.PerActivity;
import com.example.hiennv.mystyle.ui.register.RegisterActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterContextModule {
    private RegisterActivity registerActivity;

    public RegisterContextModule(RegisterActivity registerActivity) {
        this.registerActivity = registerActivity;
    }

    @Provides
    @PerActivity
    public RegisterActivity provideRegisterActivity() {
        return registerActivity;
    }

    @Provides
    //@PerActivity
    @ActivityContext
    public Context provideContext() {
        return registerActivity;
    }
}
