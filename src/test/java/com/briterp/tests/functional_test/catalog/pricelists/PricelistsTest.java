package com.briterp.tests.functional_test.catalog.pricelists;

import com.briterp.utilities.TestBase;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PricelistsTest extends TestBase {
    @Test
    public void addAndDeleteItems() throws InterruptedException {
        extentLogger = report.createTest("Add and Delete Items in \"Pricelist Items\" field");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on \"Pricelists\" link under \"Catalog\"");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        pages.pricelists().pricelistsLink.click();

        extentLogger.info("Click on any pricelist name");
        pages.pricelists().priceListNames.get(randomNumber(0,pages.pricelists().priceListNames.size()-1)).click();

        extentLogger.info("Click on \"Edit\" button");

        extentLogger.info("Go to \"PriceList Items\" field and click on \"Add an item\" link");

        extentLogger.info("Verify that \"Global\" and \"Fix Price\" is chosen by default on the radio buttons");

        extentLogger.info("Randomly click on a different radio button and fill the required fields");

        extentLogger.info("Click on \"Save & Close\" button");

        extentLogger.info("Click on trash can sign ");

        extentLogger.info("Verify that the item is not displayed on the list anymore");
    }
}
