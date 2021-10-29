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

    public String getProductNameCampaigns() {
        String name = driver.findElement(productNameCampaigns).getText();
        return name;
    }

    public String getProductRegularPriceCampaigns() {
        String name = driver.findElement(productRegularPriceCampaigns).getText();
        return name;
    }


}
