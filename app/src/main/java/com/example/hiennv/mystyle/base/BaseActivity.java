package com.example.hiennv.mystyle.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.Window;

import com.example.hiennv.mystyle.network.ApiEvent;

import com.example.hiennv.mystyle.ui.customview.DialogLoading;
import com.example.hiennv.mystyle.ui.dialog.DialogErrorApi;
import com.example.hiennv.mystyle.ui.dialog.DialogErrorConnection;
import com.example.hiennv.mystyle.ui.dialog.DialogTimeOutApi;
import com.example.hiennv.mystyle.utils.EventBusHelper;
import com.gabrielsamojlo.keyboarddismisser.KeyboardDismisser;

import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends AppCompatActivity {
    DialogErrorApi dialogErrorApi;
    DialogErrorConnection dialogErrorConnection;
    DialogTimeOutApi dialogTimeOutApi;

    DialogLoading dialogLoading;

    ViewGroup rootView;
    //Flag eventbus
    protected boolean isUnregisterEventBus = false;

    protected abstract int getLayoutId();

    protected abstract void initData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        onPresetContentView(savedInstanceState);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (Intent.ACTION_VIEW.equals(action)) {

        }
        setContentView(getLayoutId());
        onPostSetContentView(savedInstanceState);
        ButterKnife.bind(this);
        //register eventbus
        EventBusHelper.register(this);
        isUnregisterEventBus = false;

        KeyboardDismisser.useWith(this);

        //Init data
        initData();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        if (!isUnregisterEventBus) {
            EventBusHelper.unRegister(this);
        }
        super.onDestroy();
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onEventMainThread(ApiEvent event) {
        switch (event.apiEventType) {
            case SHOW_API_ERROR_DIALOG:
                showFragment("error_api");
                break;
            case SHOW_API_CONNECT_TIMEOUT:
                showFragment("error_connect_timeout");
                break;
            case SHOW_API_NO_CONNECT_NETWORK:
                showFragment("error_connect_network");
                break;
        }
    }

    /**
     *
     * @param tag
     */
    private void showFragment(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            ft.remove(fragment);
        }
        DialogErrorApi dialogErrorApi = DialogErrorApi.newInstance(tag);
        dialogErrorApi.show(ft,tag);
    }

    private void onPostSetContentView(Bundle savedInstanceState) {
        rootView = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
    }

    /**
     * @param savedInstanceState
     */
    private void onPresetContentView(Bundle savedInstanceState) {

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        //Use Calligraphy
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }
}
