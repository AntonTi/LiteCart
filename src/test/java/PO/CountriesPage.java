package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CountriesPage extends BasePage {

    By btnDisable = By.cssSelector("form[name='countries_form'] button[name='disable']");
    By btnAddNewCountryPage = By.xpath("//td[@id='content']//a[contains(text(),' Add New Country')]");

    public CountriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Countries Page is shown")
    public CountriesPage isShown() {
        logger.info("Countries Page is shown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDisable));
        return this;
    }

    @Step("go to 'Add New Country Page'")
    public CountriesPage goToAddNewCountryPage() {
        logger.info("go to 'Add New Country Page'");
        wait.until(ExpectedConditions.elementToBeClickable(btnAddNewCountryPage)).click();
        return this;
    }


}
