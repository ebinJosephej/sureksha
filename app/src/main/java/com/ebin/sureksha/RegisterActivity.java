package com.ebin.sureksha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ebin.sureksha.helpers.PageNavigationHelper;
import com.ebin.sureksha.helpers.UserProfileHelper;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    public static final String BUNDLE_NAME = "bundle";

    private TextView tvLogin;
    private Button btnRegister;
    private EditText etEmail, etName, etPassword, etConfirmPassword, etLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        initListeners();

    }

    private void initListeners() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageNavigationHelper.navigateToPage(RegisterActivity.this, PageNavigationHelper.LOGIN_PAGE, new Bundle());
                finish();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    ArrayList<UserModel> userModels = UserProfileHelper.getUserAccountsList(RegisterActivity.this);
                    if(userModels != null) {
                        for (UserModel userModel : userModels) {
                            if (userModel.getEmail().equalsIgnoreCase(etEmail.getText().toString())) {
                                Toast.makeText(RegisterActivity.this, RegisterActivity.this.getString(R.string.error_email_exists), Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    }
                    UserModel userModel = new UserModel();
                    userModel.setEmail(etEmail.getText().toString());
                    userModel.setName(etName.getText().toString());
                    userModel.setLocation(etLocation.getText().toString());
                    userModel.setPassword(etPassword.getText().toString());
                    UserProfileHelper.registerUser(RegisterActivity.this, userModel);
                    UserProfileHelper.loginUser(RegisterActivity.this, userModel);
                    PageNavigationHelper.navigateToPage(RegisterActivity.this, PageNavigationHelper.LOGIN_PAGE, new Bundle());
                }
            }
        });
    }

    private void initViews() {
        tvLogin = findViewById(R.id.tv_login);
        etEmail = findViewById(R.id.et_email);
        etName = findViewById(R.id.et_name);
        etLocation = findViewById(R.id.et_address);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_password_confirm);
        btnRegister = findViewById(R.id.btn_register);
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
        if(!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())){
            valid = false;
            etConfirmPassword.setError(getString(R.string.error_password_mismatch));
        }
        return valid;
    }
}