package org.example.service;

import java.util.ResourceBundle;

/**
 * Class responsible for reading test data from a properties file based on the environment.
 * @author Harvey C
 */
public class TestDataReader {

    /** ResourceBundle to hold the test data for the specified environment. */
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    /**
     * Retrieves the test data associated with the specified key.
     *
     * @param key the key for the desired test data
     * @return the test data value associated with the specified key
     */
    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}

