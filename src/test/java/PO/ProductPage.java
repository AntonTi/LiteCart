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


}
