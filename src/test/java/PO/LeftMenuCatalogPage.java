package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftMenuCatalogPage extends BasePage {

    By footerCatalog = By.cssSelector("form[name='catalog_form'] ul.list-horizontal");
    By btnAddNewProduct = By.xpath("//td[@id='content']//a[contains(text(),'Add New Product')]");
    By catalogRubberDucks = By.xpath("//form[@name='catalog_form']//a[contains(text(),'Rubber Ducks')]");
    By newProduct = By.xpath("//form[@name='catalog_form']//a[contains(text(),'White Duck')]");
    By btnEnable = By.cssSelector("form[name='catalog_form'] button[name='enable']");
    By checkBoxNewProduct = By.cssSelector("tr.row.semi-transparent input[type='checkbox']");


    public LeftMenuCatalogPage(WebDriver driver) {
        super(driver);
    }

    @Step("Left Menu Item 'Catalog' Page is shown")
    public LeftMenuCatalogPage isShown() {
        logger.info("Left Menu Item 'Catalog' Page is shown");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerCatalog));
        return this;
    }

    @Step("go to Add New Product Page")
    public LeftMenuCatalogPage goToAddNewProduct() {
        logger.info("go to Add New Product Page");
        driver.findElement(btnAddNewProduct).click();
        return this;
    }

    @Step("check new Product added in the Left Menu Item 'Catalog'")
    public boolean newProductAddedToCatalog() {
        driver.findElement(catalogRubberDucks).click();
        try {
            driver.findElement(newProduct).isDisplayed();
            logger.info("new Product added in the Left Menu Item 'Catalog'");
        } catch (Exception ex) {
            logger.error("new Product not added in the left menu item 'Catalog'");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Step("enable new Product")
    public LeftMenuCatalogPage enableNewProduct() {
        logger.info("enable new Product");
        driver.findElement(catalogRubberDucks).click();
        checkCheckBox(checkBoxNewProduct);
        driver.findElement(btnEnable).click();
        return this;
    }

    @Step("go to New Product Page")
    public LeftMenuCatalogPage goToNewProductPage() {
        logger.info("go to New Product Page");
        driver.findElement(catalogRubberDucks).click();
        driver.findElement(newProduct).click();
        return this;
    }

    @Step("check new Product deleted from the Left Menu Item 'Catalog'")
    public boolean newProductWasRemoved() {
        logger.info("check new Product deleted from the Left Menu Item 'Catalog'");
        driver.findElement(catalogRubberDucks).click();
        boolean isContains = driver.getPageSource().contains("White Duck");
        if (isContains) {
            logger.error("new Product not deleted from the Left Menu Item 'Catalog'");
            return false;
        }
        return true;
    }


}
