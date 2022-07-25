package com.ebin.sureksha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ebin.sureksha.helpers.PageNavigationHelper;
import com.ebin.sureksha.helpers.UserProfileHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(UserProfileHelper.isLoggedIn(this)){
            //Stay here
        }
        else{
            PageNavigationHelper.navigateToPage(this, PageNavigationHelper.REGISTER_PAGE, new Bundle());
        }
    }


}