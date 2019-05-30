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

public class MicrophoneActivity extends BaseActivity implements
        OnPermissionResultListener {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microphone);

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

    public void onAudioRecordClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestAudioRecord()) {
            Toast.makeText(this, "Already granted audio record permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case RafikiResultCode.RESULT_CODE_RECORD_AUDIO:
                ToastUtils.showToast(this, "Record Audio Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case RafikiResultCode.RESULT_CODE_RECORD_AUDIO:
                ToastUtils.showToast(this, "Record Audio  Denied");
                break;
        }
    }
}
