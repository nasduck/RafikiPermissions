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

public class CallLogActivity extends BaseActivity implements
        OnPermissionResultListener {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_log);

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

    public void onReadCallLogClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReadCallLog()) {
            Toast.makeText(this, "Already granted read call log permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onWriteCallLogClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestWriteCallLog()) {
            Toast.makeText(this, "Already granted write call log permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onProcessOutgoingCallsClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestProcessOutgoingCalls()) {
            Toast.makeText(this, "Already granted process outgoing calls permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_CALL_LOG:
                ToastUtils.showToast(this, "Read Call Log Granted");
                break;
            case DuckResultCode.RESULT_CODE_WRITE_CALL_LOG:
                ToastUtils.showToast(this, "Write Call Log Granted");
                break;
            case DuckResultCode.RESULT_CODE_PROCESS_OUTGOING_CALLS:
                ToastUtils.showToast(this, "Process Outgoing Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_CALL_LOG:
                ToastUtils.showToast(this, "Read Call Log Denied");
                break;
            case DuckResultCode.RESULT_CODE_WRITE_CALL_LOG:
                ToastUtils.showToast(this, "Write Call Log Denied");
                break;
            case DuckResultCode.RESULT_CODE_PROCESS_OUTGOING_CALLS:
                ToastUtils.showToast(this, "Process Outgoing Denied");
                break;
        }
    }
}