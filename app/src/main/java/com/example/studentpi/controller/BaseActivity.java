package com.example.studentpi.controller;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.example.studentpi.R;
import com.example.studentpi.view.sources.CommonLoadingDialog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    public CommonLoadingDialog loadingDialog;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        initData();
    }

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();

    public abstract void doOnClick(View v);

    @Override
    public void onClick(View v) {
        doOnClick(v);
    }


    public void showLoadingProgressDialog(String msg) {
        if (loadingDialog == null) {
            loadingDialog = new CommonLoadingDialog(this, R.style.MyDialogStyle);// 创建自定义样式dialog
            loadingDialog.setOnDismissListener(mDialogDismissListener);
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.setMessage(msg);
            loadingDialog.show();
        }
    }
    private Dialog.OnDismissListener mDialogDismissListener = new DialogInterface.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialog) {
            Log.e("OnDismissListener", "OnDismissListener");
        }
    };
    public void removeLoadingProgressDialog(Context context) {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        loadingDialog = null;
    }

    public void removeLoadingProgressDialog() {
        removeLoadingProgressDialog(this);
    }
}
