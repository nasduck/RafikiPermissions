package com.nasduck.duckpermission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.nasduck.duckpermission.result.strategy.IPermissionResultStrategy;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultNothingStrategy;
import com.nasduck.duckpermission.result.code.RafikiResultCode;
import com.nasduck.duckpermission.util.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

public class RafikiPermissions {

    private static RafikiPermissions DEFAULT;

    private List<String> mPermissionList;
    private int mResultCode;
    private static Context mContext;

    private IPermissionResultStrategy mResultStrategy;

    private RafikiPermissions(Context context) {
        this.mPermissionList = new ArrayList<>();
        this.mResultCode = RafikiResultCode.RAFIKI_PERMISSION_RESULT_CODE;
        this.mContext = context;
        this.mResultStrategy = new PermissionResultNothingStrategy();
    }

    public static RafikiPermissions getInstance(Context context) {
        if (DEFAULT == null) {
            DEFAULT = new RafikiPermissions(context);
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
    public boolean rafiki() {
        return request();
    }

    //* Setter ***********************************************************************************//

    public RafikiPermissions setResultCode(int resultCode) {
        this.mResultCode = resultCode;
        return this;
    }

    public RafikiPermissions setResultStrategy(IPermissionResultStrategy strategy) {
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

    public RafikiPermissions addPermissions(List<String> permissions) {
        this.mPermissionList.addAll(permissions);
        return this;
    }

    public RafikiPermissions addReadCalendar() {
        this.mPermissionList.add(Manifest.permission.READ_CALENDAR);
        return this;
    }

    public RafikiPermissions addWriteCalendar() {
        this.mPermissionList.add(Manifest.permission.WRITE_CALENDAR);
        return this;
    }

    public RafikiPermissions addCamera() {
        this.mPermissionList.add(Manifest.permission.CAMERA);
        return this;
    }

    public RafikiPermissions addReadContacts() {
        this.mPermissionList.add(Manifest.permission.READ_CONTACTS);
        return this;
    }

    public RafikiPermissions addWriteContacts() {
        this.mPermissionList.add(Manifest.permission.WRITE_CONTACTS);
        return this;
    }

    public RafikiPermissions addGetAccounts() {
        this.mPermissionList.add(Manifest.permission.GET_ACCOUNTS);
        return this;
    }

    public RafikiPermissions addAudioRecord() {
        this.mPermissionList.add(Manifest.permission.RECORD_AUDIO);
        return this;
    }

    public RafikiPermissions addAccessFineLocation() {
        this.mPermissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        return this;
    }

    public RafikiPermissions addAccessCoarseLocation() {
        this.mPermissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        return this;
    }

    public RafikiPermissions addReadPhoneState() {
        this.mPermissionList.add(Manifest.permission.READ_PHONE_STATE);
        return this;
    }

    public RafikiPermissions addCallPhone() {
        this.mPermissionList.add(Manifest.permission.CALL_PHONE);
        return this;
    }

    public RafikiPermissions addReadCallLog() {
        this.mPermissionList.add(Manifest.permission.READ_CALL_LOG);
        return this;
    }

    public RafikiPermissions addWriteCallLog() {
        this.mPermissionList.add(Manifest.permission.WRITE_CALL_LOG);
        return this;
    }

    public RafikiPermissions addAddVoiceMail() {
        this.mPermissionList.add(Manifest.permission.ADD_VOICEMAIL);
        return this;
    }

    public RafikiPermissions addUseSip() {
        this.mPermissionList.add(Manifest.permission.USE_SIP);
        return this;
    }

    public RafikiPermissions addProcessOutgoingCalls() {
        this.mPermissionList.add(Manifest.permission.PROCESS_OUTGOING_CALLS);
        return this;
    }

    public RafikiPermissions addBodySensors() {
        this.mPermissionList.add(Manifest.permission.BODY_SENSORS);
        return this;
    }

    public RafikiPermissions addSendSMS() {
        this.mPermissionList.add(Manifest.permission.SEND_SMS);
        return this;
    }

    public RafikiPermissions addReceiveSMS() {
        this.mPermissionList.add(Manifest.permission.RECEIVE_SMS);
        return this;
    }

    public RafikiPermissions addReadSMS() {
        this.mPermissionList.add(Manifest.permission.READ_SMS);
        return this;
    }

    public RafikiPermissions addReceiveWapPush() {
        this.mPermissionList.add(Manifest.permission.RECEIVE_WAP_PUSH);
        return this;
    }

    public RafikiPermissions addReceiveMMS() {
        this.mPermissionList.add(Manifest.permission.RECEIVE_MMS);
        return this;
    }

    public RafikiPermissions addReadExternalStorage() {
        this.mPermissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        return this;
    }

    public RafikiPermissions addWriteExternalStorage() {
        this.mPermissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return this;
    }

    //* request **********************************************************************************//

    public Boolean requestReadCalendar() {
        this.addReadCalendar();
        return request(RafikiResultCode.RESULT_CODE_READ_CALENDAR);
    }

    public Boolean requestWriteCalendar() {
        this.addWriteCalendar();
        return request(RafikiResultCode.RESULT_CODE_WRITE_CALENDAR);
    }

    public Boolean requestCamera() {
        this.addCamera();
        return request(RafikiResultCode.RESULT_CODE_CAMERA);
    }

    public Boolean requestReadContacts() {
        this.addReadContacts();
        return request(RafikiResultCode.RESULT_CODE_READ_CONTACTS);
    }

    public Boolean requestWriteContacts() {
        this.addWriteContacts();
        return request(RafikiResultCode.RESULT_CODE_WRITE_CONTACTS);
    }

    public Boolean requestGetAccounts() {
        this.addGetAccounts();
        return request(RafikiResultCode.RESULT_CODE_GET_ACCOUNTS);
    }

    public Boolean requestAudioRecord() {
        this.addAudioRecord();
        return request(RafikiResultCode.RESULT_CODE_RECORD_AUDIO);
    }

    public Boolean requestAccessFineLocation() {
        this.addAccessFineLocation();
        return request(RafikiResultCode.RESULT_CODE_ACCESS_FINE_LOCATION);
    }

    public Boolean requestAccessCoarseLocation() {
        this.addAccessCoarseLocation();
        return request(RafikiResultCode.RESULT_ACCESS_COARSE_LOCATION);
    }

    public Boolean requestReadPhoneState() {
        this.addReadPhoneState();
        return request(RafikiResultCode.RESULT_CODE_READ_PHONE_STATE);
    }

    public Boolean requestCallPhone() {
        this.addCallPhone();
        return request(RafikiResultCode.RESULT_CODE_CALL_PHONE);
    }

    public Boolean requestReadCallLog() {
        this.addReadCallLog();
        return request(RafikiResultCode.RESULT_CODE_READ_CALL_LOG);
    }

    public Boolean requestWriteCallLog() {
        this.addWriteCallLog();
        return request(RafikiResultCode.RESULT_CODE_WRITE_CALL_LOG);
    }

    public Boolean requestAddVoiceMail() {
        this.addAddVoiceMail();
        return request(RafikiResultCode.RESULT_CODE_ADD_VOICE_MAIL);
    }

    public Boolean requestUseSip() {
        this.addUseSip();
        return request(RafikiResultCode.RESULT_CODE_USE_SIP);
    }

    public Boolean requestProcessOutgoingCalls() {
        this.addProcessOutgoingCalls();
        return request(RafikiResultCode.RESULT_CODE_PROCESS_OUTGOING_CALLS);
    }

    public Boolean requestBodySensors() {
        this.addBodySensors();
        return request(RafikiResultCode.RESULT_CODE_BODY_SENSORS);
    }

    public Boolean requestSendSMS() {
        this.addSendSMS();
        return request(RafikiResultCode.RESULT_CODE_SEND_SMS);
    }

    public Boolean requestReceiveSMS() {
        this.addReceiveSMS();
        return request(RafikiResultCode.RESULT_CODE_RECEIVE_SMS);
    }

    public Boolean requestReadSMS() {
        this.addReadSMS();
        return request(RafikiResultCode.RESULT_CODE_READ_SMS);
    }

    public Boolean requestReceiveWapPush() {
        this.addReceiveWapPush();
        return request(RafikiResultCode.RESULT_CODE_RECEIVE_WAP_PUSH);
    }

    public Boolean requestReceiveMMS() {
        this.addReceiveMMS();
        return request(RafikiResultCode.RESULT_CODE_RECEIVE_MMS);
    }

    public Boolean requestReadExternalStorage() {
        this.addReadExternalStorage();
        return request(RafikiResultCode.RESULT_CODE_READ_EXTERNAL_STORAGE);
    }

    public Boolean requestWriteExternalStorage() {
        this.addWriteExternalStorage();
        return request(RafikiResultCode.RESULT_CODE_WRITE_EXTERNAL_STORAGE);
    }
}
