package util;

import java.awt.Component;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Utils {
	public static final String COLOR_GREEN = "#48bd4e";
    public static final int MINIMUN_SESSION_SECONDS = 300;
    public static final int SECONDS_PER_HOUR = 3600;
    
    public static String getFormattedDate() {
        String date;
        date = LocalDate.now().getYear() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth();
        return date;
    }

    /*public static String getFormattedTime() {
        String time, sHour, sMinute, sSecond;
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

        time = sHour + ":" + sMinute + ":" + sSecond;
        return time;
    }*/

    public static String getFormattedDateTime() {
        String time, sHour, sMinute, sSecond;
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

        time = LocalDate.now().getYear() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth() + " " + sHour + ":" + sMinute + ":" + sSecond;
        return time;
    }

    public static String getTotalHoursFromSeconds(int seconds, boolean withSeconds) {
        String sHour, sMinute, sSecond;
        int seconds_final = 0;
        int minutes = seconds / 60;
        seconds_final = seconds % 60;
        int minutes_final = minutes % 60;
        int hours_final = minutes / 60;

        if(seconds_final < 10) sSecond = "0" + seconds_final;
        else sSecond = String.valueOf(seconds_final);

        if(minutes_final < 10) sMinute = "0" + minutes_final;
        else sMinute = String.valueOf(minutes_final);

        sHour = String.valueOf(hours_final);

        if(withSeconds) return sHour + "h " + sMinute + "m " + sSecond + "s";
        return sHour + "h " + sMinute + "m";
    }

    public static String getTotalDaysFromSeconds(int totalSeconds) {
        int days = totalSeconds / 86400;
        int hours = (totalSeconds % 86400) / 3600;
        int minutes = (totalSeconds % 3600) / 60;

        StringBuilder time = new StringBuilder();

        if (days > 0) time.append(days).append(" d ");
        if (hours > 0 || hours > 0) time.append(hours).append(" h ");
        time.append(minutes).append(" m ");

        return time.toString().trim();
    }

    /*public static void logExceptions(Exception ex) {
        ex.printStackTrace();
        StackTraceElement[] e = ex.getStackTrace();
        Log.Loguear("Rastreo de la pila de getStackTrace:");
        Log.Loguear("Clase\t\t Archivo\t\tLínea\tMetodo");
        for(StackTraceElement element : e ) {
            Log.Loguear(element.getClassName() + "\t\t" + element.getFileName() + "\t\t" + String.valueOf(element.getLineNumber()) + "\t\t" + element.getMethodName());
        }
    }*/

    /*public static void getSize(JInternalFrame internalFrame) {
        new Thread(new Runnable() {
            public void run() {
                while(Main.test) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(internalFrame.getBounds());
                    } catch (InterruptedException ex) {
                        Log.Loguear(ex.getMessage());
                    }
                }
            }
        }).start();
    }*/

    /*public static void cronometer() {
        LocalDateTime initTime;
        initTime = LocalDateTime.now();
        boolean b = true;        
        new Thread(new Runnable() {
            public void run() {
                while(b) {
                    LocalDateTime currentTime = LocalDateTime.now();
                    int secondsBeetwenTimes = (int) ChronoUnit.SECONDS.between(initTime, currentTime);
                    System.out.println(secondsBeetwenTimes);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }                        
                }

            }
        }).start();
    }*/
    
    public static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void autoSizeTable(JTable table) {
        for (int columna = 0; columna < table.getColumnCount(); columna++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(columna);
            int anchoMaximo = 0;
            TableCellRenderer headerRenderer = tableColumn.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = table.getTableHeader().getDefaultRenderer();
            }
            Component header = headerRenderer.getTableCellRendererComponent(table, tableColumn.getHeaderValue(), false, false, 0, columna);

            anchoMaximo = header.getPreferredSize().width;
            for (int fila = 0; fila < table.getRowCount(); fila++) {
                TableCellRenderer renderer = table.getCellRenderer(fila, columna);
                Component component = table.prepareRenderer(renderer, fila, columna);
                anchoMaximo = Math.max(anchoMaximo, component.getPreferredSize().width );
            }
            
            tableColumn.setPreferredWidth(anchoMaximo + 10);
        }
    }
    
    public static String formatDateFromString(String dateString) {
        List<String> dateArray = Arrays.asList(dateString);
        DateTimeFormatter formatterFlex = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss"))
                .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
                .toFormatter();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
        String result = "";
        for (String fechaTexto : dateArray) {
            try {
                LocalDateTime fecha = LocalDateTime.parse(fechaTexto, formatterFlex);
                result = fecha.format(formatter);                
            } catch (Exception e) {
                System.out.println("Error: No se pudo procesar el formato de: " + fechaTexto);
            }
        }
        return result;
    }
}
