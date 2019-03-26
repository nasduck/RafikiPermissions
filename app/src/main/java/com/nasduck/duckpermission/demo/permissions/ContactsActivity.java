package com.nasduck.duckpermission.demo.permissions;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.demo.R;
import com.nasduck.duckpermission.demo.base.BaseActivity;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.code.DuckResultCode;
import com.nasduck.duckpermission.result.listener.OnPermissionResultListener;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultCustomStrategy;

public class ContactsActivity extends BaseActivity implements
        OnPermissionResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }

    public void onReadContactsClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReadContacts()) {
            Toast.makeText(this, "Already granted read contacts permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onWriteContactsClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestWriteContacts()) {
            Toast.makeText(this, "Already granted write contacts permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onGetAccountsClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestGetAccounts()) {
            Toast.makeText(this, "Already granted get accounts permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_CONTACTS:
                ToastUtils.showToast(this, "Read Contacts Granted");
                break;
            case DuckResultCode.RESULT_CODE_WRITE_CONTACTS:
                ToastUtils.showToast(this, "Write Contacts Granted");
                break;
            case DuckResultCode.RESULT_CODE_GET_ACCOUNTS:
                ToastUtils.showToast(this, "Get Accounts Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_CONTACTS:
                ToastUtils.showToast(this, "Read Contacts Denied");
                break;
            case DuckResultCode.RESULT_CODE_WRITE_CONTACTS:
                ToastUtils.showToast(this, "Write Contacts Denied");
                break;
            case DuckResultCode.RESULT_CODE_GET_ACCOUNTS:
                ToastUtils.showToast(this, "Get Accounts Denied");
                break;
        }
    }
}

