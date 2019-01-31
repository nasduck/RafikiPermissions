package com.nasduck.duckpermission.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.result.code.DuckResultCode;

public class StorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_EXTERNAL_STORAGE:
                if (DuckPermission.getInstance(this).result(permissions, grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckResultCode.RESULT_CODE_WRITE_EXTERNAL_STORAGE:
                if (DuckPermission.getInstance(this).result(permissions, grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onReadExternalStorageClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestReadExternalStorage()) {
            Toast.makeText(this, "Already granted read external storage permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onWriteExternalStorageClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestWriteExternalStorage()) {
            Toast.makeText(this, "Already granted write external storage permission", Toast.LENGTH_SHORT).show();
        }
    }
}
