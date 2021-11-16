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

    @Test(description = "debug Test for fail result", enabled = false)
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

    @Test(description = "check the sorting of Countries in the Left Menu: 'Countries'")
    @Severity(SeverityLevel.NORMAL)
    public void checkCountriesSorting() {
        adminPanel.isShown();
        adminPanel.goToItemCountries();

        Assert.assertTrue(adminPanel.checkCountriesSorting(),
                "Countries are not in alphabetical order");
    }

    @Test(description = "check the sorting of Country Zones in the Left Menu: 'Countries'")
    @Severity(SeverityLevel.NORMAL)
    public void checkCountryZonesSorting() {
        adminPanel.isShown();
        adminPanel.goToItemCountries();

        Assert.assertTrue(adminPanel.checkCountryZonesSorting(),
                "Country Zones are not in alphabetical order");

    }

    @Test(description = "check the all Countries sorting of Geo Zones in the Left Menu: 'Geo Zones'")
    @Severity(SeverityLevel.NORMAL)
    public void checkCountryGeoZonesSorting() {
        adminPanel.isShown();
        adminPanel.goToItemGeoZones();

        Assert.assertTrue(adminPanel.checkCountryGeoZonesSorting(),
                "Country Geo Zones are not in alphabetical order");

    }

    @Test(description = "check adding a new Product")
    @Severity(SeverityLevel.CRITICAL)
    public void checkAddNewProduct() {
        adminPanel.isShown();
        adminPanel.goToItemCatalog();
        leftMenuCatalogPage.isShown();
        leftMenuCatalogPage.goToAddNewProduct();
        addNewProductPage.isShown();
        addNewProductPage.createNewProduct();
        addNewProductPage.fillOutProductForm();
        addNewProductPage.saveNewProduct();

        Assert.assertEquals(addNewProductPage.getMessageSuccess(), "Changes saved");

    }

    @Test(description = "check new Product was added and appeared in the Left Menu Item 'Catalog'",
            dependsOnMethods = {"checkAddNewProduct"})
    @Severity(SeverityLevel.CRITICAL)
    public void checkNewProductWasAdded() {
        adminPanel.isShown();
        adminPanel.goToItemCatalog();
        leftMenuCatalogPage.isShown();

        Assert.assertTrue(leftMenuCatalogPage.newProductWasAdded(),
                "new Product wasn't added and didn't appear in the left menu item 'Catalog'");

    }

    @Test(description = "check that a new Product has appeared on the Main Page",
            dependsOnMethods = {"checkNewProductWasAdded"})
    @Severity(SeverityLevel.CRITICAL)
    public void checkNewProductAppearance() {
        adminPanel.isShown();
        adminPanel.goToItemCatalog();
        leftMenuCatalogPage.isShown();
        leftMenuCatalogPage.enableNewProduct();

        Assert.assertTrue(mainPage.isShown().newProductHasAppeared(),
                "new Product hasn't appeared on the Main Page");

        mainPage.goToAdminPanel();
    }


}
