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
        String priceReg = mainPage.getProductRegularPriceCampaigns();
        mainPage.goToProductPage();

        Assert.assertEquals(priceReg, productPage.getProductRegularPrice(),
                "Product Regular Price on the Main Page doesn't match the Product Regular Price on the Product Page");
    }

    @Test(description = "check that the Product Campaign Price on the Main Page matches the Product Campaign Price on the Product Page")
    @Severity(SeverityLevel.NORMAL)
    public void checkProductCampaignPrice() {
        mainPage.isShown();
        String priceCamp = mainPage.getProductCampaignPriceCampaigns();
        mainPage.goToProductPage();

        Assert.assertEquals(priceCamp, productPage.getProductCampaignPrice(),
                "Product Campaign Price on the Main Page doesn't match the Product Campaign Price on the Product Page");
    }

    @Test(description = "check first Product REGULAR PRICE COLOR in category 'Campaigns'")
    public void checkProductRegularPriceColor() {
        mainPage.isShown();

        Assert.assertEquals(mainPage.getProductRegularPriceColor(), "rgba(119, 119, 119, 1)",
                "Product Regular Price Color in category 'Campaigns' doesn't match");
    }

    @Test(description = "check first Product REGULAR STRIKETHROUGH PRICE in category 'Campaigns'")
    public void checkProductRegularPriceStrike() {
        mainPage.isShown();

        Assert.assertEquals(mainPage.getProductRegularStrikePrice(), "s",
                "Product Regular Price in category 'Campaigns' must be strikethrough");
    }

    @Test(description = "check first Product REGULAR PRICE FONT SIZE in category 'Campaigns'")
    public void checkProductRegularPriceFontSize() {
        mainPage.isShown();

        Assert.assertEquals(mainPage.getProductRegularPriceFontSize(), "14.4px",
                "Product Regular Price Font Size in category 'Campaigns' doesn't match");
    }

    @Test(description = "check first Product CAMPAIGN PRICE COLOR in category 'Campaigns'")
    public void checkProductCampaignPriceColor() {
        mainPage.isShown();

        Assert.assertEquals(mainPage.getProductCampaignPriceColor(), "rgba(204, 0, 0, 1)",
                "Product Campaign Price Color in category 'Campaigns' doesn't match");
    }

    @Test(description = "check first Product CAMPAIGN BOLD PRICE in category 'Campaigns'")
    public void checkProductCampaignBoldPrice() {
        mainPage.isShown();

        Assert.assertEquals(mainPage.getProductCampaignBoldPrice(), "strong",
                "Product Campaign Price in category 'Campaigns' must be bold");
    }

    @Test(description = "check first Product CAMPAIGN PRICE FONT SIZE in category 'Campaigns'")
    public void checkProductCampaignPriceFontSize() {
        mainPage.isShown();

        Assert.assertEquals(mainPage.getProductCampaignPriceFontSize(), "18px",
                "Product Campaign Price Font Size in category 'Campaigns' doesn't match");
    }


}
