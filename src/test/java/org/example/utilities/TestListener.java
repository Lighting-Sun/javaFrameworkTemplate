package org.example.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.example.driver.DriverSingleton;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    /**
     * Logger instance for logging messages.
     */
    private Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    /**
     * This method takes a screenshot when the test scenario fails
     * @param result ITestResult object
     */
    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }

    /**
     * Saves a screenshot of the current browser window.
     * The screenshot is saved to the 'target/screenshots' directory
     * with a filename based on the current timestamp.
     */
    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot)DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture,new File(".//target/screenshots/"
                    + getCurrentTimeAsString()+ ".png"));
        }catch (IOException e){
            logger.error("Failed to save screenshot: "+ e.getLocalizedMessage());
        }
    }

    /**
     * Returns the current time as a formatted string.
     * The format used is 'yyyy-MM-dd_HH-mm-ss'.
     *
     * @return a string representing the current time
     */
    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
