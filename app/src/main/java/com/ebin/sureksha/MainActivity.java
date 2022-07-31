package com.ebin.sureksha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ebin.sureksha.helpers.PageNavigationHelper;
import com.ebin.sureksha.helpers.UserProfileHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnReportFire, btnFireTips, btnProfileEdit;
    private ImageView ivLogout;
    private TextView tvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(UserProfileHelper.isLoggedIn(this)){
            //Stay here
        }
        else{
            PageNavigationHelper.navigateToPage(this, PageNavigationHelper.LOGIN_PAGE, new Bundle());
        }

        initView();
        initListeners();
    }

    private void initView(){
        btnFireTips = findViewById(R.id.btn_fire_tips);
        btnReportFire = findViewById(R.id.btn_report_fire);
        btnProfileEdit = findViewById(R.id.btn_update_profile);
        ivLogout = findViewById(R.id.img_logout);
        tvUserName = findViewById(R.id.tv_username);

        UserModel userModel = UserProfileHelper.getLoggedInUser(this);
        if(userModel != null){
            tvUserName.setText("Hello ".concat(userModel.getName()));
        }
    }

    private void initListeners(){
        btnReportFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnFireTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageNavigationHelper.navigateToPage(MainActivity.this, PageNavigationHelper.FIRE_TIPS, new Bundle());
            }
        });

        btnProfileEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ivLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfileHelper.logoutUser(MainActivity.this);
            }
        });
    }


}