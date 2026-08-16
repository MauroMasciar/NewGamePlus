package com.masciar.util;

import com.masciar.logging.ErrorHandler;

import java.awt.Color;
import java.awt.Component;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Utils {
    public static final String GAME_INFO_SESSION_TEXT_VALUE = "#ffffff";
    public static final Color COLOR_BACKGROUND_GAMEINFO_SESSION = new Color((int) Long.parseLong("101F2328", 16), true);
    public static final String COLOR_BACKGROUND = "#121214";
	public static final String COLOR_GREEN = "#48bd4e";
    public static final String COLOR_BACKGROUND_PANEL = "#1F2328";
    public static final String COLOR_BACKGROUND_PANEL_2 = "#2B2F36";
    public static final String DATABASE_URL = "jdbc:sqlite:database.db?busy_timeout=5000";
    public static final int MINIMUN_SESSION_SECONDS = 300;
    public static final int SECONDS_PER_HOUR = 3600;
    
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
            ErrorHandler.handle(e);
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
}
