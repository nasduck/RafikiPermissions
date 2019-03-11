package com.nasduck.duckpermission.result;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

public interface IDuckPermissionResult {

    /**
     *
     *
     * @param context
     * @param permissions
     * @param grantResults
     * @return True if all permissions are granted
     */
    boolean onPermissionsResult(Context context, @NonNull String[] permissions, @NonNull int[] grantResults);

}
