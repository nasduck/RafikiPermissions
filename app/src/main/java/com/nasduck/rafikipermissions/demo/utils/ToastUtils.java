package com.nasduck.rafikipermissions.demo.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    private static Toast sToast = null;

    public static void showToast(Context context, String content) {
        if (sToast == null) {
            sToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(content);
        }
        sToast.show();
    }
}
