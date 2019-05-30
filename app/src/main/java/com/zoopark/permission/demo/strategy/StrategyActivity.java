package com.nasduck.rafikipermissions.demo.strategy;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zoopark.permission.RafikiPermissions;
import com.nasduck.rafikipermissions.demo.R;
import com.nasduck.rafikipermissions.demo.base.BaseActivity;
import com.nasduck.rafikipermissions.demo.utils.ToastUtils;
import com.zoopark.permission.result.strategy.impl.PermissionResultCustomStrategy;
import com.zoopark.permission.result.listener.OnPermissionResultListener;
import com.zoopark.permission.result.strategy.impl.PermissionResultGuideStrategy;
import com.zoopark.permission.result.strategy.impl.PermissionResultNothingStrategy;

public class StrategyActivity extends BaseActivity implements
        OnPermissionResultListener {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);

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

    /**
     * Strategy By Default. Just do nothing if user denied the permission request
     */
    public void onStrategyDoNothingClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultNothingStrategy())
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    public void onStrategyGuideClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultGuideStrategy())
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    public void onStrategyCustomClick(View view) {
        if (RafikiPermissions.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
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
