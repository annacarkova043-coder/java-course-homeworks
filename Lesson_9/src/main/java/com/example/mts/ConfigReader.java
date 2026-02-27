package com.example.mts;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    
    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static String getUrl() {
        return properties.getProperty("website.url", "https://www.mts.by");
    }
    
    public static String getTestPhoneNumber() {
        return properties.getProperty("phone.number", "297777777");
    }
    
    public static String getTestAmount() {
        return properties.getProperty("payment.amount", "10.50");
    }
    
    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout.seconds", "10"));
    }
}