package com.nasduck.duckpermission.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.result.RequestPermissionsResultGuide;
import com.nasduck.duckpermission.result.RequestPermissionsResultNothing;
import com.nasduck.duckpermission.result.code.DuckResultCode;

public class StrategyActivity extends AppCompatActivity {

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
                Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onStrategyDoNothingClick(View view) {
        if (DuckPermission.getInstance(this)
                .setRequestResult(new RequestPermissionsResultNothing())
                .requestCamera()) {
            Toast.makeText(this, "Already granted camera permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onStrategyGuideClick(View view) {
        if (DuckPermission.getInstance(this)
                .setRequestResult(new RequestPermissionsResultGuide())
                .requestCamera()) {
            Toast.makeText(this, "Already granted camera permission", Toast.LENGTH_SHORT).show();
        }
    }
}
