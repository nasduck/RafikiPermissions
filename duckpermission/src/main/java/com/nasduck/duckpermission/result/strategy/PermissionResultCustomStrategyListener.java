package com.nasduck.duckpermission.result.strategy;

public interface PermissionResultCustomStrategyListener {
    void onPermissionsResultGrant(int requestCode);
    void onPermissionsResultDenied(int requestCode);
}
