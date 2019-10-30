package com.example.jiyin.common.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jiyin.home.Activity.HomeActivity;
import com.example.jiyin.R;

public class TransparentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);
        startActivity(new Intent(TransparentActivity.this, HomeActivity.class));
        finish();
    }
}
