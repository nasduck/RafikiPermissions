package com.nasduck.duckPermissionDemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case DuckPermission.RESULT_CODE_CAMERA:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onCameraClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestCamera()) {
            Toast.makeText(this, "Already granted camera permission", Toast.LENGTH_SHORT).show();
        }
    }
}
