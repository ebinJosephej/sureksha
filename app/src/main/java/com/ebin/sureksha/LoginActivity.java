package com.ebin.sureksha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ebin.sureksha.helpers.PageNavigationHelper;
import com.ebin.sureksha.helpers.UserProfileHelper;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    public static final String BUNDLE_NAME = "bundle";

    private TextView tvRegister;
    private EditText etPassword, etEmail;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initListeners();
    }

    private void initViews(){
        tvRegister = findViewById(R.id.tv_register);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    private void initListeners(){
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageNavigationHelper.navigateToPage(LoginActivity.this, PageNavigationHelper.REGISTER_PAGE, new Bundle());
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    ArrayList<UserModel> userModels = UserProfileHelper.getUserAccountsList(LoginActivity.this);
                    if(userModels != null) {
                        for (UserModel userModel : userModels) {
                            if (userModel.getEmail().equalsIgnoreCase(etEmail.getText().toString().toLowerCase())) {
                                if (UserProfileHelper.loginUser(LoginActivity.this, userModel)) {
                                    PageNavigationHelper.navigateToPage(LoginActivity.this, PageNavigationHelper.HOME_PAGE, new Bundle());
                                    return;
                                } else {
                                    Toast.makeText(LoginActivity.this, LoginActivity.this.getString(R.string.error_unexpected), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        Toast.makeText(LoginActivity.this, LoginActivity.this.getString(R.string.error_incorrect_credentials), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this, LoginActivity.this.getString(R.string.error_incorrect_credentials), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean validate(){
        boolean valid = true;
        if(etEmail.getText().toString().isEmpty()){
            valid = false;
            etEmail.setError(getString(R.string.error_missing_values));
        }else if(!etEmail.getText().toString().contains("@")){
            valid = false;
            etEmail.setError(getString(R.string.error_invalid_email));
        }
        if(etPassword.getText().toString().isEmpty()){
            valid = false;
            etPassword.setError(getString(R.string.error_missing_values));
        }
        return valid;
    }
}