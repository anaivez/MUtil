package com.example.czm.mutil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


/**
 * @author czm
 * Desc:
 * @date 2020/1/2 0002
 **/
public class BaseActivity extends AppCompatActivity {

    public String TAG = getClass().getName();

    public int mCurPage = 0;
    public int mTotalPages;

    public ActivityManagerUtil activityManagerUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityManagerUtil = ActivityManagerUtil.getInstance();
        activityManagerUtil.pushOneActivity(this);
    }

    public Context getContext() {
        return this;
    }

    public Activity getActivity() {
        return this;
    }

    public void skipActivity(Class clazz) {
        startActivity(new Intent(this, clazz));
    }

    public void skipActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束Activity&从栈中移除该Activity
        activityManagerUtil.popOneActivity(this);
    }

}
