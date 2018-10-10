package com.example.hiennv.mystyle.base;

import android.content.Context;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.example.hiennv.mystyle.ui.dialog.DialogErrorApi;
import com.example.hiennv.mystyle.ui.dialog.DialogErrorConnection;
import com.example.hiennv.mystyle.ui.dialog.DialogTimeOutApi;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends AppCompatActivity {
    DialogErrorApi dialogErrorApi;
    DialogErrorConnection dialogErrorConnection;
    DialogTimeOutApi dialogTimeOutApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }
}
