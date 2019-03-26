package com.nasduck.duckpermission.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.code.DuckResultCode;

public class MicrophoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microphone);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_RECORD_AUDIO:
                if (DuckPermission.getInstance(this).onResult(permissions, grantResults)) {
                    ToastUtils.showToast(this, "Granted");
                } else {
                    ToastUtils.showToast(this, "Denied");
                }
                break;
        }
    }

    public void onAudioRecordClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestAudioRecord()) {
            Toast.makeText(this, "Already granted audio record permission", Toast.LENGTH_SHORT).show();
        }
    }
}
