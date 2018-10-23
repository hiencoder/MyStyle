package com.example.hiennv.mystyle.ui.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hiennv.mystyle.R;
import com.example.hiennv.mystyle.app.MyApplication;
import com.example.hiennv.mystyle.base.BaseActivity;
//import com.example.hiennv.mystyle.di.component.DaggerRegisterComponent;
import com.example.hiennv.mystyle.di.component.RegisterComponent;
import com.example.hiennv.mystyle.di.module.RegisterMvpModule;

import java.io.Serializable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterContract.RegisterView, Serializable{
    @BindView(R.id.btn_skip)
    TextView btnSkip;
    @BindView(R.id.btn_facebook)
    Button btnFacekbook;
    @BindView(R.id.btn_line)
    Button btnLine;
    @BindView(R.id.btn_phone_number)
    Button btnPhoneNumber;

    RegisterComponent registerComponent;
    /*@Inject
    RegisterPresenterImpl<RegisterContract.RegisterView> registerPresenter;*/

    RegisterPresenterImpl<RegisterContract.RegisterView> registerPresenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*registerComponent = DaggerRegisterComponent.builder()
                .appComponent(MyApplication.getApplication(this).getAppComponent()) //Dependencies AppComponent
                .registerMvpModule(new RegisterMvpModule(this))
                .build();
        registerComponent.inject(this);*/
        registerPresenter = new RegisterPresenterImpl<>(this,this);
    }

    @OnClick({R.id.btn_skip, R.id.btn_facebook, R.id.btn_line, R.id.btn_phone_number, R.id.tv_already_signup})
    void doClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip:
                registerPresenter.handleSkip();
                break;
            case R.id.btn_facebook:
                registerPresenter.handleFacebook();
                break;
            case R.id.btn_line:
                registerPresenter.handleLine();
                break;
            case R.id.btn_phone_number:
                registerPresenter.handlePhoneNumber();
                break;
            case R.id.tv_already_signup:
                registerPresenter.handleAlreadySignedUp();
                break;
        }
    }

    @Override
    public void handleAcceptPermission() {

    }

    @Override
    public void handleDenyPermission() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
