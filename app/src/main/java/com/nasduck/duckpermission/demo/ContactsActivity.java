package com.nasduck.duckpermission.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.code.DuckResultCode;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_CONTACTS:
                if (DuckPermission.getInstance(this).result(permissions, grantResults)) {
                    ToastUtils.showToast(this, "Granted");
                } else {
                    ToastUtils.showToast(this, "Denied");
                }
                break;
            case DuckResultCode.RESULT_CODE_WRITE_CONTACTS:
                if (DuckPermission.getInstance(this).result(permissions, grantResults)) {
                    ToastUtils.showToast(this, "Granted");
                } else {
                    ToastUtils.showToast(this, "Denied");
                }
                break;
            case DuckResultCode.RESULT_CODE_GET_ACCOUNTS:
                if (DuckPermission.getInstance(this).result(permissions, grantResults)) {
                    ToastUtils.showToast(this, "Granted");
                } else {
                    ToastUtils.showToast(this, "Denied");
                }
                break;
        }
    }

    public void onReadContactsClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestReadContacts()) {
            Toast.makeText(this, "Already granted read contacts permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onWriteContactsClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestWriteContacts()) {
            Toast.makeText(this, "Already granted write contacts permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onGetAccountsClick(View view) {
        if (DuckPermission.getInstance(this)
                .requestGetAccounts()) {
            Toast.makeText(this, "Already granted get accounts permission", Toast.LENGTH_SHORT).show();
        }
    }
}

