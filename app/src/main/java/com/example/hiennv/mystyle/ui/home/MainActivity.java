package com.example.hiennv.mystyle.ui.home;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import com.example.hiennv.mystyle.R;
import com.example.hiennv.mystyle.base.BaseActivity;
import com.example.hiennv.mystyle.ui.dialog.DialogRequestAllPermission;

import java.io.Serializable;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends BaseActivity implements Serializable,MainContract.MainView{

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            //show dialog
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            Fragment fragment = fragmentManager.findFragmentByTag("dialog_all");
            if (fragment != null){
                ft.remove(fragment);
            }
            DialogRequestAllPermission dialogRequestAllPermission = DialogRequestAllPermission.newInstance(this);
            dialogRequestAllPermission.show(ft,"dialog_all");
        }
    }

    private void handleOpenFrontCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra("android.intent.extras.CAMERA_FACING",1);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
