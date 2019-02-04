package com.briterp.tests.functional_test.catalog.pricelists;

import com.briterp.utilities.BrowserUtilities;
import com.briterp.utilities.Driver;
import com.briterp.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PricelistsTest extends TestBase {
    int itemsCount;

    @Test
    public void addAndDeleteItems() throws InterruptedException {
        extentLogger = report.createTest("Add and Delete Items in \"Pricelist Items\" field");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on \"Pricelists\" link under \"Catalog\"");
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
//        WebElement until = wait.until(ExpectedConditions.visibilityOf(pages.discussModulePage().pointOfSale));
//        BrowserUtilities.wait(3);
        BrowserUtilities.waitForPageToLoad(2);
        pages.pricelists().pricelistsLink.click();

        extentLogger.info("Click on any pricelist name");
        pages.pricelists().priceListNames.get(randomNumber(0, pages.pricelists().priceListNames.size() - 1)).click();

        extentLogger.info("Click on \"Edit\" button");
        pages.pricelistEditCreate().editButton.click();
        itemsCount = pages.createPricelistItems().deleteSigns.size();

        extentLogger.info("Go to \"PriceList Items\" field and click on \"Add an item\" link");
        pages.pricelistEditCreate().addAnItem2.click();

        extentLogger.info("Verify that \"Global\" and \"Fix Price\" is chosen by default on the radio buttons");
        Assert.assertTrue(pages.createPricelistItems().globalRadioBtn.isSelected());
        Assert.assertTrue(pages.createPricelistItems().fixPriceRadioBtn.isSelected());

        extentLogger.info("Randomly click on a different radio button on both parts and fill the required fields");
        int randomNumber = randomNumber(0, pages.createPricelistItems().ApplyOnButtons.size() - 1);
        if (randomNumber > 0) {
            pages.createPricelistItems().ApplyOnButtons.get(randomNumber).click();
            pages.createPricelistItems().productBox.get(randomNumber - 1).click();
            pages.createPricelistItems().productItems.get(randomNumber(0, pages.createPricelistItems().productItems.size() - 1)).click();
        } else {
            pages.createPricelistItems().ApplyOnButtons.get(randomNumber).click();
        }
        pages.createPricelistItems().computePriceButtons.get(randomNumber(0, pages.createPricelistItems().computePriceButtons.size() - 1)).click();
        pages.createPricelistItems().minQuantityBox.clear();
        pages.createPricelistItems().minQuantityBox.sendKeys("" + randomNumber(0, 10));

        extentLogger.info("Click on \"Save & Close\" button");
        pages.createPricelistItems().saveAndClose.click();

        extentLogger.info("Verify that item count is increased by 1");
        BrowserUtilities.wait(2);
        itemsCount = pages.createPricelistItems().deleteSigns.size();

        extentLogger.info("Click on trash can sign ");
        pages.createPricelistItems().deleteSigns.get(pages.createPricelistItems().deleteSigns.size() - 1).click();

        extentLogger.info("Verify that the item count is decreased by one");
        BrowserUtilities.wait(2);
        Assert.assertEquals(pages.createPricelistItems().deleteSigns.size(), itemsCount - 1);
    }

    @Test
    public void addAndDeleteItems()  {
        extentLogger = report.createTest("Add and Delete Items in \"Pricelist Items\" field");
        extentLogger.info("Login");
}
