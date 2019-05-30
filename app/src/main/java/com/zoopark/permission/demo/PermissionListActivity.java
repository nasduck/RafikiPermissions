package com.nasduck.rafikipermissions.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.nasduck.rafikipermissions.demo.permissions.CalendarActivity;
import com.nasduck.rafikipermissions.demo.permissions.CameraActivity;
import com.nasduck.rafikipermissions.demo.permissions.ContactsActivity;
import com.nasduck.rafikipermissions.demo.permissions.LocationActivity;
import com.nasduck.rafikipermissions.demo.permissions.MicrophoneActivity;
import com.nasduck.rafikipermissions.demo.permissions.PhoneActivity;
import com.nasduck.rafikipermissions.demo.permissions.SMSActivity;
import com.nasduck.rafikipermissions.demo.permissions.SensorsActivity;
import com.nasduck.rafikipermissions.demo.permissions.StorageActivity;

public class PermissionListActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_list);

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCalendarGroupClick(View view) {
        Intent intent = new Intent(this, CalendarActivity.class);
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
