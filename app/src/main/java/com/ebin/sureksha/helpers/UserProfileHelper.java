package com.ebin.sureksha.helpers;

import android.content.Context;
import android.content.SharedPreferences;

public class UserProfileHelper {
    private static final String SHARED_PREFERENCE_NAME = "sureksha";
    private static final int SHARED_PREFERENCE_MODE = 0;

    private static final String KEY_LOGGED_IN = "logged_in";

    // Private constructor to restrict instantiation of class
    private UserProfileHelper() {
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCE_NAME, SHARED_PREFERENCE_MODE);
    }

    public static boolean isLoggedIn(Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getBoolean(KEY_LOGGED_IN, false);
    }
}
