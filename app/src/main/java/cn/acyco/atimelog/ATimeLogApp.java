package cn.acyco.atimelog;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


/**
 * @author Acyco
 * @create 2021-07-01 05:28
 * @url https://acyco.cn
 */
public class ATimeLogApp extends Application {
    public static final String TAG = "ATimeLogApp";
    private static String VERSION_NAME;
    public static SQLiteDatabase db;
    public static ATimeLogApp instance;

    public static ATimeLogApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ATimeLogApp");
        instance = this;

    }
    public static SQLiteDatabase getDb(Context context) {
        if (db == null) {
            db = new DBHelper(context).getWritableDatabase();
        }
        try {
            if (VERSION_NAME == null) {
                VERSION_NAME = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (db == null) {
            db = new DBHelper(ATimeLogApp.getInstance()).getWritableDatabase();
        }
        return db;
    }
}
