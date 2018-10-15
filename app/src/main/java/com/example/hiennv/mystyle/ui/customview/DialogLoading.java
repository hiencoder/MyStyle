package com.example.hiennv.mystyle.ui.customview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.hiennv.mystyle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogLoading extends Dialog {
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    public DialogLoading(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_loading);
        ButterKnife.bind(this);
        Window window = getWindow();
        //Set w/h Dialog
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        //Set background
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    //Hide dialog
    public void hideDialog(){
        try{
            if (isShowing()){
                dismiss();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Show dialog
    public void showDialog(){
        try{
            if (!isShowing()){
                show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
