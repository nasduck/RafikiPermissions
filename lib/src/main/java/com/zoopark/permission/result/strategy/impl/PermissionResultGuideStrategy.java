package com.zoopark.permission.result.strategy.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nasduck.rafikipermissions.R;
import com.zoopark.permission.result.dialog.DialogUtils;
import com.zoopark.permission.result.strategy.IPermissionResultStrategy;
import com.zoopark.permission.util.PermissionUtils;

import java.util.List;

/**
 * Guide users to grant permissions again if not granted
 */
public class PermissionResultGuideStrategy implements IPermissionResultStrategy {

    @Override
    public void onPermissionsResult(Context context, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        List<String> deniedPermissions = PermissionUtils.filterDeniedPermissions(permissions, grantResults);

        if (deniedPermissions.size() != 0) {
            String name = PermissionUtils.translatePermissions(context, deniedPermissions);
            showGuideDialog(context, name);
        }
    }

    /**
     * Show dialog to guide user to grant permissions
     *
     * @param context
     * @param permissions
     */
    private void showGuideDialog(final Context context, String permissions) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(R.string.guide_title) + "\n\n");
        sb.append(permissions);
        sb.append("\n" + context.getString(R.string.guide_footer));

        // Show Guide Dialog
        DialogUtils.showGuideDialog(context, sb.toString());
    }
}