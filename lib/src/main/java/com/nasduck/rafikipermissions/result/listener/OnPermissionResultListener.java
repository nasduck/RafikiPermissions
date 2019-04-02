package com.nasduck.rafikipermissions.result.listener;

public interface OnPermissionResultListener {
    void onPermissionsResultGrant(int requestCode);
    void onPermissionsResultDenied(int requestCode);
}
