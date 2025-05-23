package com.datameter.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties config = new Properties();

    // Loads configuration from config.properties file
    public static void loadConfig() throws Exception {
        FileInputStream fis = new FileInputStream("config.properties");
        config.load(fis); // Load key-value pairs
        fis.close();
    }

    // Returns rate for a given key (default is 0.0 if not found)
    public static double getRate(String key) {
        return Double.parseDouble(config.getProperty(key, "0.0"));
    }

    // Returns threshold value (default is 100000 if not found)
    public static int getThreshold() {
        return Integer.parseInt(config.getProperty("threshold", "100000"));
    }
}
