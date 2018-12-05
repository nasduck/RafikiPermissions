package com.nasduck.duckpermission;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

public class SetPermissions {

    /**
     * 打开APP详情页面，引导用户去设置权限
     *
     * @param activity 页面对象
     * @param permissionNames 权限名称（如是多个，使用\n分割）
     */
    public static void openAppDetails(final Activity activity, String permissionNames) {
        StringBuilder sb = new StringBuilder();
        sb.append("亲爱的用户 \n\n软件部分功能需要请求您的手机权限，请允许以下权限：\n\n");
        sb.append(permissionNames);
        sb.append("\n请到 “应用信息 -> 权限” 中授予！");

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(sb.toString());
        builder.setPositiveButton("去手动授权", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                activity.startActivity(intent);
            }
        });
        builder.setNegativeButton("取消", null);
        builder.show();
    }
}
