package com.nasduck.duckpermission.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nasduck.duckpermission.demo.strategy.StrategyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * To Different Strategy Activity
     */
    public void onStrategyClick(View view) {
        Intent intent = new Intent(this, StrategyActivity.class);
        startActivity(intent);
    }

    /**
     * To Permission List Activity
     */
    public void onPermissionListClick(View view) {
        Intent intent = new Intent(this, PermissionListActivity.class);
        startActivity(intent);
    }
}
