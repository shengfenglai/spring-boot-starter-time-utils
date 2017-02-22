package spring.boot.starter.time.utils;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

public class TimeUtils {

    private static final String MINUTE_TEXT = "分钟前";
    private static final String HOUR_TEXT = "小时前";
    private static final String DAY_TEXT = "天前";

    private static final int SECONDS_OF_MINUTE = 60;
    private static final int SECONDS_OF_HOUR = 60 * 60;
    private static final int SECONDS_OF_DAY = 24 * 60 * 60;

    public String generateCreateTimeText(Date date) {

        DateTime now = new DateTime();
        DateTime createTime = new DateTime(date);

        int intervalSeconds = Seconds.secondsBetween(createTime, now).getSeconds();

        int minutes = (int) Math.ceil((double) intervalSeconds / SECONDS_OF_MINUTE);
        if (minutes < 60) {
            return String.format("%d%s", minutes, MINUTE_TEXT);
        }

        int hours = (int) Math.ceil((double) intervalSeconds / SECONDS_OF_HOUR);
        if (hours < 24) {
            return String.format("%d%s", hours, HOUR_TEXT);
        }

        return String.format("%d%s", (int) Math.ceil((double) intervalSeconds / SECONDS_OF_DAY), DAY_TEXT);
    }

}
