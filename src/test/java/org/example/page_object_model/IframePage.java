package org.example.page_object_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage{

    @FindBy (xpath = "//button[@data-cky-tag='accept-button']")
    private WebElement acceptAllButton;

    @FindBy (xpath = "//span[@class='hustle-icon-close']/parent::button")
    private WebElement closeModalButton;

    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    protected IframePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        throw new RuntimeException("This page should not be directly open by calling this method");
    }

    public void AcceptAllCookiesAndCloseModal(){
        commonPageInteractions.clickOnElement(acceptAllButton);
        commonPageInteractions.clickOnElement(closeModalButton);
    }
}
