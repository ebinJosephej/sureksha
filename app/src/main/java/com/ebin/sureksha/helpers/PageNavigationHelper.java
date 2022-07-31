package com.ebin.sureksha.helpers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ebin.sureksha.FireTipsActivity;
import com.ebin.sureksha.LoginActivity;
import com.ebin.sureksha.MainActivity;
import com.ebin.sureksha.RegisterActivity;

public class PageNavigationHelper {

    //Public strings
    public static final String LOGIN_PAGE = "login";
    public static final String REGISTER_PAGE = "register";
    public static final String HOME_PAGE = "home";
    public static final String FIRE_TIPS = "tips";

    public static PageNavigationHelper mPageNavigationHelper;

    private Context context;

    public static PageNavigationHelper createInstance(){
        if(mPageNavigationHelper == null){
            mPageNavigationHelper = new PageNavigationHelper();
        }
        return mPageNavigationHelper;
    }

    public static void navigateToPage(Context context, String page, Bundle bundle){
        PageNavigationHelper pageNavigationHelper = PageNavigationHelper.createInstance();
        pageNavigationHelper.context = context;
        switch (page){
            case LOGIN_PAGE:
                pageNavigationHelper.navigateToLogin(bundle);
                break;
            case REGISTER_PAGE:
                pageNavigationHelper.navigateToRegister(bundle);
                break;
            case HOME_PAGE:
                pageNavigationHelper.navigateToHome(bundle);
                break;
            case FIRE_TIPS:
                pageNavigationHelper.navigateToTips(bundle);
                break;
        }
    }

    private void navigateToLogin(Bundle bundle) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(LoginActivity.BUNDLE_NAME, bundle);
        context.startActivity(intent);
    }

    private void navigateToRegister(Bundle bundle) {
        Intent intent = new Intent(context, RegisterActivity.class);
        intent.putExtra(RegisterActivity.BUNDLE_NAME, bundle);
        context.startActivity(intent);
    }

    private void navigateToTips(Bundle bundle){
        Intent intent = new Intent(context, FireTipsActivity.class);
        intent.putExtra(FireTipsActivity.BUNDLE_NAME, bundle);
        context.startActivity(intent);
    }

    private void navigateToHome(Bundle bundle){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(FireTipsActivity.BUNDLE_NAME, bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
