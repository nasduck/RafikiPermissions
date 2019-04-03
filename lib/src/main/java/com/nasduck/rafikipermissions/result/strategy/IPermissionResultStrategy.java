package com.nasduck.rafikipermissions.result.strategy;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * All the permission onResult strategies should implement this interface.
 */
public interface IPermissionResultStrategy {

    /**
     *
     * @param context
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    void onPermissionsResult(Context context, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);

}
