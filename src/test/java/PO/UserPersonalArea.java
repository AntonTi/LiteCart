package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserPersonalArea extends BasePage {

    By footer = By.cssSelector("#footer");
    By btnLogout = By.xpath("//aside[@id='navigation']//a[contains(text(),'Logout')]");
    By message = By.cssSelector("div.notice.success");

    public UserPersonalArea(WebDriver driver) {
        super(driver);
    }

    @Step("User Personal Area is shown")
    public UserPersonalArea isShown() {
        logger.info("User Personal Area is shown");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
        return this;
    }

    @Step("logout of User Personal Area")
    public UserPersonalArea logoutAsUser() {
        logger.info("logout of User Personal Area");
        driver.findElement(btnLogout).click();
        return this;
    }

    @Step("get a message about successful Login")
    public String getMessageSuccessLogin() {
        logger.info("get a message about successful Login");
        String messageSuccessLogin = driver.findElement(message).getText();
        return messageSuccessLogin;
    }

    @Step("get a message about successful Logout")
    public String getMessageSuccessLogout() {
        logger.info("get a message about successful Logout");
        String messageSuccessLogout = driver.findElement(message).getText();
        return messageSuccessLogout;
    }


}
