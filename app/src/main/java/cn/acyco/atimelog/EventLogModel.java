package cn.acyco.atimelog;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author Acyco
 * @create 2021-07-01 14:26
 * @url https://acyco.cn
 */
public class EventLogModel {
    private SQLiteDatabase db;
    public EventLogModel(Context context) {
        this.db = ATimeLogApp.getDb(context);
    }

    //添加
    public long insert(EventLogBean eventLog) {
        ContentValues values = new ContentValues();
        values.put("event",eventLog.getEvent());
        values.put("startTime",DbUtil.DateToSqlite(eventLog.getStartTime()));
        values.put("endTime",eventLog.getEvent());
        values.put("type",eventLog.getType());
        values.put("note",eventLog.getNote());
        return this.db.insert(Canstant.TABLE_NAME_EVENT_LOG, null, values);
    }
}
