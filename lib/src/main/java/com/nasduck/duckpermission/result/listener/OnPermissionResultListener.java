package com.nasduck.duckpermission.result.listener;

public interface OnPermissionResultListener {
    void onPermissionsResultGrant(int requestCode);
    void onPermissionsResultDenied(int requestCode);
}
