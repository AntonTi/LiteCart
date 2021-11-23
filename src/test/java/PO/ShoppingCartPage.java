package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {

    By btnConfirmOrder = By.cssSelector("form[name='order_form'] button[name='confirm_order']");
    By btnRemove = By.cssSelector("form[name='cart_form'] [name='remove_cart_item']");
    By productName = By.cssSelector("form[name='cart_form'] a strong");
    By messageSuccess = By.cssSelector("div#checkout-cart-wrapper p");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Shopping Cart Page is shown")
    public ShoppingCartPage isShown() {
        logger.info("Shopping Cart Page is shown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnConfirmOrder));
        return this;
    }

    @Step("remove Products from Shopping Cart")
    public ShoppingCartPage removeProductsFromCart() {
        logger.info("remove Products from Shopping Cart");
        while (driver.findElements(btnRemove).size() != 0) {
            String name = wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
            wait.until(ExpectedConditions.elementToBeClickable(btnRemove));
            WebElement btnRemoveProduct = driver.findElement(btnRemove);
            btnRemoveProduct.click();
            wait.until(ExpectedConditions.stalenessOf(btnRemoveProduct));
            logger.info("Product '" + name + "' " + "has been removed from Shopping Cart");
        }
        return this;
    }

    @Step("get a message that Shopping Cart is empty")
    public String getMessageIsEmpty() {
        logger.info("get message that Shopping Cart is empty");
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(messageSuccess)).getText();
        return message;
    }


}
