package com.company.automation.utilities;

import java.util.Properties;

public class ConfigPropertyReader {

    private static String defaultConfigFile = "./configuration.properties";

    public ConfigPropertyReader() {
    }
    
    public static String getProperty(String propFile, String Property) {
        try {
            Properties prop = ResourceLoader.loadProperties(propFile);
            return prop.getProperty(Property);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String getProperty(String property){
        return getProperty(defaultConfigFile, property);
    }
}