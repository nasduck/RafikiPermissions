package com.nasduck.duckpermission;

import android.Manifest;
import android.app.Activity;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

public class DuckPermission {

    public final static int DUCK_PERMISSION_RESULT_CODE = 999;

    private static DuckPermission DEFAULT;

    private List<String> mPermissionList;
    private int mResultCode;
    private Activity mActivity;

    private IDuckPermissionResult mOnResult;

    private DuckPermission(Activity activity) {
        this.mPermissionList = new ArrayList<>();
        this.mResultCode = DUCK_PERMISSION_RESULT_CODE;
        this.mActivity = activity;
        this.mOnResult = new RequestPermissionsResultNothing();
    }

    public static DuckPermission getInstance(Activity activity) {
        if (DEFAULT == null) {
            DEFAULT = new DuckPermission(activity);
        }
        DEFAULT.removeAllPermissions();
        return DEFAULT;
    }

    public boolean result(int[] grantResults) {
        return this.mOnResult.onPermissionsResult(mActivity,
                mPermissionList.toArray(new String[mPermissionList.size()]),
                grantResults);
    }

    public boolean request() {
        // If below 6.0, no need to request
        if(Build.VERSION.SDK_INT < 23){
            return true;
        }

        // Filter Permissions not granted yet
        List<String> deniedPermissionList =
                PermissionFilter.getDeniedPermissionList(mActivity, mPermissionList);

        if(deniedPermissionList.size() == 0) {
            return true;
        }

        String[] deniedPermissionArray = deniedPermissionList.toArray(new String[deniedPermissionList.size()]);
        ActivityCompat.requestPermissions(mActivity, deniedPermissionArray, mResultCode);

        return false;
    }

    /**
     * Method For Fun Only!
     *
     * @return
     */
    public boolean duck() {
        return request();
    }

    //* Setter ***********************************************************************************//

    public DuckPermission setResultCode(int resultCode) {
        this.mResultCode = resultCode;
        return this;
    }

    public DuckPermission setRequestResult(IDuckPermissionResult onResult) {
        this.mOnResult = onResult;
        return this;
    }

    //* Permissions ******************************************************************************//

    public void removeAllPermissions() {
        this.mPermissionList.clear();
        this.mPermissionList = new ArrayList<>();
    }

    public DuckPermission requestPermissions(List<String> permissions) {
        this.mPermissionList.addAll(permissions);
        return this;
    }

    public DuckPermission requestAudioRecord() {
        this.mPermissionList.add(Manifest.permission.RECORD_AUDIO);
        return this;
    }


}
