package org.example.test;

import org.example.page_object_model.GoogleHomePage;
import org.example.page_object_model.GoogleResultsPage;
import org.example.page_object_model.SdetunicornsIframeSamplePage;
import org.testng.annotations.Test;
import static org.example.constants.Constants.*;


public class IFrameHandlingTest extends CommonConditions{

    @Test(description = "A simple test to handle iframes")
    public void iframeHandlingSampleTest(){

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.openPage();
        googleHomePage.searchOnGoogle(PRACTICE_SDETUNICORNS_IFRAME_SAMPLE);

        GoogleResultsPage googleResultsPage = new GoogleResultsPage(driver);
        googleResultsPage.clickOnSearchResult(IFRAME_SAMPLE_SEARCH_RESULT);

        SdetunicornsIframeSamplePage sdetunicornsIframeSamplePage = new SdetunicornsIframeSamplePage(driver);
        sdetunicornsIframeSamplePage.switchToAdvancedIframe();
        sdetunicornsIframeSamplePage.iframePage.AcceptAllCookiesAndCloseModal();
    }

}
