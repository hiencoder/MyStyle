package com.example.hiennv.mystyle.ui.home;

import com.example.hiennv.mystyle.base.BasePresenter;
import com.example.hiennv.mystyle.base.BaseView;

public interface MainContract {
    interface MainView extends BaseView{

    }

    interface MainPresenter<V extends MainView> extends BasePresenter<V>{}
}
