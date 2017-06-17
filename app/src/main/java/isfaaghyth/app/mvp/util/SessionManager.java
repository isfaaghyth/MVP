package isfaaghyth.app.mvp.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import isfaaghyth.app.mvp.App;

/**
 * Created by isfaaghyth on 6/18/17.
 */

public class SessionManager {

    private static SharedPreferences getPref() {
        return PreferenceManager.getDefaultSharedPreferences(App.getContext());
    }

    public static void save(String key, String value) {
        getPref().edit().putString(key, value).apply();
    }

    public static void save(String key, Boolean value) {
        getPref().edit().putBoolean(key, value).apply();
    }

    public static Boolean checkExist(String key) {
        return getPref().contains(key);
    }

    public static String grabString(String key) {
        return getPref().getString(key, null);
    }

    public static Boolean grabBoolean(String key) {
        return getPref().getBoolean(key, false);
    }

}
