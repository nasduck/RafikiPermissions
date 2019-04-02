package com.nasduck.rafikipermissions.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import com.nasduck.rafikipermissions.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermissionUtils {

    public static List<String> filterDeniedPermissions(Context context, List<String> permissions) {
        List<String> deniedPermissions = new ArrayList<>();

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permission);
            }
        }

        return deniedPermissions;
    }

    public static List<String> filterDeniedPermissions(Context context, String[] permissions) {
        List<String> deniedPermissions = new ArrayList<>();

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permission);
            }
        }

        return deniedPermissions;
    }

    public static List<String> filterDeniedPermissions(String[] permissions, int[] grantResults) {
        List<String> deniedPermissions = new ArrayList<>();

        if (permissions.length == 0) return deniedPermissions;

        for (int i = 0; i < grantResults.length; i++) {
            if(grantResults[i] == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permissions[i]);
            }
        }

        return deniedPermissions;
    }

    public static HashMap<String,String> getPermissionsMap(Context context) {

        HashMap<String, String> map = new HashMap<>();

        // Calendar
        map.put("android.permission.READ_CALENDAR", "--" + context.getString(R.string.calendar));
        map.put("android.permission.WRITE_CALENDAR", "--" + context.getString(R.string.calendar));

        // Camera
        map.put("android.permission.CAMERA",  "--" + context.getString(R.string.camera));

        // Contacts
        map.put("android.permission.WRITE_CONTACTS", "--" + context.getString(R.string.contacts));
        map.put("android.permission.GET_ACCOUNTS", "--" + context.getString(R.string.contacts));
        map.put("android.pxwermission.READ_CONTACTS", "--" + context.getString(R.string.contacts));

        // Location
        map.put("android.permission.ACCESS_FINE_LOCATION", "--" + context.getString(R.string.location));
        map.put("android.permission.ACCESS_COARSE_LOCATION", "--" + context.getString(R.string.location));

        // Sensors
        map.put("android.permission.BODY_SENSORS",  "--" + context.getString(R.string.sensors));

        // SMS
        map.put("android.permission.SEND_SMS", "--" + context.getString(R.string.sms));
        map.put("android.permission.RECEIVE_SMS", "--" + context.getString(R.string.sms));
        map.put("android.permission.READ_SMS", "--" + context.getString(R.string.sms));
        map.put("android.permission.RECEIVE_WAP_PUSH", "--" + context.getString(R.string.sms));
        map.put("android.permission.RECEIVE_MMS", "--" + context.getString(R.string.sms));

        // Microphone
        map.put("android.permission.RECORD_AUDIO", "--" + context.getString(R.string.microphone));

        // Phone
        map.put("android.permission.READ_PHONE_STATE", "--" + context.getString(R.string.phone));
        map.put("android.permission.CALL_PHONE", "--" + context.getString(R.string.phone));
        map.put("android.permission.READ_CALL_LOG", "--" + context.getString(R.string.call_log));
        map.put("android.permission.WRITE_CALL_LOG", "--" + context.getString(R.string.call_log));
        map.put("com.android.voicemail.permission.ADD_VOICEMAIL", "--" + context.getString(R.string.phone));
        map.put("android.permission.USE_SIP", "--" + context.getString(R.string.phone));
        map.put("android.permission.PROCESS_OUTGOING_CALLS", "--" + context.getString(R.string.phone));

        // Storage
        map.put("android.permission.READ_EXTERNAL_STORAGE", "--" + context.getString(R.string.storage));
        map.put("android.permission.WRITE_EXTERNAL_STORAGE", "--" + context.getString(R.string.storage));

        return map;
    }

    public static String translatePermissions(Context context, List<String> permission) {
        if(permission==null || permission.size()==0){
            return "\n";
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        HashMap<String, String> permissions = getPermissionsMap(context);

        for(int i=0; i<permission.size(); i++){
            String name = permissions.get(permission.get(i));
            if(name != null && !list.contains(name)) {
                list.add(name);
                sb.append(name);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
