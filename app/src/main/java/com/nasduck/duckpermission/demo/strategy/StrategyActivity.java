package com.nasduck.duckpermission.demo.strategy;

import android.os.Bundle;
import android.view.View;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.demo.R;
import com.nasduck.duckpermission.demo.base.BaseActivity;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultCustomStrategy;
import com.nasduck.duckpermission.result.listener.OnPermissionResultListener;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultGuideStrategy;

public class StrategyActivity extends BaseActivity implements
        OnPermissionResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
    }

    /**
     * Strategy By Default. Just do nothing if user denied the permission request
     */
    public void onStrategyDoNothingClick(View view) {
        if (DuckPermission.getInstance(this)
                //.setResultStrategy(new PermissionResultNothingStrategy())
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    public void onStrategyGuideClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultGuideStrategy())
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    public void onStrategyCustomClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy())
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    //* Custom Strategy OnPermissionResultListener ***********************************************//

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        ToastUtils.showToast(this, "Oh Yeah! Permission granted!");
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        ToastUtils.showToast(this, "Oh lala! Permission Denied!");
    }
}
