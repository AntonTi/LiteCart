package test.java.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.PO.*;

public class BaseTest {
    WebDriver driver;
    AdminPanel adminPanel;
    MainPage mainPage;
    CountriesPage countriesPage;
    ProductPage productPage;
    UserRegistrationPage userRegistrationPage;
    UserPersonalArea userPersonalArea;
    LeftMenuCatalogPage leftMenuCatalogPage;
    AddNewProductPage addNewProductPage;
    NewProductPage newProductPage;
    CategoriesPage categoriesPage;
    ShoppingCartPage shoppingCartPage;
    AddNewCountryPage addNewCountryPage;

    @BeforeMethod(description = "Initialize custom driver and Page factory")
    public void init(ITestContext context) {
        driver = new ChromeDriver();
        context.setAttribute("WebDriver", driver);
        adminPanel = new AdminPanel(driver);
        mainPage = new MainPage(driver);
        countriesPage = new CountriesPage(driver);
        productPage = new ProductPage(driver);
        userRegistrationPage = new UserRegistrationPage(driver);
        userPersonalArea = new UserPersonalArea(driver);
        leftMenuCatalogPage = new LeftMenuCatalogPage(driver);
        addNewProductPage = new AddNewProductPage(driver);
        newProductPage = new NewProductPage(driver);
        categoriesPage = new CategoriesPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        addNewCountryPage = new AddNewCountryPage(driver);
    }

    @AfterMethod(description = "Finalize custom driver")
    public void close() {
        driver.quit();
    }

}
