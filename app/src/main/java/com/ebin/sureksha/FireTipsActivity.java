package com.ebin.sureksha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ebin.sureksha.helpers.FragmentHelper;

public class FireTipsActivity extends AppCompatActivity {

    public static final String BUNDLE_NAME = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_tips);
        new FragmentHelper(FireTipsActivity.this).initFragment(FireTipsFragment.newInstance(), getSupportFragmentManager());
    }
}