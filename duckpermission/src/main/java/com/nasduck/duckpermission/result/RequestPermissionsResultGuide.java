package com.nasduck.duckpermission.result;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.util.Log;

import com.nasduck.duckpermission.SetPermissions;
import com.nasduck.duckpermission.util.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Guide users to grant permissions again if not granted
 */
public class RequestPermissionsResultGuide implements IDuckPermissionResult {

    @Override
    public boolean onPermissionsResult(Activity activity, @NonNull String[] permissions, @NonNull int[] grantResults) {

        List<String> deniedPermissions = PermissionUtils.filterDeniedPermissions(permissions, grantResults);

        if (deniedPermissions.size() == 0) {
            return true;
        } else {
            String name = PermissionUtils.getInstance().getPermissionNames(deniedPermissions);
            SetPermissions.openAppDetails(activity, name);
            return false;
        }
    }
}