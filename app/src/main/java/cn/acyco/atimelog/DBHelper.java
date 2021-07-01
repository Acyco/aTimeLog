package cn.acyco.atimelog;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author Acyco
 * @create 2021-07-01 01:48
 * @url https://acyco.cn
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String TAG = "DBHelper";
    public static final String DB_NAME = "atimelog";  // atimelog.db
    private static int DB_VERSION = 1;


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context) {
        this(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            createTableEventLog(db);
        } catch (SQLException e) {
            Log.e(TAG, "onCreate: ", e);
        }
    }

    private void createTableEventLog(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE event_log (" +
                "_id INTEGER PRIMARY KEY, " +
                "event TEXT, " +
                "startTime TEXT, " +
                "endTime  TEXT, " +
                "type TEXT, " +
                "note TEXT " +
                ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
