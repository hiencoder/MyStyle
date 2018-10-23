package com.example.hiennv.mystyle.ui.dialog;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.hiennv.mystyle.R;
import com.example.hiennv.mystyle.base.BaseDialog;
import com.example.hiennv.mystyle.ui.home.MainActivity;
import com.example.hiennv.mystyle.utils.PermissionUtils;
import com.karumi.dexter.Dexter;

import butterknife.BindView;
import butterknife.OnClick;

public class DialogRequestAllPermission extends BaseDialog{
    @BindView(R.id.btn_allow_all)
    Button btnAllowAll;
    MainActivity mainActivity;

    public static DialogRequestAllPermission newInstance(MainActivity mainActivity){
        DialogRequestAllPermission dialog = new DialogRequestAllPermission();

        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_all_permission;
    }

    @Override
    protected void setMessageError() {

    }

    @OnClick(R.id.btn_allow_all)
    void doClick(View v){
        switch (v.getId()){
            case R.id.btn_allow_all:
                PermissionUtils.allPermission(mainActivity,
                        new String[]{Manifest.permission.CALL_PHONE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE});
                break;
        }
    }
}
