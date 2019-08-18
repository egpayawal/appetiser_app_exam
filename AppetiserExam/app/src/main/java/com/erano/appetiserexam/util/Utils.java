package com.erano.appetiserexam.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Eraño Payawal on 2019-08-18.
 * hunterxer31@gmail.com
 */
public class Utils {

    private Context mContext;

    public Utils(Context context) {
        this.mContext = context;
    }

    public void saveId(String Id) {
        SharedPreferences myPrefs = mContext.getSharedPreferences("SCREEN", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString("Id", Id);
        prefsEditor.apply();
    }

    public String getId() {
        SharedPreferences myPrefs = mContext.getSharedPreferences("SCREEN", Context.MODE_PRIVATE);
        return myPrefs.getString("Id", "");
    }

    public void saveScreen(String lastScreen) {
        SharedPreferences myPrefs = mContext.getSharedPreferences("SCREEN", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString("lastScreen", lastScreen);
        prefsEditor.apply();
    }

    public String getLastScreen() {
        SharedPreferences myPrefs = mContext.getSharedPreferences("SCREEN", Context.MODE_PRIVATE);
        return myPrefs.getString("lastScreen", "");
    }

}
