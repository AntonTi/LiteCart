package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewProductPage extends BasePage {

    By btnDelete = By.cssSelector("span.button-set button[name='delete']");
    By message = By.cssSelector("div.notice.success");

    public NewProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("delete new Product")
    public NewProductPage deleteNewProduct() {
        logger.info("delete new Product");
        wait.until(ExpectedConditions.elementToBeClickable(btnDelete));
        driver.findElement(btnDelete).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return this;
    }

    @Step("get a message that the new Product has been deleted")
    public String getMessageSuccess() {
        logger.info("get a message that the new Product has been deleted");
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        String messageSuccess = driver.findElement(message).getText();
        return messageSuccess;
    }

}
