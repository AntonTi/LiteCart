package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.Utils.PropertyLoader;

public class MainPage extends BasePage {

    By footer = By.cssSelector("footer#footer");

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


}
