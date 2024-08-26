package org.example.test;

import org.example.utilities.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.example.driver.DriverSingleton;

/**
 * Class containing common conditions for setting up and tearing down the WebDriver instance.
 *
 * @author Harvey C
 */
@Listeners({TestListener.class})
public class CommonConditions {

    /** WebDriver instance used for the tests. */
    protected WebDriver driver;

    /**
     * Sets up the browser before any class methods run.
     * Initializes the WebDriver instance using the DriverSingleton.
     */
    @BeforeClass(alwaysRun = true)
    public void browserSetUp() {
        driver = DriverSingleton.getDriver();
    }

    /**
     * Tears down the WebDriver after all class methods have run.
     * Closes the WebDriver instance.
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        // This thread sleep is added so the reviewer can see if the values are filled correctly before the driver gets closed
        Thread.sleep(5000);
        DriverSingleton.closeDriver();
    }
}