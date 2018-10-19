package com.example.hiennv.mystyle.ui.splashscreen;

import com.example.hiennv.mystyle.base.BasePresenter;
import com.example.hiennv.mystyle.base.BaseView;

public interface SplashContract {
    interface SplashView extends BaseView{

    }

    interface SplashPresenter<V extends SplashView> extends BasePresenter<V>{

    }
}
