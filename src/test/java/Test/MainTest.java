package test.java.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class MainTest extends BaseMainTest {

    @BeforeMethod(description = "login to Admin Panel")
    public void logInToAdmin() {
        adminPanel.logIn();
    }

    @Test(description = "check AdminPanel Title")
    @Severity(SeverityLevel.NORMAL)
    public void checkAdminPanelTitle() {
        adminPanel.isShown();

        Assert.assertEquals(adminPanel.getTitle(), "My Store");
    }

    @Test(description = "debug Test for fail result")
    @Severity(SeverityLevel.TRIVIAL)
    public void testFail() {
        adminPanel.isShown();
        fail();
    }
}
