package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    By productName = By.cssSelector("#box-product h1");
    By productRegularPrice = By.cssSelector("#box-product .regular-price");


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        String name = driver.findElement(productName).getText();
        return name;
    }

    public String getProductRegularPrice() {
        String name = driver.findElement(productRegularPrice).getText();
        return name;
    }


}
