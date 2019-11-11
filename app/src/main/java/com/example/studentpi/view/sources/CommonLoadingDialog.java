package com.example.studentpi.view.sources;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentpi.R;
import com.example.studentpi.utils.Utils;

/**
 * 公共Loading
 */
public class CommonLoadingDialog extends Dialog {

    private Context mContext;
    private TextView mTextView;
    private ImageView mLoadingIV;
    private Animation mAnimation;

    public CommonLoadingDialog(Context context) {
        super(context);
        initView(context);
    }

    public CommonLoadingDialog(Context context, int theme) {
        super(context, theme);
        initView(context);
    }

    public CommonLoadingDialog(Context context, boolean cancelable,
                               OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    @Override
    public void show() {
        super.show();
        if (Utils.activityFinished(mContext)) {
            return;
        }
        mAnimation = AnimationUtils.loadAnimation(mContext,
                R.anim.anim_loading);
        mLoadingIV.setAnimation(mAnimation);
    }

    @Override
    public void dismiss() {
        if (Utils.activityFinished(mContext)) {
            return;
        }
        if(mAnimation != null) {
            mAnimation.cancel();
            mAnimation = null;
        }
        super.dismiss();
    }

    private void initView(Context context) {
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.activity_loading, null);
        setContentView(view);

        mLoadingIV = (ImageView) findViewById(R.id.imageView12);
        mTextView = (TextView) findViewById(R.id.tv_content);

        setCanceledOnTouchOutside(false);
        setCancelable(true);
    }

    public void setMessage(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            mTextView.setText("数据加载中");
            return;
        }
        mTextView.setText(text);
    }
}
