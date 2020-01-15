package com.company.automation.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropFileHandler {

	public PropFileHandler() {
		// TODO Auto-generated constructor stub
	}

	static Properties properties = new Properties();
	static String filePath = "data.properties";

	public void writeProperty(String property, String value) {

        try {
            InputStream inPropFile = new FileInputStream(filePath);
            properties.load(inPropFile);
            inPropFile.close();
            OutputStream outPropFile = new FileOutputStream(filePath);
            
            properties.setProperty(property, value);
            properties.store(outPropFile, null);
            outPropFile.close();
        } catch (IOException e) {
        }
    }
	
	public static String readProperty(String property) {
        InputStream inPropFile = null;
        try {
         inPropFile = new FileInputStream(filePath);
            properties.load(inPropFile);
        } catch (IOException e) {
         System.out.println("There was a problem reading the data from file");
        }
        String value = properties.getProperty(property);
        return value;
    }
}