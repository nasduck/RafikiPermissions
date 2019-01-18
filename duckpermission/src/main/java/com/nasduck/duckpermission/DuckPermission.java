package com.nasduck.duckpermission;

import android.Manifest;
import android.app.Activity;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.nasduck.duckpermission.result.IDuckPermissionResult;
import com.nasduck.duckpermission.result.RequestPermissionsResultNothing;
import com.nasduck.duckpermission.util.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

public class DuckPermission {

    public final static int DUCK_PERMISSION_RESULT_CODE = 999;
    public final static int RESULT_CODE_RECORD_AUDIO = 998;
    // LOCATION
    public final static int RESULT_CODE_ACCESS_FINE_LOCATION = 997;
    public final static int RESULT_ACCESS_COARSE_LOCATION = 996;

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
        return request(mResultCode);
    }

    public boolean request(int resultCode) {
        // If below 6.0, no need to request
        if(Build.VERSION.SDK_INT < 23){
            return true;
        }

        // Filter Permissions not granted yet
        List<String> deniedPermissions =
                PermissionUtils.filterDeniedPermissions(mActivity, mPermissionList);

        if(deniedPermissions.size() == 0) {
            return true;
        }

        // Request Permissions
        String[] deniedPermissionArray = deniedPermissions.toArray(new String[deniedPermissions.size()]);
        ActivityCompat.requestPermissions(mActivity, deniedPermissionArray, resultCode);

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

    public DuckPermission addPermissions(List<String> permissions) {
        this.mPermissionList.addAll(permissions);
        return this;
    }

    public DuckPermission addAudioRecord() {
        this.mPermissionList.add(Manifest.permission.RECORD_AUDIO);
        return this;
    }

    public DuckPermission addAccessFineLocation() {
        this.mPermissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        return this;
    }

    public DuckPermission addAccessCoarseLocation() {
        this.mPermissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        return this;
    }

    //

    public Boolean requestAudioRecord() {
        this.addAudioRecord();
        return request(RESULT_CODE_RECORD_AUDIO);
    }

    public Boolean requestAccessFineLocation() {
        this.addAccessFineLocation();
        return request(RESULT_CODE_ACCESS_FINE_LOCATION);
    }

    public Boolean requestAccessCoarseLocation() {
        this.addAccessCoarseLocation();
        return request(RESULT_ACCESS_COARSE_LOCATION);
    }
}
