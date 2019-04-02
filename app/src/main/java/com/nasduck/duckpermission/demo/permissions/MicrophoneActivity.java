package com.nasduck.duckpermission.demo.permissions;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.RafikiPermissions;
import com.nasduck.duckpermission.demo.R;
import com.nasduck.duckpermission.demo.base.BaseActivity;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.code.RafikiResultCode;
import com.nasduck.duckpermission.result.listener.OnPermissionResultListener;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultCustomStrategy;

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
