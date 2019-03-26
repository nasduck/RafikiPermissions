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

public class SensorsActivity extends BaseActivity implements
        OnPermissionResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
    }

    public void onBodySensorsClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestBodySensors()) {
            Toast.makeText(this, "Already granted body sensors permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_BODY_SENSORS:
                ToastUtils.showToast(this, "Body Sensors Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_BODY_SENSORS:
                ToastUtils.showToast(this, "Body Sensors Denied");
                break;
        }
    }
}
