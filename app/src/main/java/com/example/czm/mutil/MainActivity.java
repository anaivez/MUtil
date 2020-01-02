package com.example.czm.mutil;

import android.Manifest;
import android.os.Bundle;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends BasePermissionActivity {


    @Override
    public String[] getPermission() {
        return new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
                , Manifest.permission.MODIFY_AUDIO_SETTINGS
                , Manifest.permission.ACCESS_NETWORK_STATE
                , Manifest.permission.VIBRATE
                , Manifest.permission.BLUETOOTH
                , Manifest.permission.ACCESS_WIFI_STATE
                , Manifest.permission.RECORD_AUDIO
                , Manifest.permission.WAKE_LOCK
                , Manifest.permission.BROADCAST_STICKY
                , Manifest.permission.READ_PHONE_STATE
                , Manifest.permission.READ_EXTERNAL_STORAGE
                , Manifest.permission.CAMERA
        };
    }

    @Override
    public void onSucced(int requestCode, List<String> grantedPermissions) {
        CustomToast.makeText(getContext(), "Success");
    }

    @Override
    public void onFailed(int requestCode, List<String> deniedPermissions) {
        CustomToast.makeText(getContext(), "Failed");
    }


}
