package com.nasduck.duckpermission.demo.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.nasduck.duckpermission.RafikiPermissions;

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        RafikiPermissions.getInstance(this)
                .onResult(requestCode, permissions, grantResults);
    }

    /**
     * Jump to APP settings
     */
    protected void onAppSettingClick() {
        Intent i = new Intent();
        if (Build.VERSION.SDK_INT >= 9) {
            i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            i.setData(Uri.fromParts("package", this.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            i.setAction(Intent.ACTION_VIEW);
            i.setClassName("com.android.settings","com.android.settings.InstalledAppDetails");
            i.putExtra("com.android.settings.ApplicationPkgName", this.getPackageName());
        }
        this.startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
