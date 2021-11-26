package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class AddNewCountryPage extends BasePage {

    By btnDelete = By.cssSelector("span.button-set button[name='delete']");
    By linkToNewWindow = By.cssSelector("a i.fa.fa-external-link");

    String originalWindow;
    Set<String> existingWindows;

    public AddNewCountryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add New Country Page is shown")
    public AddNewCountryPage isShown() {
        logger.info("Add New Country Page is shown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDelete));
        return this;
    }

    @Step("check Links open in a New Window")
    public boolean checkLinksOpenInNewWindow() {
        logger.info("check Links open in a New Window");
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(linkToNewWindow));
            List<WebElement> linksToNewWindow = driver.findElements(linkToNewWindow);
            for (WebElement el : linksToNewWindow) {
                originalWindow = driver.getWindowHandle();
                existingWindows = driver.getWindowHandles();
                wait.until(ExpectedConditions.elementToBeClickable(linkToNewWindow));
                el.click();
                String newWindow = wait.until(BasePage.anyWindowOtherThan(existingWindows));
                driver.switchTo().window(newWindow);
                driver.close();
                driver.switchTo().window(originalWindow);
            }
            return true;
        } catch (Exception ex) {
            logger.error("one or more links don't open in a New Window");
            return false;
        }
    }


}
