package com.epam.tc.api.hw2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    protected static Properties PROPERTIES;

    static {
        try (InputStream fileInputStream =
                 PropertiesReader.class.getClassLoader().getResourceAsStream("com.epam.tc.api.hw2/config.properties")) {

            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
