package com.example.studentpi.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.example.studentpi.R;
import com.example.studentpi.view.sources.CommonLoadingDialog;

import androidx.fragment.app.Fragment;

/**
 * Fragment基类
 */
public class BaseFragment extends Fragment {
    //    public Context context;
    CommonLoadingDialog loadingDialog;

    /**
     * 得到自定义的progressDialog
     *
     * @param context
     * @param msg
     * @return
     */
    public void showLoadingProgressDialog(Context context, String msg) {
        if (loadingDialog == null) {
            loadingDialog = new CommonLoadingDialog(context, R.style.MyDialogStyle);// 创建自定义样式dialog
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

    /**
     * 消除自定义的progressDialog
     *
     * @param context
     * @return
     */
    public void removeLoadingProgressDialog(Context context) {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (loadingDialog != null) {
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            loadingDialog = null;
        }
    }
}
