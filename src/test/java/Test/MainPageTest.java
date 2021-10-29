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

    @Test(description = "check that the Product Name on the Main Page matches the Product Name on the Product Page")
    @Severity(SeverityLevel.NORMAL)
    public void checkCorrectProductName() {
        mainPage.isShown();
        String name = mainPage.getProductNameCampaigns();
        mainPage.goToProductPage();

        Assert.assertEquals(name, productPage.getProductName(),
                "Product Name on the Main Page doesn't match the Product Name on the Product Page");
    }

    @Test(description = "check that the Product Regular Price on the Main Page matches the Product Regular Price on the Product Page")
    @Severity(SeverityLevel.NORMAL)
    public void checkProductRegularPrice() {
        mainPage.isShown();
        String price = mainPage.getProductRegularPriceCampaigns();
        mainPage.goToProductPage();

        Assert.assertEquals(price, productPage.getProductRegularPrice(),
                "Product Regular Price on the Main Page doesn't match the Product Regular Price on the Product Page");

    }

}
