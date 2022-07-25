package com.ebin.sureksha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ebin.sureksha.helpers.PageNavigationHelper;

public class LoginActivity extends AppCompatActivity {

    public static final String BUNDLE_NAME = "bundle";

    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvRegister = findViewById(R.id.tv_register);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageNavigationHelper.navigateToPage(LoginActivity.this, PageNavigationHelper.REGISTER_PAGE, new Bundle());
            }
        });
    }
}