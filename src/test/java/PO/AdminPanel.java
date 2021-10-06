package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.Utils.PropertyLoader;

public class AdminPanel extends BasePage {

    By inputUserName = By.xpath("//form[@name='login_form']//input[@name='username']");
    By inputPassword = By.xpath("//form[@name='login_form']//input[@name='password']");
    By btnLogin = By.xpath("//div[@id='box-login']//button[@name='login']");
    By btnLogout = By.xpath("//div[@class='header']//a[@title='Logout']");

    public AdminPanel(WebDriver driver) {
        super(driver);
    }

    @Step("Login to Admin Panel")
    public AdminPanel logIn() {
        logger.info("Login to Admin Panel");
        driver.get(PropertyLoader.getProperty("url"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnLogin));
        driver.findElement(inputUserName).sendKeys("admin");
        driver.findElement(inputPassword).sendKeys("123");
        driver.findElement(btnLogin).click();
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


}
