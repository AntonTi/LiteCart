package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftMenuCatalogPage extends BasePage {

    By footerCatalog = By.cssSelector("form[name='catalog_form'] ul.list-horizontal");
    By btnAddNewProduct = By.xpath("//td[@id='content']//a[contains(text(),'Add New Product')]");

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


}
