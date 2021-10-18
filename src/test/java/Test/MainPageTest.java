package test.java.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test(description = "check Main Page Title")
    @Severity(SeverityLevel.NORMAL)
    public void checkMainPageTitle() {
        mainPage.isShown();

        Assert.assertEquals(mainPage.getTitle(), "Online Store | My Store");
    }

    @Test(description = "check that the Product has only one Sticker")
    @Severity(SeverityLevel.NORMAL)
    public void checkProductHasOneSticker() {
        mainPage.isShown();

        Assert.assertTrue(mainPage.checkProductOneSticker(), "one or more Products don't have one Sticker");
    }

}
