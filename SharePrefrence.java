package com.infodart.salman.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharePrefrence {

    public static String getToken(Context context) {

        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString("TOKEN", "");
    }

    public static void setToken(Context context, String Token) {

        SharedPreferences _sharedPreferences = PreferenceManager.
                getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = _sharedPreferences.edit();
        editor.putString("TOKEN", Token);
        editor.commit();

    }

}
