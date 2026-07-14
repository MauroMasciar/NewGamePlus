package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigProperties {
	public static void setProperty(String key, String value) {
		FileInputStream file;
		try {
			file = new FileInputStream("config.properties");
			Properties prop = new Properties();
			prop.load(file);
			prop.setProperty(key, value);
	        try(FileOutputStream output = new FileOutputStream("config.properties")) {
	        	prop.store(output, "Application and user config");
	        } catch(IOException e) {
	            e.printStackTrace();
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		Properties prop = new Properties();
        FileInputStream file;
		try {
			file = new FileInputStream("config.properties");
			prop.load(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
        
        String value = prop.getProperty(key);
        return value;
	}
}
