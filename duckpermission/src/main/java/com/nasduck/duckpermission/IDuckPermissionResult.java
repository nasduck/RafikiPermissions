package com.nasduck.duckpermission;

import android.app.Activity;
import android.support.annotation.NonNull;

public interface IDuckPermissionResult {

    boolean onPermissionsResult(Activity activity, @NonNull String[] permissions, @NonNull int[] grantResults);

}
