package cn.acyco.atimelog;

import java.text.SimpleDateFormat;

/**
 * @author Acyco
 * @create 2021-07-01 14:36
 * @url https://acyco.cn
 */
public class Canstant {
    public static SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat TIMEFORMAT = new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat DATETIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //表名
    public static final String TABLE_NAME_EVENT_LOG = "event_log";
}
