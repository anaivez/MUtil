package com.example.czm.mutil;

import android.Manifest;
import android.os.Bundle;

import com.example.czm.mutil.permission.PermissionListener;
import com.example.czm.mutil.permission.PermissionManage;

import java.util.List;

import androidx.annotation.NonNull;

/**
 * @author czm
 * Desc:
 * @date 2020/1/2 0002
 **/
public abstract class BasePermissionActivity extends BaseActivity {

    private final int WHAT_PERMISSION = 0x100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!PermissionManage.hasPermission(this
                , getPermission()
        )) {
            PermissionManage.with(this)
                    .requestCode(WHAT_PERMISSION)
                    .permission(getPermission())
                    .send();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManage.onRequestPermissionsResult(requestCode, permissions, grantResults, listener);
    }

    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
            onSucced(requestCode, grantedPermissions);
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            onFailed(requestCode, deniedPermissions);
        }
    };

    public abstract String[] getPermission();

    public abstract void onSucced(int requestCode, List<String> grantedPermissions);

    public abstract void onFailed(int requestCode, List<String> deniedPermissions);

}
