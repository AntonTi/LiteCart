package test.java.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class AdminPanelTest extends BaseTest {

    @BeforeMethod(description = "login to Admin Panel")
    public void loginToAdmin() {
        adminPanel.loginAsAdmin();
    }

    @AfterMethod(description = "logout from Admin Panel")
    public void logoutFromAdmin() {
        adminPanel.logoutAsAdmin();
    }

    @Test(description = "debug Test for fail result")
    @Severity(SeverityLevel.TRIVIAL)
    public void testFail() {
        adminPanel.isShown();
        fail();
    }

    @Test(description = "check Admin Panel Title", invocationCount = 1)
    @Severity(SeverityLevel.NORMAL)
    public void checkAdminPanelTitle() {
        adminPanel.isShown();

        Assert.assertEquals(adminPanel.getTitle(), "My Store");
    }

    @Test(description = "check that all Left Menu Items including Sub-items contain a heading")
    @Severity(SeverityLevel.NORMAL)
    public void checkLeftMenuItemHeadings() {
        adminPanel.isShown();

        Assert.assertTrue(adminPanel.checkLeftMenuItemsHeading(),
                "one or more Left Menu Items or Sub-items don't contain a heading");
    }

    @Test(description = "check the sorting of Countries in the Left Menu")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkCountriesSorting() {
        adminPanel.isShown();
        adminPanel.goToItemCountries();

        Assert.assertTrue(adminPanel.checkCountriesSorting(),
                "Countries are not in alphabetical order");
    }


}
