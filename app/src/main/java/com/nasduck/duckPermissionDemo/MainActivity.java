package com.nasduck.duckPermissionDemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;

public class MainActivity extends AppCompatActivity {

    private final static int AUDIO_RECORD_CODE = 1;
    private final static int ACCESS_FINE_LOCATION_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case AUDIO_RECORD_CODE:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case ACCESS_FINE_LOCATION_CODE:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
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

    public void onAccessFineLocationClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestAccessFineLocation()) {
            Toast.makeText(this, "Already granted access fine location permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onXXXXClick(View view) {
        if (DuckPermission.getInstance(this)
                .addAudioRecord()
                .setResultCode(AUDIO_RECORD_CODE)
                .request()) {
            Toast.makeText(this, "Already granted audio record permission", Toast.LENGTH_SHORT).show();
        }
    }
}
