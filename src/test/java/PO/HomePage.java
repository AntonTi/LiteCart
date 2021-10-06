package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.Utils.PropertyLoader;

public class HomePage extends BasePage {

    By btnLuck = By.xpath("//div[contains(@class, 'FPdoLc lJ9FBc')]//input[@name='btnI']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("open Home Page")
    public HomePage isShown() {
        logger.info("open Home Page");
        driver.get(PropertyLoader.getProperty("url"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnLuck));
        return this;
    }


}
