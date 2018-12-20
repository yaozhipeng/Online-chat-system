package ncu.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeUtil {
    private final static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    private final static SimpleDateFormat formatLong = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");

    public static Timestamp nowTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String timestampToString(Timestamp timestamp) {
        return format.format(timestamp);
    }

    public static String timestampToLongString(Timestamp timestamp) {
        return formatLong.format(timestamp);
    }
}
