package com.nasduck.duckpermission.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.code.DuckResultCode;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_CALENDAR:
                if (DuckPermission.getInstance(this).result(permissions, grantResults)) {
                    ToastUtils.showToast(this, "Granted");
                } else {
                    ToastUtils.showToast(this, "Denied");
                }
                break;
            case DuckResultCode.RESULT_CODE_WRITE_CALENDAR:
                if (DuckPermission.getInstance(this).result(permissions, grantResults)) {
                    ToastUtils.showToast(this, "Granted");
                } else {
                    ToastUtils.showToast(this, "Denied");
                }
                break;
        }
    }

    public void onReadCalendarClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestReadCalendar()) {
            Toast.makeText(this, "Already granted read calendar permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onWriteCalendarClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestWriteCalendar()) {
            Toast.makeText(this, "Already granted write calendar permission", Toast.LENGTH_SHORT).show();
        }
    }
}
