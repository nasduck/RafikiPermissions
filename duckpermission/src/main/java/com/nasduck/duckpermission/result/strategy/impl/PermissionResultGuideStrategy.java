package com.nasduck.duckpermission.result.strategy.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.nasduck.duckpermission.R;
import com.nasduck.duckpermission.result.listener.OnPermissionResultListener;
import com.nasduck.duckpermission.result.strategy.IPermissionResultStrategy;
import com.nasduck.duckpermission.util.PermissionUtils;

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
            showGuideDialog(context, requestCode, name);
        }
    }

    /**
     * Show dialog to guide user to grant permissions
     *
     * @param context
     * @param permissions
     */
    private void showGuideDialog(final Context context, final int requestCode, String permissions) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(R.string.guide_title) + "\n\n");
        sb.append(permissions);
        sb.append("\n" + context.getString(R.string.guide_footer));

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(sb.toString());
        builder.setPositiveButton(context.getString(R.string.grant), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + context.getPackageName()));
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                context.startActivity(i);
            }
        });
        builder.setNegativeButton(context.getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}