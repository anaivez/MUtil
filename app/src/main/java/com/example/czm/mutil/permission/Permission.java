package com.example.czm.mutil.permission;

import androidx.annotation.NonNull;

/**
 * Created by Lunger on 2017/2/7.
 */

public interface Permission {
    @NonNull
    Permission permission(String... permissions);

    @NonNull
    Permission requestCode(int requestCode);

    @NonNull
    Permission rationale(RationaleListener listener);

    void send();
}
