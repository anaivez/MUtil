package com.example.czm.mutil.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

/**
 * Created by Lunger on 2017/2/7.
 */

public class PermissionUtils {
    static Context getContext(Object o) {
        if (o instanceof Activity) {
            return (Activity) o;
        } else if (o instanceof Fragment) {
            return ((Fragment) o).getActivity();
        } else if (o instanceof android.app.Fragment) {
            return ((android.app.Fragment) o).getActivity();
        } else {
            throw new IllegalArgumentException("The " + o.getClass().getName() + " is not support.");
        }
    }

    static boolean shouldShowRationalePermissions(Object object, String... permissions) {
        boolean rationale = false;
        if (Build.VERSION.SDK_INT < 23) {
            return rationale;
        }
        for (String permission : permissions) {
            if (object instanceof Activity) {
                rationale = ActivityCompat.shouldShowRequestPermissionRationale((Activity) object, permission);
            } else if (object instanceof Fragment) {
                rationale = ((Fragment) object).shouldShowRequestPermissionRationale(permission);
            } else if (object instanceof android.app.Fragment) {
                rationale = ((android.app.Fragment) object).shouldShowRequestPermissionRationale(permission);
            }
            if (rationale) {
                return rationale;
            }
        }
        return rationale;
    }
}
