package cn.acyco.atimelog;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Acyco
 * @create 2021-07-01 14:31
 * @url https://acyco.cn
 */
public class DbUtil {

    public static String DateToSqlite(Date date) {
        if(null == date) {
            return "";
        } else {
            return Canstant.DATETIMEFORMAT.format(date);
        }
    }

}
