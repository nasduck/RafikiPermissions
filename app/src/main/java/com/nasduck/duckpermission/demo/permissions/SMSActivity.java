package com.nasduck.duckpermission.demo.permissions;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.demo.R;
import com.nasduck.duckpermission.demo.base.BaseActivity;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.code.DuckResultCode;
import com.nasduck.duckpermission.result.listener.OnPermissionResultListener;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultCustomStrategy;

public class SMSActivity extends BaseActivity implements
        OnPermissionResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
    }

    public void onSendSMSClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestSendSMS()) {
            Toast.makeText(this, "Already granted send SMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReceiveSMSClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReceiveSMS()) {
            Toast.makeText(this, "Already granted receive SMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReadSMSClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReadSMS()) {
            Toast.makeText(this, "Already granted read SMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReceiveWapPushClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReceiveWapPush()) {
            Toast.makeText(this, "Already granted receive wap push permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReceiveMMSClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReceiveMMS()) {
            Toast.makeText(this, "Already granted receive MMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_SEND_SMS:
                ToastUtils.showToast(this, "Send SMS Granted");
                break;
            case DuckResultCode.RESULT_CODE_RECEIVE_SMS:
                ToastUtils.showToast(this, "Receive SMS Granted");
                break;
            case DuckResultCode.RESULT_CODE_READ_SMS:
                ToastUtils.showToast(this, "Read SMS Granted");
                break;
            case DuckResultCode.RESULT_CODE_RECEIVE_WAP_PUSH:
                ToastUtils.showToast(this, "WAP Push Granted");
                break;
            case DuckResultCode.RESULT_CODE_RECEIVE_MMS:
                ToastUtils.showToast(this, "Receive MMS Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_SEND_SMS:
                ToastUtils.showToast(this, "Send SMS Denied");
                break;
            case DuckResultCode.RESULT_CODE_RECEIVE_SMS:
                ToastUtils.showToast(this, "Receive SMS Denied");
                break;
            case DuckResultCode.RESULT_CODE_READ_SMS:
                ToastUtils.showToast(this, "Read SMS Denied");
                break;
            case DuckResultCode.RESULT_CODE_RECEIVE_WAP_PUSH:
                ToastUtils.showToast(this, "WAP Push Denied");
                break;
            case DuckResultCode.RESULT_CODE_RECEIVE_MMS:
                ToastUtils.showToast(this, "Receive MMS Denied");
                break;
        }
    }
}
