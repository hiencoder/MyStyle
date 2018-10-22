package com.example.hiennv.mystyle.ui.register;

import com.example.hiennv.mystyle.base.BasePresenter;
import com.example.hiennv.mystyle.base.BaseView;

public interface RegisterContract {
    interface RegisterView extends BaseView{
        void handleSkip();
        void handleFacebook();
        void handleLine();
        void handlePhoneNumber();
        void handleAlreadySignedUp();

        void handleAcceptPermission();
        void handleDenyPermission();
    }

    interface RegisterPresenter<V extends RegisterView> extends BasePresenter<V>{
        void handleSkip();
        void handleFacebook();
        void handleLine();
        void handlePhoneNumber();
        void handleAlreadySignedUp();
    }
}
