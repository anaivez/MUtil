package com.example.czm.mutil.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * Created by Lunger on 2017/2/8.
 */

public class SettingExecutor implements SettingService
{
    private Object object;
    private int requestCode;

    public SettingExecutor(@NonNull Object mObject, int mRequestCode) {
        object = mObject;
        requestCode = mRequestCode;
    }

    @Override
    public void execute() {
        Context context = PermissionUtils.getContext(object);
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        startForResult(object, intent, requestCode);
    }

    @Override
    public void cancel() {
    }

    private static void startForResult(Object object, Intent intent, int requestCode) {
        if (object instanceof Activity) {
            ((Activity) object).startActivityForResult(intent, requestCode);
        } else if (object instanceof Fragment) {
            ((Fragment) object).startActivityForResult(intent, requestCode);
        } else if (object instanceof android.app.Fragment) {
            ((android.app.Fragment) object).startActivityForResult(intent, requestCode);
        }
    }
}
