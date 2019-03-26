package com.nasduck.duckpermission.demo.permissions;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.demo.R;
import com.nasduck.duckpermission.demo.base.BaseActivity;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.code.DuckResultCode;
import com.nasduck.duckpermission.result.listener.OnPermissionResultListener;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultCustomStrategy;

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
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReadPhoneState()) {
            Toast.makeText(this, "Already granted read phone state permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReadPhoneNumbersClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReadPhoneNumbers()) {
            Toast.makeText(this, "Already granted read phone numbers permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onCallPhoneClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestCallPhone()) {
            Toast.makeText(this, "Already granted call phone permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onAnswerPhoneCallsClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestAnswerPhoneCalls()) {
            Toast.makeText(this, "Already granted answer phone calls permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onAddVoiceMailClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestAddVoiceMail()) {
            Toast.makeText(this, "Already granted add voice mail permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onUseSipClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestUseSip()) {
            Toast.makeText(this, "Already granted use sip permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_PHONE_STATE:
                ToastUtils.showToast(this, "Read Phone State Granted");
                break;
            case DuckResultCode.RESULT_CODE_READ_PHONE_NUMBERS:
                ToastUtils.showToast(this, "Read Phone Numbers Granted");
                break;
            case DuckResultCode.RESULT_CODE_CALL_PHONE:
                ToastUtils.showToast(this, "Call Phone Granted");
                break;
            case DuckResultCode.RESULT_CODE_ANSWER_PHONE_CALLS:
                ToastUtils.showToast(this, "Answer Phone Calls Granted");
                break;
            case DuckResultCode.RESULT_CODE_ADD_VOICE_MAIL:
                ToastUtils.showToast(this, "Add Voice Mail Granted");
                break;
            case DuckResultCode.RESULT_CODE_USE_SIP:
                ToastUtils.showToast(this, "Use sip Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_PHONE_STATE:
                ToastUtils.showToast(this, "Read Phone State Denied");
                break;
            case DuckResultCode.RESULT_CODE_READ_PHONE_NUMBERS:
                ToastUtils.showToast(this, "Read Phone Numbers Denied");
                break;
            case DuckResultCode.RESULT_CODE_CALL_PHONE:
                ToastUtils.showToast(this, "Call Phone Denied");
                break;
            case DuckResultCode.RESULT_CODE_ANSWER_PHONE_CALLS:
                ToastUtils.showToast(this, "Answer Phone Calls Denied");
                break;
            case DuckResultCode.RESULT_CODE_ADD_VOICE_MAIL:
                ToastUtils.showToast(this, "Add Voice Mail Denied");
                break;
            case DuckResultCode.RESULT_CODE_USE_SIP:
                ToastUtils.showToast(this, "Use sip Denied");
                break;
        }
    }
}
