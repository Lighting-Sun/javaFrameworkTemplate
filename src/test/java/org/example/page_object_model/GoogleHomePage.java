package org.example.page_object_model;

import org.example.service.TestDataReader;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends BasePage{


    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage openPage() {
        String googleHomePage = TestDataReader.getTestData("testdata.google.home.page");
        logger.info("Opening "+ googleHomePage +" page");
        driver.get(googleHomePage);
        return this;
    }
}
