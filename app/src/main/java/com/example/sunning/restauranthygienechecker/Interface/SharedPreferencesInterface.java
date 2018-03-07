package com.example.sunning.restauranthygienechecker.Interface;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sunning.restauranthygienechecker.Models.User;
import com.google.gson.Gson;

public class SharedPreferencesInterface {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String USER_SHARED_PREFERENCES = "User";

    public SharedPreferencesInterface(Context context) {
        sharedPreferences = context.getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    public void setEditor(SharedPreferences.Editor editor) {
        this.editor = editor;
    }

    public void setUserSharedPreference(User user) {
        this.editor = this.sharedPreferences.edit();
        Gson gson = new Gson();

        String objectToSave = gson.toJson(user);
        this.editor.putString(USER_SHARED_PREFERENCES, objectToSave);
        this.editor.commit();
    }

    public User getUserSharedPreference() {
        Gson gson = new Gson();
        String objectToRetrieve =  this.sharedPreferences.getString(USER_SHARED_PREFERENCES, "");

        if (objectToRetrieve != "") {
            User user = gson.fromJson(objectToRetrieve, User.class);
            return user;
        }
        return null;
    }
}
