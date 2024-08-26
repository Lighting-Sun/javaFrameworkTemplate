package org.example.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class provides common interactions with web elements on a web page.
 * It includes methods for sending text to input fields and clicking on elements.
 * <p>
 * These interactions are facilitated using the WebDriver instance.
 * </p>
 *
 * @author Harvey C
 */
public class CommonPageInteractions {

    /**
     * Logger instance for logging messages.
     */
    private Logger logger = LogManager.getRootLogger();

    /** The WebDriver instance used to interact with the web browser. */
    private final WebDriver driver;

    /** Selenium actions helper */
    protected Actions actions;

    /** WebDriverWait wait helper*/
    protected WebDriverWait wait;


    /**
     * Initializes a new instance of the CommonPageInteractions class.
     *
     * @param driver the WebDriver instance to interact with the web page.
     */
    public CommonPageInteractions(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
        this.wait = new WebDriverWait(this.driver, Duration.ofMillis(15000));
    }

    /**
     * Sends specified content to an input element.
     *
     * @param webElement the WebElement representing the input element.
     * @param content    the text content to send to the input element.
     */
    public void sendTextToInput(WebElement webElement, String content) {
        actions.scrollToElement(webElement);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        webElement.sendKeys(Keys.BACK_SPACE);
        webElement.sendKeys(content);
    }

    /**
     * Sends specified content to an input element.
     *
     * @param webElement the WebElement representing the input element.
     * @param keys    specific keys content to send to the input element.
     */
    public void sendKeysToInput(WebElement webElement, Keys keys) {
        actions.scrollToElement(webElement);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        webElement.sendKeys(keys);
    }

    /**
     * Clicks on a specified web element.
     *
     * @param webElement the WebElement to be clicked.
     */
    public void clickOnElement(WebElement webElement) {
        actions.scrollToElement(webElement);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Retrieves a web element located by a specified locator waiting for it to be present .
     *
     * @param locator the By locator used to find the web element.
     * @return the WebElement found using the specified locator.
     */
    public WebElement getWebElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Retrieves the text content of a specified web element.
     *
     * @param webElement the WebElement whose text content is to be retrieved.
     * @return the text content of the specified web element.
     */
    public String getWebElementText(WebElement webElement) {
        actions.scrollToElement(webElement);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * Waits until the text of a specified web element contains the expected value.
     *
     * @param webElement    the WebElement whose text is to be matched.
     * @param expectedValue the expected text value.
     */
    public void waitUntilWebElementTextHasExpectedValue(WebElement webElement, String expectedValue) {
        actions.scrollToElement(webElement);
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, expectedValue));
        } catch (Exception e) {
            logger.error("Wait for text presence in element timed out. Text value for this element is: " + webElement.getText());
        }
    }

    /**
     * Waits until the web element is present in the DOM using the specified locator.
     *
     * @param locator the locator used to find the element
     * @return true if the element is present before the timeout, false otherwise
     */
    public boolean waitUntilWebElementIsPresentByLocator(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            logger.error("Wait for presence of element timed out. locator used: " + locator);
            return false;
        }
    }

    public void switchToIframe(By locator){

        WebElement iFrame = getWebElement(locator);
        wait.until(ExpectedConditions.visibilityOf(iFrame));
        clickOnElement(iFrame);
        actions.scrollToElement(iFrame);
        wait.until(ExpectedConditions.elementToBeClickable(iFrame));
        driver.switchTo().frame(iFrame);
    }

    public void switchBackToMainPage(){
        driver.switchTo().defaultContent();
    }
}
