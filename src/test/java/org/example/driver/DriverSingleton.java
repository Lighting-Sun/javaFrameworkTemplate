package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Singleton class to manage the WebDriver instance.
 *
 * @author Harvey C
 */
public class DriverSingleton {

    private static WebDriver driver;

    /**
     * Private constructor to prevent instantiation.
     */
    private DriverSingleton() {
    }

    /**
     * Gets the single instance of WebDriver.
     * Initializes the WebDriver if it is not already initialized.
     *
     * @return the WebDriver instance
     */
    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }

            if (System.getProperty("cookies").equalsIgnoreCase("Y")) {
                driver.manage().deleteAllCookies();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    /**
     * Closes the WebDriver instance and sets it to null.
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
