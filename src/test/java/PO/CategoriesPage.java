package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class CategoriesPage extends BasePage {

    By footer = By.cssSelector("#footer");
    By btnAddToCart = By.cssSelector("form[name='buy_now_form'] button[name='add_cart_product']");
    By quantity = By.cssSelector("div#cart span.quantity");
    By linkCart = By.xpath("//div[@id='cart']//a[contains(text(),'Checkout')]");


    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Categories Page is shown")
    public CategoriesPage isShown() {
        logger.info("Categories Page is shown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(footer));
        return this;
    }

    @Step("add Products to Shopping Cart")
    public CategoriesPage addProductsToCart() {
        logger.info("add Products to Shopping Cart");
        List<String> productsToBuy = Arrays.asList("Purple Duck", "Green Duck", "Blue Duck");
        for (int i = 0; i < productsToBuy.size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.link[title='" + productsToBuy.get(i) + "']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(quantity, "" + (i + 1)));
            logger.info("added product '" + productsToBuy.get(i) + "' to shopping cart");
            logger.info("go back to Categories Page");
            driver.navigate().back();
        }
        return this;
    }

    @Step("go to Shopping Cart")
    public CategoriesPage goToShoppingCart() {
        logger.info("go to Shopping Cart");
        wait.until(ExpectedConditions.elementToBeClickable(linkCart)).click();
        return this;
    }


}
