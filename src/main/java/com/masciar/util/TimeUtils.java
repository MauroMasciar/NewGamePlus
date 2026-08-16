package com.masciar.util;

public class TimeUtils {
    /*
     * public static String getFormattedTime() {
     * String time, sHour, sMinute, sSecond;
     * int hour, minute, second;
     * hour = LocalTime.now().getHour();
     * minute = LocalTime.now().getMinute();
     * second = LocalTime.now().getSecond();
     * 
     * if(second < 10) sSecond = "0" + second;
     * else sSecond = String.valueOf(second);
     * 
     * if(minute < 10) sMinute = "0" + minute;
     * else sMinute = String.valueOf(minute);
     * 
     * if(hour < 10) sHour = "0" + hour;
     * else sHour = String.valueOf(hour);
     * 
     * time = sHour + ":" + sMinute + ":" + sSecond;
     * return time;
     * }
     */

    public static String getTotalHoursFromSeconds(int seconds, boolean withSeconds) {
        String sHour, sMinute, sSecond;
        int seconds_final = 0;
        int minutes = seconds / 60;
        seconds_final = seconds % 60;
        int minutes_final = minutes % 60;
        int hours_final = minutes / 60;

        if (seconds_final < 10)
            sSecond = "0" + seconds_final;
        else
            sSecond = String.valueOf(seconds_final);

        if (minutes_final < 10)
            sMinute = "0" + minutes_final;
        else
            sMinute = String.valueOf(minutes_final);

        sHour = String.valueOf(hours_final);

        if (withSeconds)
            return sHour + "h " + sMinute + "m " + sSecond + "s";
        return sHour + "h " + sMinute + "m";
    }

    public static String getTotalDaysFromSeconds(int totalSeconds) {
        int days = totalSeconds / 86400;
        int hours = (totalSeconds % 86400) / 3600;
        int minutes = (totalSeconds % 3600) / 60;

        StringBuilder time = new StringBuilder();

        time.append(days).append(" días ");
        if (hours > 0 || hours > 0)
            time.append(hours).append("h ");
        time.append(minutes).append("m ");

        return time.toString().trim();
    }
}
