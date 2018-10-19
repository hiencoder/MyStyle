package com.example.hiennv.mystyle.ui.intro;

import com.example.hiennv.mystyle.base.BasePresenter;
import com.example.hiennv.mystyle.base.BaseView;

public interface IntroContract {
    interface IntroView extends BaseView{

    }

    interface IntroPresenter<V extends IntroView> extends BasePresenter<V>{

    }
}
