package com.nasduck.duckpermission.result.strategy.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nasduck.duckpermission.result.listener.OnPermissionResultListener;
import com.nasduck.duckpermission.result.strategy.IPermissionResultStrategy;

public class BasePermissionStrategy implements IPermissionResultStrategy {

    protected OnPermissionResultListener mListener;

    public BasePermissionStrategy() {}

    public BasePermissionStrategy(OnPermissionResultListener listener) {
        this.mListener = listener;
    }

    public void setListener(OnPermissionResultListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onPermissionsResult(Context context, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }
}
