package com.example.hiennv.mystyle.ui.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hiennv.mystyle.R;
import com.example.hiennv.mystyle.base.BaseDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class DialogErrorConnection extends BaseDialog {
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.tv_error_message)
    TextView tvErrorMessage;
    @BindView(R.id.btn_ok)
    TextView btnOk;

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_error;
    }

    @Override
    protected void setMessageError() {
        tvErrorMessage.setText("");
    }

    @OnClick({R.id.btn_ok, R.id.btn_close})
    void doClick(View v){
        switch (v.getId()){
            case R.id.btn_close:
                dismiss();
                break;
            case R.id.btn_ok:
                dismiss();
                break;
        }
    }
}
