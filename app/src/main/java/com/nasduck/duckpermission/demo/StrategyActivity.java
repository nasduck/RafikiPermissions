package com.nasduck.duckpermission.demo;

import android.os.Bundle;
import android.view.View;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultCustomStrategy;
import com.nasduck.duckpermission.result.listener.OnPermissionResultListener;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultGuideStrategy;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultNothingStrategy;

public class StrategyActivity extends BaseActivity implements OnPermissionResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
    }

    public void onStrategyDoNothingClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultNothingStrategy())
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    public void onStrategyGuideClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultGuideStrategy(this))
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    public void onStrategyCustomClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestCamera()) {
            ToastUtils.showToast(this, "Already granted camera permission");
        }
    }

    public void onMultipleClick(View view) {
        if (DuckPermission.getInstance(this)
                .addCamera()
                .addAudioRecord()
                .addWriteExternalStorage()
                .setResultCode(123)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .request()) {
            ToastUtils.showToast(this, "Already granted permissions");
        }
    }

    //* Custom Strategy **************************************************************************//

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        if (requestCode == 123) {
            ToastUtils.showToast(this, "Oh Yeah! Permissions Grant!!");
        } else {
            ToastUtils.showToast(this, "Camera permission granted!");
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        if (requestCode == 123) {
            ToastUtils.showToast(this, "Nooooo! Permissions Denied!");
        }else {
            ToastUtils.showToast(this, "Camera permission Denied!");
        }
    }
}
