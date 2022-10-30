package com.qing.pedometer.frame;

import android.content.Context;

public class PrefsManager {
    private static final String TAG = "PrefsManager";
    private static final String SP_NAME = "sp";
    private final Context mContext;

    public PrefsManager(Context mContext) {
        this.mContext = mContext;
    }

    public void clearSp() {
        mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit().clear().apply();
    }

    public boolean isKeyExits(final String key) {
        return mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).contains(key);
    }

    public boolean getBoolean(final String key) {
        return mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).getBoolean(key, false);
    }

    public boolean getBooleanDefaultTrue(final String key) {
        return mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).getBoolean(key, true);
    }

    public void putBoolean(final String key, final boolean bool) {
        mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit().putBoolean(key, bool).apply();
    }
}
