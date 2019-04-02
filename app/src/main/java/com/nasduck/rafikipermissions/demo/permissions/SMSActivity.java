package com.nasduck.rafikipermissions.demo.permissions;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.nasduck.rafikipermissions.RafikiPermissions;
import com.nasduck.rafikipermissions.demo.R;
import com.nasduck.rafikipermissions.demo.base.BaseActivity;
import com.nasduck.rafikipermissions.demo.utils.ToastUtils;
import com.nasduck.rafikipermissions.result.code.RafikiResultCode;
import com.nasduck.rafikipermissions.result.listener.OnPermissionResultListener;
import com.nasduck.rafikipermissions.result.strategy.impl.PermissionResultCustomStrategy;

public class SMSActivity extends BaseActivity implements
        OnPermissionResultListener {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

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

    public void onSendSMSClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestSendSMS()) {
            Toast.makeText(this, "Already granted send SMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReceiveSMSClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReceiveSMS()) {
            Toast.makeText(this, "Already granted receive SMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReadSMSClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReadSMS()) {
            Toast.makeText(this, "Already granted read SMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReceiveWapPushClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReceiveWapPush()) {
            Toast.makeText(this, "Already granted receive wap push permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReceiveMMSClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReceiveMMS()) {
            Toast.makeText(this, "Already granted receive MMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case RafikiResultCode.RESULT_CODE_SEND_SMS:
                ToastUtils.showToast(this, "Send SMS Granted");
                break;
            case RafikiResultCode.RESULT_CODE_RECEIVE_SMS:
                ToastUtils.showToast(this, "Receive SMS Granted");
                break;
            case RafikiResultCode.RESULT_CODE_READ_SMS:
                ToastUtils.showToast(this, "Read SMS Granted");
                break;
            case RafikiResultCode.RESULT_CODE_RECEIVE_WAP_PUSH:
                ToastUtils.showToast(this, "WAP Push Granted");
                break;
            case RafikiResultCode.RESULT_CODE_RECEIVE_MMS:
                ToastUtils.showToast(this, "Receive MMS Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case RafikiResultCode.RESULT_CODE_SEND_SMS:
                ToastUtils.showToast(this, "Send SMS Denied");
                break;
            case RafikiResultCode.RESULT_CODE_RECEIVE_SMS:
                ToastUtils.showToast(this, "Receive SMS Denied");
                break;
            case RafikiResultCode.RESULT_CODE_READ_SMS:
                ToastUtils.showToast(this, "Read SMS Denied");
                break;
            case RafikiResultCode.RESULT_CODE_RECEIVE_WAP_PUSH:
                ToastUtils.showToast(this, "WAP Push Denied");
                break;
            case RafikiResultCode.RESULT_CODE_RECEIVE_MMS:
                ToastUtils.showToast(this, "Receive MMS Denied");
                break;
        }
    }
}
