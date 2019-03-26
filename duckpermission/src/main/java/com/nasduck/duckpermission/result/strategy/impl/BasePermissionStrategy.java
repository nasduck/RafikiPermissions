package com.nasduck.duckpermission.result.strategy.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nasduck.duckpermission.result.listener.OnPermissionResultListener;
import com.nasduck.duckpermission.result.strategy.IPermissionResultStrategy;

public class BasePermissionStrategy implements IPermissionResultStrategy {

    protected OnPermissionResultListener mListener;

    public void PermissionResultCustomStrategy(OnPermissionResultListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onPermissionsResult(Context context, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }
}
