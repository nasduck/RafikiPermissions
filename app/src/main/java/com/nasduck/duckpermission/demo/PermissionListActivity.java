package com.nasduck.duckpermission.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nasduck.duckpermission.demo.permissions.CalendarActivity;
import com.nasduck.duckpermission.demo.permissions.CallLogActivity;
import com.nasduck.duckpermission.demo.permissions.CameraActivity;
import com.nasduck.duckpermission.demo.permissions.ContactsActivity;
import com.nasduck.duckpermission.demo.permissions.LocationActivity;
import com.nasduck.duckpermission.demo.permissions.MicrophoneActivity;
import com.nasduck.duckpermission.demo.permissions.PhoneActivity;
import com.nasduck.duckpermission.demo.permissions.SMSActivity;
import com.nasduck.duckpermission.demo.permissions.SensorsActivity;
import com.nasduck.duckpermission.demo.permissions.StorageActivity;

public class PermissionListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_list);
    }

    public void onCalendarGroupClick(View view) {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void onCallLogGroupClick(View view) {
        Intent intent = new Intent(this, CallLogActivity.class);
        startActivity(intent);
    }

    public void onCameraGroupClick(View view) {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    public void onContactsGroupClick(View view) {
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    public void onLocationGroupClick(View view) {
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }

    public void onMicrophoneGroupClick(View view) {
        Intent intent = new Intent(this, MicrophoneActivity.class);
        startActivity(intent);
    }

    public void onPhoneGroupClick(View view) {
        Intent intent = new Intent(this, PhoneActivity.class);
        startActivity(intent);
    }

    public void onSensorsGroupClick(View view) {
        Intent intent = new Intent(this, SensorsActivity.class);
        startActivity(intent);
    }

    public void onSMSGroupClick(View view) {
        Intent intent = new Intent(this, SMSActivity.class);
        startActivity(intent);
    }

    public void onStorageGroupClick(View view) {
        Intent intent = new Intent(this, StorageActivity.class);
        startActivity(intent);
    }
}
