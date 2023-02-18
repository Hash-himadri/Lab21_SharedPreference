package com.himadri_parikh.lab7_intent;

import android.content.Context;
import android.content.SharedPreferences;

public class SPConfig {
    Context context;
    SharedPreferences sharedPreferences;

    public SPConfig(Context context) {
        this.context = context;
        sharedPreferences =context.getSharedPreferences(context.getResources()
                .getString(R.string.loginPreference),Context.MODE_PRIVATE);
    }
    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.loginStatus), status);
        editor.commit();
    }
    public boolean readLoginStatus(){
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources()
                .getString(R.string.loginStatus),false);
        return status;
    }
}
