package com.nasduck.duckpermission.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;

public class PhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case DuckPermission.RESULT_CODE_READ_PHONE_STATE:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_READ_PHONE_NUMBERS:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_CALL_PHONE:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_ANSWER_PHONE_CALLS:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_ADD_VOICE_MAIL:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_USE_SIP:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onReadPhoneStateClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestReadPhoneState()) {
            Toast.makeText(this, "Already granted read phone state permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReadPhoneNumbersClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestReadPhoneNumbers()) {
            Toast.makeText(this, "Already granted read phone numbers permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onCallPhoneClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestCallPhone()) {
            Toast.makeText(this, "Already granted call phone permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onAnswerPhoneCallsClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestAnswerPhoneCalls()) {
            Toast.makeText(this, "Already granted answer phone calls permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onAddVoiceMailClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestAddVoiceMail()) {
            Toast.makeText(this, "Already granted add voice mail permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onUseSipClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestUseSip()) {
            Toast.makeText(this, "Already granted use sip permission", Toast.LENGTH_SHORT).show();
        }
    }
}
