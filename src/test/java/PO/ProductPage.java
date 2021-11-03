package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    By productName = By.cssSelector("#box-product h1");
    By productRegularPrice = By.cssSelector("#box-product .regular-price");
    By productCampaignPrice = By.cssSelector("#box-product .campaign-price");


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("get Product Name")
    public String getProductName() {
        logger.info("get Product Name");
        String nameProd = driver.findElement(productName).getText();
        return nameProd;
    }

    @Step("get Product Regular Price")
    public String getProductRegularPrice() {
        logger.info("get Product Regular Price");
        String priceReg = driver.findElement(productRegularPrice).getText();
        return priceReg;
    }

    @Step("get Product Campaign Price")
    public String getProductCampaignPrice() {
        logger.info("get Product Campaign Price");
        String priceCamp = driver.findElement(productCampaignPrice).getText();
        return priceCamp;
    }

    @Step("get Product REGULAR PRICE COLOR")
    public String getProductRegularPriceColor() {
        logger.info("get Product REGULAR PRICE COLOR");
        String priceColor = driver.findElement(productRegularPrice).getCssValue("color");
        return priceColor;
    }

    @Step("get Product REGULAR STRIKETHROUGH PRICE")
    public String getProductRegularStrikePrice() {
        logger.info("get Product REGULAR STRIKETHROUGH PRICE");
        String priceStrike = driver.findElement(productRegularPrice).getTagName();
        return priceStrike;
    }

    @Step("get Product REGULAR PRICE FONT SIZE")
    public String getProductRegularPriceFontSize() {
        logger.info("get Product REGULAR PRICE FONT SIZE");
        String priceFontSize = driver.findElement(productRegularPrice).getCssValue("font-size");
        return priceFontSize;
    }

    @Step("get Product CAMPAIGN PRICE COLOR")
    public String getProductCampaignPriceColor() {
        logger.info("get Product CAMPAIGN PRICE COLOR");
        String priceColor = driver.findElement(productCampaignPrice).getCssValue("color");
        return priceColor;
    }

    @Step("get Product CAMPAIGN BOLD PRICE")
    public String getProductCampaignBoldPrice() {
        logger.info("get Product CAMPAIGN BOLD PRICE");
        String priceBold = driver.findElement(productCampaignPrice).getTagName();
        return priceBold;
    }

    @Step("get Product CAMPAIGN PRICE FONT SIZE")
    public String getProductCampaignPriceFontSize() {
        logger.info("get Product CAMPAIGN PRICE FONT SIZE");
        String priceFontSize = driver.findElement(productCampaignPrice).getCssValue("font-size");
        return priceFontSize;
    }


}
