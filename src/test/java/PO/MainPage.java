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
    By userEmail = By.cssSelector("form[name='login_form'] input[name='email']");
    By userPassword = By.cssSelector("form[name='login_form'] input[name='password']");
    By btnUserLogin = By.cssSelector("form[name='login_form'] button[name='login']");
    By newProduct = By.xpath("//div[@id='box-latest-products']//div[contains(text(),'White Duck')]");
    By linkCategories = By.xpath("//div[@id='box-category-tree']//a[contains(text(),'Rubber Ducks')]");

    UserRegistrationPage userRegistrationPage = new UserRegistrationPage(driver);
    String userEmailGen = userRegistrationPage.newUser.email;

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

    @Step("login to User new Account")
    public MainPage loginToUserNewAccount() {
        logger.info("login to User new Account");
        driver.findElement(userEmail).sendKeys(userEmailGen);
        driver.findElement(userPassword).sendKeys(PropertyLoader.getProperty("userPassword"));
        driver.findElement(btnUserLogin).click();
        return this;
    }

    @Step("go to Admin Panel")
    public MainPage goToAdminPanel() {
        logger.info("go to Admin Panel");
        driver.get(PropertyLoader.getProperty("urlAdmin"));
        return this;
    }

    @Step("check that new Product added to Main Page")
    public boolean newProductAddedToMainPage() {
        try {
            driver.findElement(newProduct).isDisplayed();
            logger.info("new Product added to Main Page");
        } catch (Exception ex) {
            logger.error("new Product not added to Main Page");
            ex.printStackTrace();
            goToAdminPanel();
            return false;
        }
        return true;
    }

    @Step("check that new Product deleted from Main Page")
    public boolean newProductDeleteFromMainPage() {
        logger.info("check that new Product deleted from Main Page");
        boolean isContains = driver.getPageSource().contains("White Duck");
        if (isContains) {
            logger.error("new Product not deleted from Main Page");
            goToAdminPanel();
            return false;
        }
        return true;
    }

    @Step("go to Categories Page")
    public MainPage goToCategoriesPage() {
        logger.info("go to Categories Page");
        driver.findElement(linkCategories).click();
        return this;
    }


}
