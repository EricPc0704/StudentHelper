package com.example.studentpi.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

public class Utils {

    /**
     * 检查当前Activity是否finished
     *
     * @param context 上下文
     * @return 结果
     */
    public static boolean activityFinished(Context context) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return context instanceof Activity && ((Activity) context).isDestroyed();
        } else {
            return context instanceof Activity && ((Activity) context).isFinishing();
        }
    }

}
