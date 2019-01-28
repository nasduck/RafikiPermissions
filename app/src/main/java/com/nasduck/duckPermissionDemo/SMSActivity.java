package com.nasduck.duckPermissionDemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;

public class SMSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case DuckPermission.RESULT_CODE_SEND_SMS:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_RECEIVE_SMS:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_READ_SMS:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_RECEIVE_WAP_PUSH:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_RECEIVE_MMS:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onSendSMSClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestSendSMS()) {
            Toast.makeText(this, "Already granted send SMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReceiveSMSClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestReceiveSMS()) {
            Toast.makeText(this, "Already granted receive SMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReadSMSClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestReadSMS()) {
            Toast.makeText(this, "Already granted read SMS permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReceiveWapPushClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestReceiveWapPush()) {
            Toast.makeText(this, "Already granted receive wap push permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReceiveMMSClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestReceiveMMS()) {
            Toast.makeText(this, "Already granted receive MMS permission", Toast.LENGTH_SHORT).show();
        }
    }
}
