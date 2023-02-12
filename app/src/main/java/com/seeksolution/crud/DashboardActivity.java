package com.seeksolution.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}