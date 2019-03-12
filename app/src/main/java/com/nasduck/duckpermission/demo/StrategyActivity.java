package com.nasduck.duckpermission.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.strategy.PermissionResultCustomStrategy;
import com.nasduck.duckpermission.result.strategy.PermissionResultGuideStrategy;
import com.nasduck.duckpermission.result.strategy.PermissionResultNothingStrategy;
import com.nasduck.duckpermission.result.code.DuckResultCode;

public class StrategyActivity extends AppCompatActivity implements
        PermissionResultCustomStrategy.PermissionResultCustomStrategyListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == DuckResultCode.RESULT_CODE_CAMERA) {
            if (DuckPermission.getInstance(this).result(permissions, grantResults)) {
                ToastUtils.showToast(this, "Granted");
            } else {
                ToastUtils.showToast(this, "Denied");
            }
        }
    }

    public void onStrategyDoNothingClick(View view) {
        if (DuckPermission.getInstance(this)
                .setRequestResult(new PermissionResultNothingStrategy())
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    public void onStrategyGuideClick(View view) {
        if (DuckPermission.getInstance(this)
                .setRequestResult(new PermissionResultGuideStrategy())
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    public void onStrategyCustomClick(View view) {
        PermissionResultCustomStrategy strategy = new PermissionResultCustomStrategy();
        strategy.setListener(this);

        if (DuckPermission.getInstance(this)
                .setRequestResult(strategy)
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    //* Custom Strategy **************************************************************************//

    @Override
    public void onPermissionsResultGrant() {
        ToastUtils.showToast(this, "Oh Yeah! Permissions Grant!!");
    }

    @Override
    public void onPermissionsResultDenied() {
        ToastUtils.showToast(this, "Nooooo! Permissions Denied!");
    }
}
