package test.java.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class MainTest extends BaseMainTest {

    @Test(description = "check HomePage Title")
    @Severity(SeverityLevel.NORMAL)
    public void checkHomePageTitle() {
        homePage.isShown();

        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test(description = "debug Test for fail result")
    @Severity(SeverityLevel.TRIVIAL)
    public void testFail() {
        homePage.isShown();
        fail();
    }
}
