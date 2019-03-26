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

public class StorageActivity extends BaseActivity implements
        OnPermissionResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
    }

    public void onReadExternalStorageClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReadExternalStorage()) {
            Toast.makeText(this, "Already granted read external storage permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onWriteExternalStorageClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestWriteExternalStorage()) {
            Toast.makeText(this, "Already granted write external storage permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_EXTERNAL_STORAGE:
                ToastUtils.showToast(this, "Read External Storage Granted");
                break;
            case DuckResultCode.RESULT_CODE_WRITE_EXTERNAL_STORAGE:
                ToastUtils.showToast(this, "Write External Storage Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_EXTERNAL_STORAGE:
                ToastUtils.showToast(this, "Read External Storage Denied");
                break;
            case DuckResultCode.RESULT_CODE_WRITE_EXTERNAL_STORAGE:
                ToastUtils.showToast(this, "Write External Storage Denied");
                break;
        }
    }
}
