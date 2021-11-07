package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.Utils.PropertyLoader;

import java.util.List;

public class MainPage extends BasePage {

    By footer = By.cssSelector("footer#footer");
    By product = By.cssSelector("div.content .image-wrapper");
    By sticker = By.cssSelector("div.content div.sticker");
    By firstProductInCampaigns = By.cssSelector("#box-campaigns  a.link");
    By productNameCampaigns = By.cssSelector("#box-campaigns  a.link div.name");
    By productRegularPriceCampaigns = By.cssSelector("#box-campaigns  a.link .regular-price");
    By productCampaignPriceCampaigns = By.cssSelector("#box-campaigns  a.link .campaign-price");
    By btnCreateUserAccount = By.xpath("//a[contains(text(),'New customers click here')]");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("open Main Page")
    public MainPage isShown() {
        logger.info("open Main Page");
        driver.get(PropertyLoader.getProperty("urlMain"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
        return this;
    }

    @Step("get Main Page Title")
    public String getTitle() {
        logger.info("get Main Page Title");
        String title = driver.getTitle();
        return title;
    }

    @Step("check that the Product has only one Sticker")
    public boolean checkProductOneSticker() {
        logger.info("check that the Product has only one Sticker");
        List<WebElement> allProducts = driver.findElements(product);
        //System.out.println(allProducts.size());
        for (WebElement el : allProducts) {
            int count = el.findElements(sticker).size();
            //System.out.println(count);
            if (count != 1) {
                logger.error("one or more Products don't have one Sticker");
                return false;
            }
        }
        return true;
    }

    @Step("go to Product Page")
    public MainPage goToProductPage() {
        logger.info("go to Product Page");
        driver.findElement(firstProductInCampaigns).click();
        return this;
    }

    @Step("get first Product NAME in category 'Campaigns'")
    public String getProductNameCampaigns() {
        logger.info("get first Product NAME in category 'Campaigns'");
        String nameProd = driver.findElement(productNameCampaigns).getText();
        return nameProd;
    }

    @Step("get first Product REGULAR PRICE in category 'Campaigns'")
    public String getProductRegularPriceCampaigns() {
        logger.info("get first Product REGULAR PRICE in category 'Campaigns'");
        String priceReg = driver.findElement(productRegularPriceCampaigns).getText();
        return priceReg;
    }

    @Step("get first Product CAMPAIGN PRICE in category 'Campaigns'")
    public String getProductCampaignPriceCampaigns() {
        logger.info("get first Product CAMPAIGN PRICE in category 'Campaigns'");
        String priceCamp = driver.findElement(productCampaignPriceCampaigns).getText();
        return priceCamp;
    }

    @Step("get first Product REGULAR PRICE COLOR in category 'Campaigns'")
    public String getProductRegularPriceColor() {
        logger.info("get first Product REGULAR PRICE COLOR in category 'Campaigns'");
        String priceColor = driver.findElement(productRegularPriceCampaigns).getCssValue("color");
        return priceColor;
    }

    @Step("get first Product REGULAR STRIKETHROUGH PRICE in category 'Campaigns'")
    public String getProductRegularStrikePrice() {
        logger.info("get first Product REGULAR STRIKETHROUGH PRICE in category 'Campaigns'");
        String priceStrike = driver.findElement(productRegularPriceCampaigns).getTagName();
        return priceStrike;
    }

    @Step("get first Product REGULAR PRICE FONT SIZE in category 'Campaigns'")
    public String getProductRegularPriceFontSize() {
        logger.info("get first Product REGULAR PRICE FONT SIZE in category 'Campaigns'");
        String priceFontSize = driver.findElement(productRegularPriceCampaigns).getCssValue("font-size");
        return priceFontSize;
    }

    @Step("get first Product CAMPAIGN PRICE COLOR in category 'Campaigns'")
    public String getProductCampaignPriceColor() {
        logger.info("get first Product CAMPAIGN PRICE COLOR in category 'Campaigns'");
        String priceColor = driver.findElement(productCampaignPriceCampaigns).getCssValue("color");
        return priceColor;
    }

    @Step("get first Product CAMPAIGN BOLD PRICE in category 'Campaigns'")
    public String getProductCampaignBoldPrice() {
        logger.info("get first Product CAMPAIGN BOLD PRICE in category 'Campaigns'");
        String priceBold = driver.findElement(productCampaignPriceCampaigns).getTagName();
        return priceBold;
    }

    @Step("get first Product CAMPAIGN PRICE FONT SIZE in category 'Campaigns'")
    public String getProductCampaignPriceFontSize() {
        logger.info("get first Product CAMPAIGN PRICE FONT SIZE in category 'Campaigns'");
        String priceFontSize = driver.findElement(productCampaignPriceCampaigns).getCssValue("font-size");
        return priceFontSize;
    }

    @Step("go to User Registration Page")
    public MainPage goToUserRegistrationPage() {
        logger.info("go to User Registration Page");
        driver.findElement(btnCreateUserAccount).click();
        return this;
    }


}
