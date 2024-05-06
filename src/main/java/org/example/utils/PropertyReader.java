package org.example.utils;

import org.example.constants.FilePaths;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String getProperty(String key) {
        Properties properties = new Properties();

        System.out.println(FilePaths.TEST_CONFIG_PATH);
        try {
            FileInputStream fileInputStream = new FileInputStream(FilePaths.TEST_CONFIG_PATH);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (properties == null) {
            throw new NullPointerException("Properties not loaded");
        }

        return properties.getProperty(key);
    }
}
