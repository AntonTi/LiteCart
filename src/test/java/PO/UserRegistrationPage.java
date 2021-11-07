package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.Utils.PropertyLoader;

public class UserRegistrationPage extends BasePage {

    By footer = By.cssSelector("#footer");
    By firstName = By.cssSelector("div#create-account [name='firstname']");
    By lastName = By.cssSelector("div#create-account [name='lastname']");
    By address1 = By.cssSelector("div#create-account [name='address1']");
    By postcode = By.cssSelector("div#create-account [name='postcode']");
    By city = By.cssSelector("div#create-account [name='city']");
    By email = By.cssSelector("div#create-account [name='email']");
    By phone = By.cssSelector("div#create-account [name='phone']");
    By password = By.cssSelector("div#create-account [name='password']");
    By passwordConf = By.cssSelector("div#create-account [name='confirmed_password']");
    By captcha = By.xpath("//input[@name='captcha']");
    By btnCreateAccount = By.cssSelector("[name='create_account']");
    By message = By.cssSelector("div.notice.success");
    String emailGenerator = System.currentTimeMillis() / 1000L + "test@mail.com";

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("User Registration Page is shown")
    public UserRegistrationPage isShown() {
        logger.info("User Registration Page is shown");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
        return this;
    }

    @Step("fill in User Registration Form")
    public UserRegistrationPage fillInRegistrationForm() {
        logger.info("fill in User Registration Form");
        driver.findElement(firstName).sendKeys(PropertyLoader.getProperty("userFirstName"));
        driver.findElement(lastName).sendKeys(PropertyLoader.getProperty("userLastName"));
        driver.findElement(address1).sendKeys(PropertyLoader.getProperty("userAddress1"));
        driver.findElement(postcode).sendKeys(PropertyLoader.getProperty("userPostcode"));
        driver.findElement(city).sendKeys(PropertyLoader.getProperty("userCity"));
        driver.findElement(email).sendKeys(emailGenerator);
        driver.findElement(phone).sendKeys(PropertyLoader.getProperty("userPhone"));
        driver.findElement(password).sendKeys(PropertyLoader.getProperty("userPassword"));
        driver.findElement(passwordConf).sendKeys(PropertyLoader.getProperty("userPassword"));
        driver.findElement(captcha).click();
        WebDriverWait waitForCaptcha = new WebDriverWait(driver, 20);
        //Wait until text box has value equal 4 characters (Captcha has 4 characters)
        waitForCaptcha.until((ExpectedCondition<Boolean>) driver ->
                (driver.findElement(captcha).getAttribute("value").length() == 4));
        return this;
    }

    @Step("send User Registration Form")
    public UserRegistrationPage sendRegistrationForm() {
        logger.info("send User Registration Form");
        driver.findElement(btnCreateAccount).click();
        return this;
    }

    @Step("get a message about successful registration")
    public String getMessageSuccessRegistration() {
        logger.info("get a message about successful registration");
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        String regMessage = driver.findElement(message).getText();
        return regMessage;
    }


}
