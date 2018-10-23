package com.example.hiennv.mystyle.ui.register;

import android.Manifest;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.hiennv.mystyle.base.BasePresenterImpl;
import com.example.hiennv.mystyle.network.ApiService;
import com.example.hiennv.mystyle.ui.dialog.DialogErrorApi;
import com.example.hiennv.mystyle.ui.dialog.DialogSkipLogin;
import com.example.hiennv.mystyle.utils.PermissionUtils;

import javax.inject.Inject;

public class RegisterPresenterImpl<V extends RegisterContract.RegisterView> extends BasePresenterImpl<V>
        implements RegisterContract.RegisterPresenter<V> {
    private static final String TAG = RegisterPresenterImpl.class.getSimpleName();
    private RegisterContract.RegisterView registerView;
    private ApiService apiService;
    private RegisterActivity context;
    //@Inject
    public RegisterPresenterImpl(RegisterContract.RegisterView registerView, ApiService apiService, RegisterActivity context) {
        this.registerView = registerView;
        this.apiService = apiService;
        this.context = context;
    }
    public RegisterPresenterImpl(RegisterContract.RegisterView registerView, RegisterActivity context) {
        this.registerView = registerView;
        //this.apiService = apiService;
        this.context = context;
    }
    @Override
    public void handleSkip() {
        //Show dialog Skip login
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentByTag("dialog_skip");
        if (fragment != null) {
            ft.remove(fragment);
        }
        DialogSkipLogin dialogSkipLogin = DialogSkipLogin.newInstance(context);
        dialogSkipLogin.show(ft,"dialog_skip");
    }

    @Override
    public void handleFacebook() {
        PermissionUtils.singlePermission(context, Manifest.permission.CALL_PHONE);
    }

    @Override
    public void handleLine() {
        PermissionUtils.singlePermission(context,Manifest.permission.CALL_PHONE);
    }

    @Override
    public void handlePhoneNumber() {
        PermissionUtils.singlePermission(context,Manifest.permission.CALL_PHONE);
    }

    @Override
    public void handleAlreadySignedUp() {
        PermissionUtils.singlePermission(context,Manifest.permission.CALL_PHONE);
    }

}
