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

import static java.lang.Integer.parseInt;

public class AdminPanel extends BasePage {

    By inputUserName = By.xpath("//form[@name='login_form']//input[@name='username']");
    By inputPassword = By.xpath("//form[@name='login_form']//input[@name='password']");
    By btnLogin = By.xpath("//div[@id='box-login']//button[@name='login']");
    By btnLogout = By.xpath("//div[@class='header']//a[@title='Logout']");
    By leftMenuItem = By.xpath("//ul[@id='box-apps-menu']//li[@id='app-']");
    By leftSubMenuItem = By.cssSelector("div#box-apps-menu-wrapper li[id^='doc-']");
    By leftMenuItemCatalog = By.xpath("//ul[@id='box-apps-menu']//span[contains(text(),'Catalog')]");
    By leftMenuItemCountries = By.xpath("//ul[@id='box-apps-menu']//span[contains(text(),'Countries')]");
    By leftMenuItemGeoZones = By.xpath("//ul[@id='box-apps-menu']//span[contains(text(),'Geo Zones')]");
    By footerCountries = By.cssSelector("form[name='countries_form'] tr.footer");
    By footerGeoZones = By.cssSelector("table.dataTable tr.footer");
    By countryName = By.xpath("//table[@class='dataTable']//td[5]//a");
    By countryNameGeoZones = By.xpath("//table[@class='dataTable']//td[3]//a");
    By countryZoneCount = By.xpath("//table[@class='dataTable']//td[6]");
    By countryZoneName = By.cssSelector("[name$='][name]']");
    By countryGeoZoneName = By.xpath("//table[@class='dataTable']//td[3]//option[@selected]");
    By btnSet = By.xpath("//span[@class='button-set']");


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
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin));
        return this;
    }

    @Step("Admin Panel is shown")
    public AdminPanel isShown() {
        logger.info("Admin Panel is shown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogout));
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

    @Step("go to Left Menu Item 'Catalog'")
    public AdminPanel goToItemCatalog() {
        logger.info("go to Left Menu Item 'Catalog'");
        driver.findElement(leftMenuItemCatalog).click();
        return this;
    }

    @Step("go to Left Menu Item 'Countries'")
    public AdminPanel goToItemCountries() {
        logger.info("go to Left Menu Item 'Countries'");
        driver.findElement(leftMenuItemCountries).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerCountries));
        return this;
    }

    @Step("go to Left Menu Item 'Geo Zones'")
    public AdminPanel goToItemGeoZones() {
        logger.info("go to Left Menu Item 'Geo Zones'");
        driver.findElement(leftMenuItemGeoZones).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerGeoZones));
        return this;
    }

    @Step("check that Countries are in alphabetical order")
    public boolean checkCountriesSorting() {
        logger.info("check that Countries are in alphabetical order");
        List<WebElement> countryNamesEl = driver.findElements(countryName);
        List<String> countryNames = new ArrayList<>();
        for (WebElement el : countryNamesEl) {
            //System.out.println(el.getText());
            countryNames.add(el.getText());
        }
        List<String> countryNamesSort = new ArrayList<>(countryNames);
        Collections.sort(countryNamesSort);
        //countryNames.set(0, "afghanistan");
        //System.out.println(countryNamesSort.equals(countryNames));
        if (!countryNamesSort.equals(countryNames)) {
            logger.error("Countries are not in alphabetical order");
            return false;
        }
        return true;
    }

    @Step("check that Country Zones are in alphabetical order")
    public boolean checkCountryZonesSorting() {
        logger.info("check that Country Zones are in alphabetical order");
        List<WebElement> countryNames = driver.findElements(countryName);
        for (int i = 0; i < countryNames.size(); i++) {
            List<WebElement> countryZoneCountList = driver.findElements(countryZoneCount);
            if (parseInt((countryZoneCountList.get(i)).getText()) > 0) {
                countryNames = driver.findElements(countryName);
                (countryNames.get(i)).click();
                //Thread.sleep(2000);
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnSet));
                List<WebElement> countryZoneNameList = driver.findElements(countryZoneName);
                List<String> countryZoneNameStr = new ArrayList<>();
                for (WebElement el : countryZoneNameList) {
                    countryZoneNameStr.add(el.getAttribute("value"));
                }
                List<String> countryZoneNameSort = new ArrayList<>(countryZoneNameStr);
                Collections.sort(countryZoneNameSort);
                //Collections.reverse(countryZoneNameSort);
                //countryZoneNameStr.set(0, "Alberta");
                if (!countryZoneNameSort.equals(countryZoneNameStr)) {
                    logger.error("Country Zones are not in alphabetical order");
                    return false;
                }
                driver.navigate().back();
            }
        }
        return true;
    }

    @Step("check that all Countries Geo Zones are in alphabetical order")
    public boolean checkCountryGeoZonesSorting() {
        logger.info("check that all Countries Geo Zones are in alphabetical order");
        List<WebElement> countryNameEl = driver.findElements(countryNameGeoZones);
        for (int i = 0; i < countryNameEl.size(); i++) {
            countryNameEl = driver.findElements(countryNameGeoZones);
            countryNameEl.get(i).click();
            //Thread.sleep(2000);
            List<WebElement> countryGeoZoneNameEl = driver.findElements(countryGeoZoneName);
            List<String> countryGeoZoneName = new ArrayList<>();
            for (WebElement el : countryGeoZoneNameEl) {
                countryGeoZoneName.add(el.getText());
            }
            List<String> countryGeoZoneNameSort = new ArrayList<>(countryGeoZoneName);
            Collections.sort(countryGeoZoneNameSort);
            //countryGeoZoneName.set(0, "Alberta");
            if (!countryGeoZoneNameSort.equals(countryGeoZoneName)) {
                logger.error("Country Geo Zones are not in alphabetical order");
                return false;
            }
            driver.navigate().back();
        }
        return true;
    }


}
