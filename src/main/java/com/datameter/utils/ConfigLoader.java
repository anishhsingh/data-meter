package com.datameter.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConfigLoader {
    private static final Logger logger = Logger.getLogger(ConfigLoader.class.getName());
    private static final Properties config = new Properties();

    public static void loadConfig() throws Exception {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            config.load(fis);
            logger.info("Configuration loaded successfully.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to load config.properties", e);
            throw e;
        }
    }

    public static double getRate(String key) {
        return Double.parseDouble(config.getProperty(key, "0.0"));
    }

    public static int getThreshold() {
        return Integer.parseInt(config.getProperty("threshold", "100000"));
    }
}
