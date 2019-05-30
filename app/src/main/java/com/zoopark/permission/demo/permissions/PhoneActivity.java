package com.nasduck.rafikipermissions.demo.permissions;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.zoopark.permission.RafikiPermissions;
import com.nasduck.rafikipermissions.demo.R;
import com.nasduck.rafikipermissions.demo.base.BaseActivity;
import com.nasduck.rafikipermissions.demo.utils.ToastUtils;
import com.zoopark.permission.result.code.RafikiResultCode;
import com.zoopark.permission.result.listener.OnPermissionResultListener;
import com.zoopark.permission.result.strategy.impl.PermissionResultCustomStrategy;

public class PhoneActivity extends BaseActivity implements
        OnPermissionResultListener {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        findViewById(R.id.tv_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAppSettingClick();
            }
        });
    }

    public void onReadPhoneStateClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReadPhoneState()) {
            Toast.makeText(this, "Already granted read phone state permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onCallPhoneClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestCallPhone()) {
            Toast.makeText(this, "Already granted call phone permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReadCallLogClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReadCallLog()) {
            Toast.makeText(this, "Already granted read call log permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onWriteCallLogClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestWriteCallLog()) {
            Toast.makeText(this, "Already granted write call log permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onAddVoiceMailClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestAddVoiceMail()) {
            Toast.makeText(this, "Already granted add voice mail permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onUseSipClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestUseSip()) {
            Toast.makeText(this, "Already granted use sip permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onProcessOutgoingCallsClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestProcessOutgoingCalls()) {
            Toast.makeText(this, "Already granted process outgoing calls permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case RafikiResultCode.RESULT_CODE_READ_PHONE_STATE:
                ToastUtils.showToast(this, "Read Phone State Granted");
                break;
            case RafikiResultCode.RESULT_CODE_CALL_PHONE:
                ToastUtils.showToast(this, "Call Phone Granted");
                break;
            case RafikiResultCode.RESULT_CODE_READ_CALL_LOG:
                ToastUtils.showToast(this, "Read Call Log Granted");
                break;
            case RafikiResultCode.RESULT_CODE_WRITE_CALL_LOG:
                ToastUtils.showToast(this, "Write Call Log Granted");
                break;
            case RafikiResultCode.RESULT_CODE_ADD_VOICE_MAIL:
                ToastUtils.showToast(this, "Add Voice Mail Granted");
                break;
            case RafikiResultCode.RESULT_CODE_USE_SIP:
                ToastUtils.showToast(this, "Use sip Granted");
                break;
            case RafikiResultCode.RESULT_CODE_PROCESS_OUTGOING_CALLS:
                ToastUtils.showToast(this, "Process Outgoing Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case RafikiResultCode.RESULT_CODE_READ_PHONE_STATE:
                ToastUtils.showToast(this, "Read Phone State Denied");
                break;
            case RafikiResultCode.RESULT_CODE_CALL_PHONE:
                ToastUtils.showToast(this, "Call Phone Denied");
                break;
            case RafikiResultCode.RESULT_CODE_READ_CALL_LOG:
                ToastUtils.showToast(this, "Read Call Log Denied");
                break;
            case RafikiResultCode.RESULT_CODE_WRITE_CALL_LOG:
                ToastUtils.showToast(this, "Write Call Log Denied");
                break;
            case RafikiResultCode.RESULT_CODE_ADD_VOICE_MAIL:
                ToastUtils.showToast(this, "Add Voice Mail Denied");
                break;
            case RafikiResultCode.RESULT_CODE_USE_SIP:
                ToastUtils.showToast(this, "Use sip Denied");
                break;
            case RafikiResultCode.RESULT_CODE_PROCESS_OUTGOING_CALLS:
                ToastUtils.showToast(this, "Process Outgoing Denied");
                break;
        }
    }
}
