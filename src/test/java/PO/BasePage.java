package test.java.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

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


    // HELPER METHODS

    public BasePage checkCheckBox(By selector) {
        wait.until(ExpectedConditions.elementToBeClickable(selector));
        WebElement checkBox = driver.findElement(selector);
        if (checkBox.getAttribute("checked") == null) {
            checkBox.click();
        }
        return this;
    }

    public BasePage uncheckCheckBox(By selector) {
        wait.until(ExpectedConditions.elementToBeClickable(selector));
        WebElement checkBox = driver.findElement(selector);
        if (checkBox.getAttribute("checked") != null) {
            checkBox.click();
        }
        return this;
    }

    public BasePage fillInField(By selector, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(selector));
        driver.findElement(selector).clear();
        driver.findElement(selector).sendKeys(value);
        return this;
    }

    public BasePage selectFromDropDownList(By selector, String value) {
        Select select = new Select(driver.findElement(selector));
        select.selectByVisibleText(value);
        return this;
    }

    public static ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }


}
