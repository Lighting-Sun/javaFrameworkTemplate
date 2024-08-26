package org.example.test;

import org.example.page_object_model.GoogleHomePage;
import org.testng.annotations.Test;

public class IFrameHandlingTest extends CommonConditions{

    @Test(description = "A simple test to handle iframes")
    public void iframeHandlingSampleTest(){

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.openPage();
    }

}
