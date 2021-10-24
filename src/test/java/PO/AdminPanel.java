package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.Utils.PropertyLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminPanel extends BasePage {

    By inputUserName = By.xpath("//form[@name='login_form']//input[@name='username']");
    By inputPassword = By.xpath("//form[@name='login_form']//input[@name='password']");
    By btnLogin = By.xpath("//div[@id='box-login']//button[@name='login']");
    By btnLogout = By.xpath("//div[@class='header']//a[@title='Logout']");
    By leftMenuItem = By.xpath("//ul[@id='box-apps-menu']//li[@id='app-']");
    By leftSubMenuItem = By.cssSelector("div#box-apps-menu-wrapper li[id^='doc-']");
    By leftMenuItemCountries = By.xpath("//ul[@id='box-apps-menu']//span[contains(text(),'Countries')]");
    By footerCountries = By.cssSelector("form[name='countries_form'] tr.footer");
    By countryName = By.xpath("//table[@class='dataTable']//td[5]");

    public AdminPanel(WebDriver driver) {
        super(driver);
    }

    @Step("login to Admin Panel")
    public AdminPanel loginAsAdmin() {
        logger.info("Login to Admin Panel");
        driver.get(PropertyLoader.getProperty("urlAdmin"));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        driver.findElement(inputUserName).sendKeys(PropertyLoader.getProperty("adminUsername"));
        driver.findElement(inputPassword).sendKeys(PropertyLoader.getProperty("adminPassword"));
        driver.findElement(btnLogin).click();
        return this;
    }

    @Step("logout from Admin Panel")
    public AdminPanel logoutAsAdmin() {
        logger.info("Logout from Admin Panel");
        driver.findElement(btnLogout).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnLogin)));
        return this;
    }

    @Step("open Admin Panel")
    public AdminPanel isShown() {
        logger.info("open Admin Panel");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnLogout));
        return this;
    }

    @Step("get Admin Panel Title")
    public String getTitle() {
        logger.info("get Admin Panel Title");
        String title = driver.getTitle();
        return title;
    }

    @Step("check that all Left Menu Items including Sub-items contain a heading")
    public boolean checkLeftMenuItemsHeading() {
        logger.info("check that all Left Menu Items including Sub-items contain a heading");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(leftMenuItem));
        List<WebElement> leftMenuItems = driver.findElements(leftMenuItem);
        for (int i = 0; i < leftMenuItems.size(); i++) {
            List<WebElement> leftSubMenuItems = driver.findElements(leftSubMenuItem);
            for (int j = 0; j < leftSubMenuItems.size(); j++) {
                leftSubMenuItems = driver.findElements(leftSubMenuItem);
                //Thread.sleep(1000);
                leftSubMenuItems.get(j).click();
                if (!driver.findElement(By.tagName("h1")).isDisplayed()) {
                    logger.error("one or more Left Menu Sub-items don't contain a heading");
                    return false;
                }
            }
            leftMenuItems = driver.findElements(leftMenuItem);
            //Thread.sleep(1000);
            leftMenuItems.get(i).click();
            if (!driver.findElement(By.tagName("h1")).isDisplayed()) {
                logger.error("one or more Left Menu Items don't contain a heading");
                return false;
            }
        }
        return true;
    }

    @Step("go to Left Menu Item 'Countries'")
    public AdminPanel goToItemCountries() {
        logger.info("go to Left Menu Item 'Countries'");
        driver.findElement(leftMenuItemCountries).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerCountries));
        return this;
    }

    @Step("check that Countries are in alphabetical order")
    public boolean checkCountriesSorting() {
        logger.info("check that Countries are in alphabetical order");
        List<WebElement> countryNamesEl = driver.findElements(countryName);
        List<String> countryNames = new ArrayList<String>();
        for (WebElement el : countryNamesEl) {
            //System.out.println(el.getText());
            countryNames.add(el.getText());
        }
        List<String> countryNamesSort = new ArrayList<String>(countryNames);
        Collections.sort(countryNamesSort);
        //countryNames.set(0, "afghanistan");
        //System.out.println(countryNamesSort.equals(countryNames));
        if (!countryNamesSort.equals(countryNames)) {
            logger.error("Countries are not in alphabetical order");
            return false;
        }
        return true;
    }


}
