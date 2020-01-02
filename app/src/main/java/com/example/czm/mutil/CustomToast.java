package com.example.czm.mutil;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;


import androidx.annotation.StringRes;


/**
 * Created by czm on 2017/6/2.
 */
public class CustomToast {

    /**
     * 防止Toast重复显示
     */
    private static Toast mToast = null;

    /**
     * 字符串提示
     *
     * @param message
     * @param params
     */
    public static void makeText(Context context, String message, int... params) {
        try {
            if (context == null) {
                return;
            }
            if (TextUtils.isEmpty(message)) {
                return;
            }
            int showtime = params.length > 0 ? params[0] : Toast.LENGTH_SHORT;

            if (mToast == null) {
                mToast = Toast.makeText(context, message, showtime);
            } else {
                mToast.setText(message);
                mToast.setDuration(showtime);
            }
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * StringRes 提示
     *
     * @param message
     * @param params
     */
    public static void makeText(Context context, @StringRes int message, int... params) {
        if (context == null) {
            return;
        }
        int showtime = params.length > 0 ? params[0] : Toast.LENGTH_SHORT;
        if (mToast == null) {
            mToast = Toast.makeText(context, message, showtime);
            mToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            mToast.setText(message);
            mToast.setDuration(showtime);
        }
        mToast.show();
    }

}
