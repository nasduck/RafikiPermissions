package com.nasduck.duckpermission.result.strategy;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.nasduck.duckpermission.util.PermissionUtils;

import java.util.List;

/**
 * Strategy customized
 */
public class PermissionResultCustomStrategy implements IPermissionResultStrategy {

    private PermissionResultCustomStrategyListener mListener;

    public PermissionResultCustomStrategy(PermissionResultCustomStrategyListener mListener) {
        this.mListener = mListener;
    }

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
