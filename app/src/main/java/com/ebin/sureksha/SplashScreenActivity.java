package com.ebin.sureksha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.ebin.sureksha.helpers.PageNavigationHelper;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                PageNavigationHelper.navigateToPage(SplashScreenActivity.this, PageNavigationHelper.HOME_PAGE, new Bundle());
            }
        };
        handler.postDelayed(runnable, 3000);
    }
}