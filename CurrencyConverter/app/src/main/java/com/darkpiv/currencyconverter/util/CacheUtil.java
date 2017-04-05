package com.darkpiv.currencyconverter.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by thanhnguyen on 6/16/16.
 */
public class CacheUtil {
    private static final String PREFS_NAME = "darkpiv";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static void write(Context context, String name, String value) {
        CacheUtil.getSharedPreferences(context).edit()
                .putString(name, value)
                .apply();
    }

    public static String read(Context context, String name) {
        return CacheUtil.getSharedPreferences(context)
                .getString(name, null);
    }

    public static void clearCacheUtil(Context context) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        settings.edit().clear().commit();
    }
}
