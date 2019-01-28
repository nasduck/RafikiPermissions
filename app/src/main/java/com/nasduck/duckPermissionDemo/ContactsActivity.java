package com.nasduck.duckPermissionDemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;

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
            case DuckPermission.RESULT_CODE_READ_CONTACTS:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_WRITE_CONTACTS:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case DuckPermission.RESULT_CODE_GET_ACCOUNTS:
                if (DuckPermission.getInstance(this).result(grantResults)) {
                    Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
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

