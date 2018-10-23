package com.example.hiennv.mystyle.ui.dialog;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hiennv.mystyle.R;
import com.example.hiennv.mystyle.base.BaseDialog;
import com.example.hiennv.mystyle.ui.home.MainActivity;
import com.example.hiennv.mystyle.ui.register.RegisterActivity;
import com.example.hiennv.mystyle.utils.PermissionUtils;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.OnClick;

public class DialogSkipLogin extends BaseDialog{
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_skip)
    Button btnSkip;
    private RegisterActivity context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){
            context = (RegisterActivity) bundle.getSerializable("register");
        }
    }

    public static DialogSkipLogin newInstance(RegisterActivity registerActivity){
        DialogSkipLogin dialogSkipLogin = new DialogSkipLogin();
        Bundle bundle = new Bundle();
        bundle.putSerializable("register", registerActivity);
        dialogSkipLogin.setArguments(bundle);
        return dialogSkipLogin;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.dialog_skip_login;
    }

    @Override
    protected void setMessageError() {

    }

    @OnClick({R.id.btn_cancel,R.id.btn_skip})
    void doClick(View v){
        switch (v.getId()){
            case R.id.btn_cancel:
                dismiss();
                break;
            case R.id.btn_skip:
                //Request permission manage phone calls
                dismiss(); //Close dialog
                PermissionUtils.singlePermission(context,Manifest.permission.CALL_PHONE);
                break;
        }
    }
}
