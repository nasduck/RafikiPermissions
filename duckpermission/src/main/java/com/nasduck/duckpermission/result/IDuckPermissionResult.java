package com.nasduck.duckpermission.result;

import android.app.Activity;
import android.support.annotation.NonNull;

public interface IDuckPermissionResult {

    /**
     *
     *
     * @param activity
     * @param permissions
     * @param grantResults
     * @return True if all permissions are granted
     */
    boolean onPermissionsResult(Activity activity, @NonNull String[] permissions, @NonNull int[] grantResults);

}
