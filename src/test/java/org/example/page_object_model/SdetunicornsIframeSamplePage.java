package org.example.page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SdetunicornsIframeSamplePage extends BasePage{

    public IframePage iframePage;

    private final By IframeLocator = By.xpath("//iframe[@name='advanced_iframe']");

    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    public SdetunicornsIframeSamplePage(WebDriver driver) {
        super(driver);
        this.iframePage = new IframePage(driver);
    }

    @Override
    protected BasePage openPage() {
        throw new RuntimeException("This page should not be directly open by calling this method");
    }

    public void switchToAdvancedIframe(){
        commonPageInteractions.switchToIframe(IframeLocator);
    }

}
