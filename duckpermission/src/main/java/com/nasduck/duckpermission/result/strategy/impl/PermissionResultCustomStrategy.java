package com.nasduck.duckpermission.result.strategy.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nasduck.duckpermission.util.PermissionUtils;

import java.util.List;

/**
 * Strategy customized
 */
public class PermissionResultCustomStrategy extends BasePermissionStrategy {

    @Override
    public void onPermissionsResult(Context context, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        List<String> deniedPermissions = PermissionUtils.filterDeniedPermissions(permissions, grantResults);
        if (deniedPermissions.size() == 0) {
            if (mListener != null) {
                mListener.onPermissionsResultGrant(requestCode);
            }
        } else {
            if (mListener != null) {
                mListener.onPermissionsResultDenied(requestCode);
            }
        }
    }
}
