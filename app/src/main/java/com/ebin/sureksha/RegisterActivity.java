package com.ebin.sureksha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ebin.sureksha.helpers.PageNavigationHelper;

public class RegisterActivity extends AppCompatActivity {

    public static final String BUNDLE_NAME = "bundle";

    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tvLogin = findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageNavigationHelper.navigateToPage(RegisterActivity.this, PageNavigationHelper.LOGIN_PAGE, new Bundle());
            }
        });
    }
}