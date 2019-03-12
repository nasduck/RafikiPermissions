package com.nasduck.duckpermission.result.strategy;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nasduck.duckpermission.util.PermissionUtils;

import java.util.List;

/**
 * Strategy customized
 */
public class PermissionResultCustomStrategy implements IPermissionResultStrategy {

    private PermissionResultCustomStrategyListener mListener;

    interface PermissionResultCustomStrategyListener {
        void onPermissionsResultGrant();
        void onPermissionsResultDenied();
    }

    @Override
    public boolean onPermissionsResult(Context context, @NonNull String[] permissions, @NonNull int[] grantResults) {
        List<String> deniedPermissions = PermissionUtils.filterDeniedPermissions(permissions, grantResults);

        if (deniedPermissions.size() == 0) {
            if (mListener != null) {
                mListener.onPermissionsResultGrant();
            }
            return true;
        } else {
            String name = PermissionUtils.translatePermissions(context, deniedPermissions);
            if (mListener != null) {
                mListener.onPermissionsResultDenied();
            }
            return false;
        }
    }

    public void setmListener(PermissionResultCustomStrategyListener mListener) {
        this.mListener = mListener;
    }
}
