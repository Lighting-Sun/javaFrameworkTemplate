package org.example.page_object_model;

import org.example.service.TestDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleResultsPage extends BasePage{


    private WebElement getSearchResultByName (String srtSearchResultName){
        logger.info("Getting search result by name: " + srtSearchResultName);
        return commonPageInteractions.getWebElement(By.xpath("//h3[text()='" + srtSearchResultName + "']"));
    }

    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    public GoogleResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        throw new RuntimeException("This page should not be directly open by calling this method");
    }

    public void clickOnSearchResult (String srtSearchResultByName){
        commonPageInteractions.clickOnElement(getSearchResultByName(srtSearchResultByName));
    }

}
