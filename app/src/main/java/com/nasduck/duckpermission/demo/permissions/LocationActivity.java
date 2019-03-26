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

public class LocationActivity extends BaseActivity implements
        OnPermissionResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void onAccessFineLocationClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestAccessFineLocation()) {
            Toast.makeText(this, "Already granted access fine location permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onAccessCoarseLocationClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestAccessCoarseLocation()) {
            Toast.makeText(this, "Already granted access coarse location permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_ACCESS_FINE_LOCATION:
                ToastUtils.showToast(this, "Access Fine Location Granted");
                break;
            case DuckResultCode.RESULT_ACCESS_COARSE_LOCATION:
                ToastUtils.showToast(this, "Access Coarse Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_ACCESS_FINE_LOCATION:
                ToastUtils.showToast(this, "Access Fine Location Denied");
                break;
            case DuckResultCode.RESULT_ACCESS_COARSE_LOCATION:
                ToastUtils.showToast(this, "Access Coarse Denied");
                break;
        }
    }
}
