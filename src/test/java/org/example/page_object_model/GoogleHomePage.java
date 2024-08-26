package org.example.page_object_model;

import org.example.service.TestDataReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends BasePage{

    @FindBy (xpath = "//textarea[@role='combobox']")
    private WebElement searchBar;

    @FindBy (xpath = "(//input[@name='btnK'])[2]")
    private WebElement searchButton;

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

    public void searchOnGoogle (String valueToSearch){
        commonPageInteractions.clickOnElement(searchBar);
        commonPageInteractions.sendTextToInput(searchBar,valueToSearch);
        commonPageInteractions.sendKeysToInput(searchBar, Keys.ENTER);
    }

}
