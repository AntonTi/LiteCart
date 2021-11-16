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

    @Step("check new Product was added and appeared in the Left Menu Item 'Catalog'")
    public boolean newProductWasAdded() {
        driver.findElement(catalogRubberDucks).click();
        try {
            driver.findElement(newProduct).isDisplayed();
            logger.info("new Product was added and appeared in the Left Menu Item 'Catalog'");
        } catch (Exception ex) {
            logger.error("new Product wasn't added and didn't appear in the left menu item 'Catalog'");
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


}
