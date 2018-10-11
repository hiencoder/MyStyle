package com.example.hiennv.mystyle.ui.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.hiennv.mystyle.R;
import com.example.hiennv.mystyle.base.BaseDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class DialogErrorApi extends BaseDialog {
    @BindView(R.id.tv_error_message)
    TextView tvMessageError;
    private String mErrorMessage;

    public static DialogErrorApi newInstance(String message) {
        DialogErrorApi dialogErrorApi = new DialogErrorApi();
        Bundle bundle = new Bundle();
        bundle.putString("error", message);
        dialogErrorApi.setArguments(bundle);
        return dialogErrorApi;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mErrorMessage = bundle.getString("error");
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_error;
    }

    @Override
    protected void setMessageError() {
        if (mErrorMessage != null && !mErrorMessage.equals("")) {
            tvMessageError.setText(mErrorMessage);
        }
    }

    @OnClick({R.id.btn_ok, R.id.btn_close})
    void doClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close:
                dismiss();
                break;
            case R.id.btn_ok:
                dismiss();
                break;
        }
    }
}
