package org.example.page_object_model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.example.utilities.CommonPageInteractions;

import java.util.Set;

/**
 * Abstract base class for all page objects. Provides common functionality and serves as a parent class
 * for all specific page objects in the web application.
 * <p>
 * This class handles the initialization of the WebDriver and common page interactions.
 * </p>
 *
 * @author Harvey C
 */
public abstract class BasePage {

    protected final Logger logger = LogManager.getRootLogger();

    /** The WebDriver instance used to interact with the web browser. */
    protected WebDriver driver;

    /** Common page interactions helper. */
    protected CommonPageInteractions commonPageInteractions;

    /**
     * Opens the specific page. Must be implemented by all subclasses.
     *
     * @return the instance of the page that is opened.
     */
    protected abstract BasePage openPage();

    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.commonPageInteractions = new CommonPageInteractions(this.driver);
    }

    /**
     * Switches to a newly opened browser tab.
     * <p>
     * This method finds the handle of the newly opened tab by comparing the handles
     * of all currently open tabs to the handle of the current tab. It then switches
     * to the new tab and logs the action. If no new tab is found, it logs a message
     * indicating so.
     * </p>
     */
    public void switchToNewTab(String tabTitle){
        String actualTab = driver.getWindowHandle();
        String newTabHandle;

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(actualTab)) {
                newTabHandle = handle;
                driver.switchTo().window(newTabHandle);
                if (driver.getTitle().contains(tabTitle)){
                    logger.info("Switched to tab that contains "+ tabTitle +" in the title");
                    break;
                }
            }
        }
    }
}
