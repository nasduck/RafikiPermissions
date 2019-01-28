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
    // CALENDAR
    public final static int RESULT_CODE_READ_CALENDAR = 998;
    public final static int RESULT_CODE_WRITE_CALENDAR = 997;
    // CALL_LOG
    public final static int RESULT_CODE_READ_CALL_LOG = 996;
    public final static int RESULT_CODE_WRITE_CALL_LOG = 995;
    public final static int RESULT_CODE_PROCESS_OUTGOING_CALLS = 994;
    // CAMERA
    public final static int RESULT_CODE_CAMERA = 993;
    // CONTACTS
    public final static int RESULT_CODE_READ_CONTACTS = 992;
    public final static int RESULT_CODE_WRITE_CONTACTS = 991;
    public final static int RESULT_CODE_GET_ACCOUNTS = 990;
    // LOCATION
    public final static int RESULT_CODE_ACCESS_FINE_LOCATION = 989;
    public final static int RESULT_ACCESS_COARSE_LOCATION = 988;
    // MICROPHONE
    public final static int RESULT_CODE_RECORD_AUDIO = 987;
    // PHONE
    public final static int RESULT_CODE_READ_PHONE_STATE= 986;
    public final static int RESULT_CODE_READ_PHONE_NUMBERS= 985;
    public final static int RESULT_CODE_CALL_PHONE= 984;
    public final static int RESULT_CODE_ANSWER_PHONE_CALLS= 983;
    public final static int RESULT_CODE_ADD_VOICE_MAIL = 982;
    public final static int RESULT_CODE_USE_SIP= 981;
    // SENSORS
    public final static int RESULT_CODE_BODY_SENSORS = 980;
    // SMS
    public final static int RESULT_CODE_SEND_SMS = 979;
    public final static int RESULT_CODE_RECEIVE_SMS = 978;
    public final static int RESULT_CODE_READ_SMS = 977;
    public final static int RESULT_CODE_RECEIVE_WAP_PUSH = 976;
    public final static int RESULT_CODE_RECEIVE_MMS = 975;
    // STORAGE
    public final static int RESULT_CODE_READ_EXTERNAL_STORAGE = 974;
    public final static int RESULT_CODE_WRITE_EXTERNAL_STORAGE = 973;

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

    public DuckPermission addReadCalendar() {
        this.mPermissionList.add(Manifest.permission.READ_CALENDAR);
        return this;
    }

    public DuckPermission addWriteCalendar() {
        this.mPermissionList.add(Manifest.permission.WRITE_CALENDAR);
        return this;
    }

    public DuckPermission addReadCallLog() {
        this.mPermissionList.add(Manifest.permission.READ_CALL_LOG);
        return this;
    }

    public DuckPermission addWriteCallLog() {
        this.mPermissionList.add(Manifest.permission.WRITE_CALL_LOG);
        return this;
    }

    public DuckPermission addProcessOutgoingCalls() {
        this.mPermissionList.add(Manifest.permission.PROCESS_OUTGOING_CALLS);
        return this;
    }

    public DuckPermission addCamera() {
        this.mPermissionList.add(Manifest.permission.CAMERA);
        return this;
    }

    public DuckPermission addReadContacts() {
        this.mPermissionList.add(Manifest.permission.READ_CONTACTS);
        return this;
    }

    public DuckPermission addWriteContacts() {
        this.mPermissionList.add(Manifest.permission.WRITE_CONTACTS);
        return this;
    }

    public DuckPermission addGetAccounts() {
        this.mPermissionList.add(Manifest.permission.GET_ACCOUNTS);
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

    public DuckPermission addReadPhoneState() {
        this.mPermissionList.add(Manifest.permission.READ_PHONE_STATE);
        return this;
    }

    public DuckPermission addReadPhoneNumbers() {
        this.mPermissionList.add(Manifest.permission.READ_PHONE_NUMBERS);
        return this;
    }

    public DuckPermission addCallPhone() {
        this.mPermissionList.add(Manifest.permission.CALL_PHONE);
        return this;
    }

    public DuckPermission addAnswerPhoneCalls() {
        this.mPermissionList.add(Manifest.permission.ANSWER_PHONE_CALLS);
        return this;
    }

    public DuckPermission addAddVoiceMail() {
        this.mPermissionList.add(Manifest.permission.ADD_VOICEMAIL);
        return this;
    }

    public DuckPermission addUseSip() {
        this.mPermissionList.add(Manifest.permission.USE_SIP);
        return this;
    }

    //* request **********************************************************************************//

    public Boolean requestReadCalendar() {
        this.addReadCalendar();
        return request(RESULT_CODE_READ_CALENDAR);
    }

    public Boolean requestWriteCalendar() {
        this.addWriteCalendar();
        return request(RESULT_CODE_WRITE_CALENDAR);
    }

    public Boolean requestReadCallLog() {
        this.addReadCallLog();
        return request(RESULT_CODE_READ_CALL_LOG);
    }

    public Boolean requestWriteCallLog() {
        this.addWriteCallLog();
        return request(RESULT_CODE_WRITE_CALL_LOG);
    }

    public Boolean requestProcessOutgoingCalls() {
        this.addProcessOutgoingCalls();
        return request(RESULT_CODE_PROCESS_OUTGOING_CALLS);
    }

    public Boolean requestCamera() {
        this.addCamera();
        return request(RESULT_CODE_CAMERA);
    }

    public Boolean requestReadContacts() {
        this.addReadContacts();
        return request(RESULT_CODE_READ_CONTACTS);
    }

    public Boolean requestWriteContacts() {
        this.addWriteContacts();
        return request(RESULT_CODE_WRITE_CONTACTS);
    }

    public Boolean requestGetAccounts() {
        this.addGetAccounts();
        return request(RESULT_CODE_GET_ACCOUNTS);
    }

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

    public Boolean requestReadPhoneState() {
        this.addReadPhoneState();
        return request(RESULT_CODE_READ_PHONE_STATE);
    }

    public Boolean requestReadPhoneNumbers() {
        this.addReadPhoneNumbers();
        return request(RESULT_CODE_READ_PHONE_NUMBERS);
    }

    public Boolean requestCallPhone() {
        this.addCallPhone();
        return request(RESULT_CODE_CALL_PHONE);
    }

    public Boolean requestAnswerPhoneCalls() {
        this.addAnswerPhoneCalls();
        return request(RESULT_CODE_ANSWER_PHONE_CALLS);
    }

    public Boolean requestAddVoiceMail() {
        this.addAddVoiceMail();
        return request(RESULT_CODE_ADD_VOICE_MAIL);
    }

    public Boolean requestUseSip() {
        this.addUseSip();
        return request(RESULT_CODE_USE_SIP);
    }
}
