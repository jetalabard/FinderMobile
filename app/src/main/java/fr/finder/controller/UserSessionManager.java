package fr.finder.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;

import java.util.HashMap;

import fr.finder.finder.LoginActivity;

/**
 * Created by Gilo on 15/03/2018.
 */

public class UserSessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;
    private static final String PREFER_NAME = "AndroidFinderPref";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";


    public UserSessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createUserLoginSession(String name, String pass) {
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_USERNAME, name);
        editor.putString(KEY_PASSWORD, pass);
        editor.commit();
    }

    public boolean checkLogin() {
        if(!this.isUserLogedIn()) {
            Intent i = new Intent (context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            return true;
        }
        return false;
    }

    public boolean isUserLogedIn()
    {
        return pref.getBoolean(IS_USER_LOGIN,false);
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_USERNAME, pref.getString(KEY_USERNAME, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));

        return user;
    }

    public void logOutUser()
    {
        editor.clear();
        editor.commit();
    }
}
