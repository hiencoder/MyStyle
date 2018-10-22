package com.example.hiennv.mystyle.ui.register;

import com.example.hiennv.mystyle.base.BasePresenterImpl;
import com.example.hiennv.mystyle.network.ApiService;

import javax.inject.Inject;

public class RegisterPresenterImpl<V extends RegisterContract.RegisterView> extends BasePresenterImpl<V>
        implements RegisterContract.RegisterPresenter<V> {
    private static final String TAG = RegisterPresenterImpl.class.getSimpleName();
    private RegisterContract.RegisterView registerView;
    private ApiService apiService;

    @Inject
    public RegisterPresenterImpl(RegisterContract.RegisterView registerView, ApiService apiService) {
        this.registerView = registerView;
        this.apiService = apiService;
    }

    @Override
    public void handleSkip() {

    }

    @Override
    public void handleFacebook() {

    }

    @Override
    public void handleLine() {

    }

    @Override
    public void handlePhoneNumber() {

    }

    @Override
    public void handleAlreadySignedUp() {

    }

    private void checkDexterPermission() {

    }
}
