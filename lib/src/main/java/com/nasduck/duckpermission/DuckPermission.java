package com.nasduck.duckpermission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.nasduck.duckpermission.result.strategy.IPermissionResultStrategy;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultNothingStrategy;
import com.nasduck.duckpermission.result.code.DuckResultCode;
import com.nasduck.duckpermission.util.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

public class DuckPermission {

    private static DuckPermission DEFAULT;

    private List<String> mPermissionList;
    private int mResultCode;
    private static Context mContext;

    private IPermissionResultStrategy mResultStrategy;

    private DuckPermission(Context context) {
        this.mPermissionList = new ArrayList<>();
        this.mResultCode = DuckResultCode.DUCK_PERMISSION_RESULT_CODE;
        this.mContext = context;
        this.mResultStrategy = new PermissionResultNothingStrategy();
    }

    public static DuckPermission getInstance(Context context) {
        if (DEFAULT == null) {
            DEFAULT = new DuckPermission(context);
        } else {
            mContext = context;
            DEFAULT.removeAllPermissions();
        }
        return DEFAULT;
    }

    public void onResult(int requestCode, String[] permissions, int[] grantResults) {
        mResultStrategy.onPermissionsResult(mContext, requestCode, permissions, grantResults);
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
                PermissionUtils.filterDeniedPermissions(mContext, mPermissionList);

        if(deniedPermissions.size() == 0) {
            return true;
        }

        // Request Permissions
        String[] deniedPermissionArray = deniedPermissions.toArray(new String[deniedPermissions.size()]);

        Activity activity = findActivity(mContext);
        if (activity != null) {
            ActivityCompat.requestPermissions(activity, deniedPermissionArray, resultCode);
        } else {
            throw new NullPointerException("No activity is found in the context passed in");
        }

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

    public DuckPermission setResultStrategy(IPermissionResultStrategy strategy) {
        this.mResultStrategy = strategy;
        return this;
    }

    //* Private **********************************************************************************//

    private static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            ContextWrapper wrapper = (ContextWrapper) context;
            return findActivity(wrapper.getBaseContext());
        } else {
            return null;
        }
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

    public DuckPermission addBodySensors() {
        this.mPermissionList.add(Manifest.permission.BODY_SENSORS);
        return this;
    }

    public DuckPermission addSendSMS() {
        this.mPermissionList.add(Manifest.permission.SEND_SMS);
        return this;
    }

    public DuckPermission addReceiveSMS() {
        this.mPermissionList.add(Manifest.permission.RECEIVE_SMS);
        return this;
    }

    public DuckPermission addReadSMS() {
        this.mPermissionList.add(Manifest.permission.READ_SMS);
        return this;
    }

    public DuckPermission addReceiveWapPush() {
        this.mPermissionList.add(Manifest.permission.RECEIVE_WAP_PUSH);
        return this;
    }

    public DuckPermission addReceiveMMS() {
        this.mPermissionList.add(Manifest.permission.RECEIVE_MMS);
        return this;
    }

    public DuckPermission addReadExternalStorage() {
        this.mPermissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        return this;
    }

    public DuckPermission addWriteExternalStorage() {
        this.mPermissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return this;
    }

    //* request **********************************************************************************//

    public Boolean requestReadCalendar() {
        this.addReadCalendar();
        return request(DuckResultCode.RESULT_CODE_READ_CALENDAR);
    }

    public Boolean requestWriteCalendar() {
        this.addWriteCalendar();
        return request(DuckResultCode.RESULT_CODE_WRITE_CALENDAR);
    }

    public Boolean requestReadCallLog() {
        this.addReadCallLog();
        return request(DuckResultCode.RESULT_CODE_READ_CALL_LOG);
    }

    public Boolean requestWriteCallLog() {
        this.addWriteCallLog();
        return request(DuckResultCode.RESULT_CODE_WRITE_CALL_LOG);
    }

    public Boolean requestProcessOutgoingCalls() {
        this.addProcessOutgoingCalls();
        return request(DuckResultCode.RESULT_CODE_PROCESS_OUTGOING_CALLS);
    }

    public Boolean requestCamera() {
        this.addCamera();
        return request(DuckResultCode.RESULT_CODE_CAMERA);
    }

    public Boolean requestReadContacts() {
        this.addReadContacts();
        return request(DuckResultCode.RESULT_CODE_READ_CONTACTS);
    }

    public Boolean requestWriteContacts() {
        this.addWriteContacts();
        return request(DuckResultCode.RESULT_CODE_WRITE_CONTACTS);
    }

    public Boolean requestGetAccounts() {
        this.addGetAccounts();
        return request(DuckResultCode.RESULT_CODE_GET_ACCOUNTS);
    }

    public Boolean requestAudioRecord() {
        this.addAudioRecord();
        return request(DuckResultCode.RESULT_CODE_RECORD_AUDIO);
    }

    public Boolean requestAccessFineLocation() {
        this.addAccessFineLocation();
        return request(DuckResultCode.RESULT_CODE_ACCESS_FINE_LOCATION);
    }

    public Boolean requestAccessCoarseLocation() {
        this.addAccessCoarseLocation();
        return request(DuckResultCode.RESULT_ACCESS_COARSE_LOCATION);
    }

    public Boolean requestReadPhoneState() {
        this.addReadPhoneState();
        return request(DuckResultCode.RESULT_CODE_READ_PHONE_STATE);
    }

    public Boolean requestReadPhoneNumbers() {
        this.addReadPhoneNumbers();
        return request(DuckResultCode.RESULT_CODE_READ_PHONE_NUMBERS);
    }

    public Boolean requestCallPhone() {
        this.addCallPhone();
        return request(DuckResultCode.RESULT_CODE_CALL_PHONE);
    }

    public Boolean requestAnswerPhoneCalls() {
        this.addAnswerPhoneCalls();
        return request(DuckResultCode.RESULT_CODE_ANSWER_PHONE_CALLS);
    }

    public Boolean requestAddVoiceMail() {
        this.addAddVoiceMail();
        return request(DuckResultCode.RESULT_CODE_ADD_VOICE_MAIL);
    }

    public Boolean requestUseSip() {
        this.addUseSip();
        return request(DuckResultCode.RESULT_CODE_USE_SIP);
    }

    public Boolean requestBodySensors() {
        this.addBodySensors();
        return request(DuckResultCode.RESULT_CODE_BODY_SENSORS);
    }

    public Boolean requestSendSMS() {
        this.addSendSMS();
        return request(DuckResultCode.RESULT_CODE_SEND_SMS);
    }

    public Boolean requestReceiveSMS() {
        this.addReceiveSMS();
        return request(DuckResultCode.RESULT_CODE_RECEIVE_SMS);
    }

    public Boolean requestReadSMS() {
        this.addReadSMS();
        return request(DuckResultCode.RESULT_CODE_READ_SMS);
    }

    public Boolean requestReceiveWapPush() {
        this.addReceiveWapPush();
        return request(DuckResultCode.RESULT_CODE_RECEIVE_WAP_PUSH);
    }

    public Boolean requestReceiveMMS() {
        this.addReceiveMMS();
        return request(DuckResultCode.RESULT_CODE_RECEIVE_MMS);
    }

    public Boolean requestReadExternalStorage() {
        this.addReadExternalStorage();
        return request(DuckResultCode.RESULT_CODE_READ_EXTERNAL_STORAGE);
    }

    public Boolean requestWriteExternalStorage() {
        this.addWriteExternalStorage();
        return request(DuckResultCode.RESULT_CODE_WRITE_EXTERNAL_STORAGE);
    }
}
