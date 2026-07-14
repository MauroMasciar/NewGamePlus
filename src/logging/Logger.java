package logging;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Logger {
    public static FileWriter fw = null;
    public static PrintWriter pw = null;
    public static LocalDate c = LocalDate.now();
    public static LocalTime t = LocalTime.now();

    public Logger(String string) {
        if(string != null) {
            loguear(string);
        }
    }

    public static void loguear(String string) {
        c = LocalDate.now();
        t = LocalTime.now();

        String sHour, sMinute, sSecond;
        int hour, minute, second;
        hour = LocalTime.now().getHour();
        minute = LocalTime.now().getMinute();
        second = LocalTime.now().getSecond();

        if(second < 10) sSecond = "0" + second;
        else sSecond = String.valueOf(second);

        if(minute < 10) sMinute = "0" + minute;
        else sMinute = String.valueOf(minute);

        if(hour < 10) sHour = "0" + hour;
        else sHour = String.valueOf(hour);

        try {
            fw = new FileWriter("debug.log", true);
            pw = new PrintWriter(fw);
            String s = "[" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + " " + sHour + ":" 
                    + sMinute + ":" + sSecond + "] " + string;
            pw.println(s);
            System.out.println(s);
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
