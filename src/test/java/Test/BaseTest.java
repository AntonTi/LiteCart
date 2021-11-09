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
    ProductPage productPage;
    UserRegistrationPage userRegistrationPage;
    UserPersonalArea userPersonalArea;

    @BeforeMethod(description = "Initialize custom driver and Page factory")
    public void init(ITestContext context) {
        driver = new ChromeDriver();
        context.setAttribute("WebDriver", driver);
        adminPanel = new AdminPanel(driver);
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        userRegistrationPage = new UserRegistrationPage(driver);
        userPersonalArea = new UserPersonalArea(driver);
    }

    @AfterMethod(description = "Finalize custom driver")
    public void close() {
        driver.quit();
    }

}
