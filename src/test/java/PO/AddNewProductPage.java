package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.Models.Product;

import java.io.File;

public class AddNewProductPage extends BasePage {

    By btnSave = By.xpath("//form//button[@name='save']");
    By name = By.cssSelector("div#tab-general input[name='name[en]']");
    By code = By.cssSelector("div#tab-general input[name='code']");
    By categoriesRoot = By.cssSelector("div#tab-general [data-name='Root']");
    By categoriesDucks = By.cssSelector("div#tab-general [data-name='Rubber Ducks']");
    By quantity = By.cssSelector("div#tab-general input[name='quantity']");
    By uploadImages = By.cssSelector("div#tab-general input[name='new_images[]']");
    By tabInformation = By.xpath("//form//a[contains(text(),'Information')]");
    By manufacturer = By.cssSelector("div#tab-information select[name='manufacturer_id']");
    By shortDescription = By.cssSelector("div#tab-information input[name='short_description[en]']");
    By description = By.cssSelector("div#tab-information textarea[name='description[en]']");
    By headTitle = By.cssSelector("div#tab-information input[name='head_title[en]']");
    By tabPrices = By.xpath("//form//a[contains(text(),'Prices')]");
    By price = By.cssSelector("div#tab-prices input[name='prices[USD]']");
    By message = By.cssSelector("div.notice.success");

    Product whiteDuck;
    String productName = "White Duck";
    String productCode = "rd006";
    int productQuantity = 50;
    String productPictureUrl = "src/test/resources/white_duck.png";
    String productShortDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Suspendisse sollicitudin ante massa, eget ornare libero porta congue.";
    String productDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Suspendisse sollicitudin ante massa, eget ornare libero porta congue. " +
            "Cras scelerisque dui non consequat sollicitudin. Sed pretium tortor ac auctor molestie. " +
            "Nulla facilisi. Maecenas pulvinar nibh vitae lectus vehicula semper. Donec et aliquet velit. " +
            "Curabitur non ullamcorper mauris. In hac habitasse platea dictumst. " +
            "Phasellus ut pretium justo, sit amet bibendum urna. Maecenas sit amet arcu pulvinar, " +
            "facilisis quam at, viverra nisi. Morbi sit amet adipiscing ante. " +
            "Integer imperdiet volutpat ante, sed venenatis urna volutpat a. " +
            "Proin justo massa, convallis vitae consectetur sit amet, facilisis id libero.";
    String productHeadTitle = "White Duck Product";
    double productPurchasePrice = 25.00;


    public AddNewProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add New Product Page is shown")
    public AddNewProductPage isShown() {
        logger.info("Add New Product Page is shown");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnSave));
        return this;
    }

    @Step("create New Product 'White Duck'")
    public AddNewProductPage createNewProduct() {
        logger.info("create New Product 'White Duck'");
        String pathToPicFile = new File(productPictureUrl).getAbsolutePath();
        whiteDuck = new Product(productName, productCode, productQuantity, pathToPicFile,
                productShortDescription, productDescription, productHeadTitle, productPurchasePrice);
        return this;
    }

    @Step("fill out Product Form")
    public AddNewProductPage fillOutProductForm() {
        logger.info("fill out Product Form");

        wait.until(ExpectedConditions.elementToBeClickable(uploadImages));
        logger.info("fill out Product Form ('General' tab is shown)");
        fillInField(name, whiteDuck.name);
        fillInField(code, whiteDuck.code);
        uncheckCheckBox(categoriesRoot);
        checkCheckBox(categoriesDucks);
        fillInField(quantity, whiteDuck.quantity);
        fillInField(uploadImages, whiteDuck.pictureUrl);

        driver.findElement(tabInformation).click();
        wait.until(ExpectedConditions.elementToBeClickable(headTitle));
        logger.info("fill out Product Form ('Information' tab is shown)");
        selectFromDropDownList(manufacturer, "ACME Corp.");
        fillInField(shortDescription, whiteDuck.shortDescription);
        driver.findElement(description).sendKeys(whiteDuck.description);
        fillInField(headTitle, whiteDuck.headTitle);

        driver.findElement(tabPrices).click();
        wait.until(ExpectedConditions.elementToBeClickable(price));
        logger.info("fill out Product Form ('Prices' tab is shown)");
        fillInField(price, whiteDuck.price);
        return this;
    }

    @Step("save New Product")
    public AddNewProductPage saveNewProduct() {
        logger.info("save New Product");
        wait.until(ExpectedConditions.elementToBeClickable(btnSave));
        driver.findElement(btnSave).click();
        return this;
    }

    @Step("get a message about the successful Product creation")
    public String getMessageSuccess() {
        logger.info("get a message about the successful Product creation");
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        String messageSuccess = driver.findElement(message).getText();
        return messageSuccess;
    }


}
