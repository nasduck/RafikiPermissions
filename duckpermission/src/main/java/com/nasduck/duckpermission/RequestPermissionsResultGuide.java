package com.nasduck.duckpermission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果授权失败，引导用户进行应用授权
 */
public class RequestPermissionsResultGuide implements IDuckPermissionResult {

    @Override
    public boolean onPermissionsResult(Activity activity, @NonNull String[] permissions, @NonNull int[] grantResults) {

        List<String> deniedPermissionList = new ArrayList<>();

        for (int i = 0; i < grantResults.length; i++){
            if(grantResults[i] == PackageManager.PERMISSION_DENIED){
                deniedPermissionList.add(permissions[i]);
            }
        }

        if (deniedPermissionList.size() == 0) {
            return true;
        } else {
            String name = PermissionUtils.getInstance().getPermissionNames(deniedPermissionList);
            SetPermissions.openAppDetails(activity, name);
            return false;
        }
    }
}