package com.zoopark.permission.result.listener;

public interface OnPermissionResultListener {
    void onPermissionsResultGrant(int requestCode);
    void onPermissionsResultDenied(int requestCode);
}
