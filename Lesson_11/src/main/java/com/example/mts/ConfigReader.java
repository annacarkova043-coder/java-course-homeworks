package com.example.mts;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    
    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getUrl() {
        return properties.getProperty("website.url", "https://www.mts.by");
    }
    
    public static String getTestPhoneNumber() {
        return properties.getProperty("test.phone.number", "297777777");
    }
    
    public static String getTestAmount() {
        return properties.getProperty("test.payment.amount", "10.50");
    }
    
    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout.seconds", "10"));
    }
}