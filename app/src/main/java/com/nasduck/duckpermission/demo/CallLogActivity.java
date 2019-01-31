package com.nasduck.duckpermission.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.result.code.PermissionCode;

public class CallLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_log);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermissionCode.RESULT_CODE_READ_CALL_LOG:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case PermissionCode.RESULT_CODE_WRITE_CALL_LOG:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case PermissionCode.RESULT_CODE_PROCESS_OUTGOING_CALLS:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onReadCallLogClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestReadCallLog()) {
            Toast.makeText(this, "Already granted read call log permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onWriteCallLogClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestWriteCallLog()) {
            Toast.makeText(this, "Already granted write call log permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onProcessOutgoingCallsClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestProcessOutgoingCalls()) {
            Toast.makeText(this, "Already granted process outgoing calls permission", Toast.LENGTH_SHORT).show();
        }
    }
}
