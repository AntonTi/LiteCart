package test.java.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger = LogManager.getLogger(this.getClass());
    protected Logger loggerForBase = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        loggerForBase.info("Initialize waiter for " + this.getClass());
        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

}
