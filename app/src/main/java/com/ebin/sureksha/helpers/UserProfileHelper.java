package com.ebin.sureksha.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.ebin.sureksha.LoginActivity;
import com.ebin.sureksha.UserModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserProfileHelper {
    private static final String SHARED_PREFERENCE_NAME = "sureksha";
    private static final int SHARED_PREFERENCE_MODE = 0;

    private static final String KEY_LOGGED_IN = "logged_in";
    private static final String KEY_USER_ACCOUNTS = "user_accounts";
    private static final String KEY_LOGGED_IN_USER = "logged_in_user";

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

    public static String getUserAccounts(Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(KEY_USER_ACCOUNTS, "");
    }

    public static void setUserAccounts(Context context, String userAccounts){
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_USER_ACCOUNTS, userAccounts).apply();
    }

    public static void logoutUser(Context context){
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(KEY_LOGGED_IN, false);
        editor.putString(KEY_LOGGED_IN_USER, "");
        editor.apply();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    public static boolean loginUser(Context context, UserModel userModel){
        try {
            JSONObject jsonObject = convertUserModelJSON(userModel);
            final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
            editor.putString(KEY_LOGGED_IN_USER, jsonObject.toString()).apply();
            editor.putBoolean(KEY_LOGGED_IN, true).apply();
        }catch (JSONException ex){
            return false;
        }
        return true;
    }

    public static String getLoginUser(Context context){
        return getSharedPreferences(context).getString(KEY_LOGGED_IN_USER, "");
    }

    public static boolean registerUser(Context context, UserModel userModel){
        ArrayList<UserModel> userModels = getUserAccountsList(context);
        if(userModels == null){
            userModels = new ArrayList<>();
        }
        userModels.add(userModel);
        try {
            JSONArray jsonArray = convertUserModelsJSON(userModels);
            setUserAccounts(context, jsonArray.toString());
        }catch (JSONException ex){
            return false;
        }
        return true;
    }

    public static UserModel getLoggedInUser(Context context){
        String loggedInUser = getLoginUser(context);
        if(loggedInUser != null && !loggedInUser.isEmpty()){
            try {
                return buildUserModel(new JSONObject(loggedInUser));
            } catch (JSONException e) {

            }
        }
        return null;
    }

    public static JSONArray convertUserModelsJSON(ArrayList<UserModel> userModels) throws JSONException{
        JSONArray jsonArray = new JSONArray();
        for(UserModel userModel : userModels){
            jsonArray.put(convertUserModelJSON(userModel));
        }
        return jsonArray;
    }

    public static JSONObject convertUserModelJSON(UserModel userModel) throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(UserModel.JSON_EMAIL, userModel.getEmail());
        jsonObject.put(UserModel.JSON_NAME, userModel.getName());
        jsonObject.put(UserModel.JSON_LOCATION, userModel.getLocation());
        jsonObject.put(UserModel.JSON_PASSWORD, userModel.getPassword());
        return jsonObject;
    }

    public static ArrayList<UserModel> getUserAccountsList(Context context){
        String userAccounts = getUserAccounts(context);
        try {
            JSONArray jsonArray = userAccounts.isEmpty() ? new JSONArray() : new JSONArray(userAccounts);
            return buildUserModels(jsonArray);
        }catch (JSONException ex){
            return null;
        }
    }

    public static ArrayList<UserModel> buildUserModels(JSONArray jsonArray){
        if(jsonArray == null || jsonArray.length() == 0){
            return null;
        }
        ArrayList<UserModel> userModels = new ArrayList<>();
        for(int i = 0 ; i < jsonArray.length(); i++){
            try {
                UserModel userModel = buildUserModel(jsonArray.getJSONObject(i));
                if(userModel != null){
                    userModels.add(userModel);
                }
            }catch (JSONException ex){

            }
        }
        return userModels;
    }

    public static UserModel buildUserModel(JSONObject jsonObject){
        if(jsonObject == null){
            return null;
        }
        try {
            UserModel userModel = new UserModel();
            userModel.setName(jsonObject.getString(UserModel.JSON_NAME));
            userModel.setEmail(jsonObject.getString(UserModel.JSON_EMAIL));
            userModel.setLocation(jsonObject.getString(UserModel.JSON_LOCATION));
            userModel.setPassword(jsonObject.getString(UserModel.JSON_PASSWORD));
            return userModel;
        }catch (JSONException ex){
            return null;
        }
    }
}
