package com.nasduck.duckPermissionDemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;

public class MainActivity extends AppCompatActivity {

    private final static int AUDIO_RECORD_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onCalendarGroupClick(View view) {
        Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
        startActivity(intent);
    }

    public void onCallLogGroupClick(View view) {
        Intent intent = new Intent(MainActivity.this, CallLogActivity.class);
        startActivity(intent);
    }

    public void onCameraGroupClick(View view) {
        Intent intent = new Intent(MainActivity.this, CameraActivity.class);
        startActivity(intent);
    }

    public void onContactsGroupClick(View view) {
        Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
        startActivity(intent);
    }

    public void onLocationGroupClick(View view) {
        Intent intent = new Intent(MainActivity.this, LocationActivity.class);
        startActivity(intent);
    }

    public void onMicrophoneGroupClick(View view) {
        Intent intent = new Intent(MainActivity.this, MicrophoneActivity.class);
        startActivity(intent);
    }

    public void onPhoneGroupClick(View view) {
        Intent intent = new Intent(MainActivity.this, PhoneActivity.class);
        startActivity(intent);
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
