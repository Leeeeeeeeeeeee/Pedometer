package com.qing.pedometer.frame;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import java.util.LinkedList;

public class FrameApplication extends Application {
    private static final String TAG = "FrameApplication";
    private static FrameApplication instance;
    private static LinkedList<Activity> actList = new LinkedList<Activity>();
    private static PrefsManager prefsManager;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        prefsManager = new PrefsManager(getApplicationContext());
    }

    public FrameApplication getInstance() {
        return instance;
    }

    public LinkedList<Activity> getActList() {
        return actList;
    }

    public static void addToActivityList(final Activity activity) {
        if (activity == null) {
            Log.e(TAG, "addToActList > activity is null");
        } else {
            actList.add(activity);
        }
    }

    public static void removeFromActivityList(final Activity activity) {
        if (actList != null && actList.size() > 0 && actList.indexOf(activity) != -1) {
            actList.remove(activity);
        } else {
            Log.e(TAG, "removeFromActivityList > error");
        }
    }

    public static void clearActivityList() {
        if (actList != null && actList.size() != 0) {
            for (int i = actList.size() - 1; i >= 0; i--) {
                final Activity act = actList.get(i);
                if (act != null) {
                    act.finish();
                }
            }
        }
    }

    public static void exitApp() {
        try {
            clearActivityList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    public PrefsManager getPrefsManager() {
        return prefsManager;
    }
    
}
