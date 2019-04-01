package com.nasduck.duckpermission.result.strategy.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nasduck.duckpermission.result.strategy.IPermissionResultStrategy;

/**
 * Do nothing if not granted
 */
public class PermissionResultNothingStrategy implements IPermissionResultStrategy {

    @Override
    public void onPermissionsResult(Context context, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // do nothing if permission denied
    }
}