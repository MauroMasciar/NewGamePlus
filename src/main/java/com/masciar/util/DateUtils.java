package com.masciar.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.List;

public class DateUtils {
    public static String getFormattedDate() {
        String date;
        date = LocalDate.now().getYear() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth();
        return date;
    }

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

    public static String formatDateFromString(String dateString, int opt) {
        List<String> dateArray = Arrays.asList(dateString);
        DateTimeFormatter formatterFlex = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss"))
                .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
                .toFormatter();
        DateTimeFormatter formatter;

        if(opt == 1) 
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        else if(opt == 2)
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        else
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        String result = "";
        for (String fechaTexto : dateArray) {
            try {
                LocalDateTime fecha = LocalDateTime.parse(fechaTexto, formatterFlex);
                result = fecha.format(formatter);                
            } catch (Exception e) {
                System.out.println("Error: No se pudo procesar el formato de: " + fechaTexto);
                //ErrorHandler.handle(e);
            }
        }
        return result;
    }
}
