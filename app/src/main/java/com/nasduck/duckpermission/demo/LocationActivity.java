package com.nasduck.duckpermission.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.result.code.DuckResultCode;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_ACCESS_FINE_LOCATION:
                if (DuckPermission.getInstance(this).result(permissions, grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckResultCode.RESULT_ACCESS_COARSE_LOCATION:
                if (DuckPermission.getInstance(this).result(permissions, grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onAccessFineLocationClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestAccessFineLocation()) {
            Toast.makeText(this, "Already granted access fine location permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onAccessCoarseLocationClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestAccessCoarseLocation()) {
            Toast.makeText(this, "Already granted access coarse location permission", Toast.LENGTH_SHORT).show();
        }
    }
}
