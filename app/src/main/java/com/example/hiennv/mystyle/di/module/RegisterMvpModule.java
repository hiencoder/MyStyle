package com.example.hiennv.mystyle.di.module;

import com.example.hiennv.mystyle.di.scope.PerActivity;
import com.example.hiennv.mystyle.ui.register.RegisterContract;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterMvpModule {
    //Provide RegisterView
    private RegisterContract.RegisterView registerView;

    public RegisterMvpModule(RegisterContract.RegisterView registerView){
        this.registerView = registerView;
    }

    @Provides
    @PerActivity
    public RegisterContract.RegisterView provideRegisterView(){
        return this.registerView;
    }
}
