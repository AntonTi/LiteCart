package test.java.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.Utils.PropertyLoader;

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

    @Test(description = "check Product REGULAR PRICE COLOR on Product Page")
    public void checkProdRegularPriceColor() {
        mainPage.isShown();
        mainPage.goToProductPage();

        Assert.assertEquals(productPage.getProductRegularPriceColor(), "rgba(102, 102, 102, 1)",
                "Product Regular Price Color on Product Page doesn't match");
    }

    @Test(description = "check Product REGULAR STRIKETHROUGH PRICE on Product Page")
    public void checkProdRegularPriceStrike() {
        mainPage.isShown();
        mainPage.goToProductPage();

        Assert.assertEquals(productPage.getProductRegularStrikePrice(), "s",
                "Product Regular Price on Product Page must be strikethrough");
    }

    @Test(description = "check Product REGULAR PRICE FONT SIZE on Product Page")
    public void checkProdRegularPriceFontSize() {
        mainPage.isShown();
        mainPage.goToProductPage();

        Assert.assertEquals(productPage.getProductRegularPriceFontSize(), "16px",
                "Product Regular Price Font Size on Product Page doesn't match");
    }

    @Test(description = "check Product CAMPAIGN PRICE COLOR on Product Page")
    public void checkProdCampaignPriceColor() {
        mainPage.isShown();
        mainPage.goToProductPage();

        Assert.assertEquals(productPage.getProductCampaignPriceColor(), "rgba(204, 0, 0, 1)",
                "Product Campaign Price Color on Product Page doesn't match");
    }

    @Test(description = "check Product CAMPAIGN BOLD PRICE on Product Page")
    public void checkProdCampaignBoldPrice() {
        mainPage.isShown();
        mainPage.goToProductPage();

        Assert.assertEquals(productPage.getProductCampaignBoldPrice(), "strong",
                "Product Campaign Price on Product Page must be bold");
    }

    @Test(description = "check Product CAMPAIGN PRICE FONT SIZE on Product Page")
    public void checkProdCampaignPriceFontSize() {
        mainPage.isShown();
        mainPage.goToProductPage();

        Assert.assertEquals(productPage.getProductCampaignPriceFontSize(), "22px",
                "Product Campaign Price Font Size on Product Page doesn't match");
    }

    // IMPORTANT!!! This test requires manual filling of the captcha field.
    @Test(description = "check User Registration and login to User new Account")
    public void checkUserRegistration() {
        // Check User Registration
        mainPage.isShown();
        mainPage.goToUserRegistrationPage();
        userRegistrationPage.isShown();
        userRegistrationPage.fillInRegistrationForm();
        userRegistrationPage.sendRegistrationForm();

        Assert.assertEquals(userRegistrationPage.getMessageSuccessRegistration(),
                "Your customer account has been created.",
                "Your customer account has not been created");

        userPersonalArea.isShown();
        userPersonalArea.logoutAsUser();

        // Check login to User new Account
        mainPage.isShown();
        mainPage.loginToUserNewAccount();
        userPersonalArea.isShown();

        Assert.assertEquals(userPersonalArea.getMessageSuccessLogin(),
                "You are now logged in as " +
                        PropertyLoader.getProperty("userFirstName") + " " +
                        PropertyLoader.getProperty("userLastName") + ".");

        userPersonalArea.logoutAsUser();
        Assert.assertTrue(userPersonalArea.getMessageSuccessLogout().contains("You are now logged out."),
                "You are not logged out of your account");
    }


}
