package com.briterp.tests.functional_test.catalog.pricelists;

import com.briterp.utilities.BrowserUtilities;
import com.briterp.utilities.ConfigurationReader;
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
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on \"Pricelists\" link under \"Catalog\"");
        BrowserUtilities.wait(5);
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
    public void PricelistName() {
        extentLogger = report.createTest("Changing Pricelist Name Test");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(5);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on \"Pricelists\" link under \"Catalog\"");
        BrowserUtilities.waitForPageToLoad(2);
        pages.pricelists().pricelistsLink.click();

        extentLogger.info("Click on any pricelist name");
        pages.pricelists().priceListNames.get(randomNumber(0, pages.pricelists().priceListNames.size() - 1)).click();

        extentLogger.info("Click on \"Edit\" button");
        pages.pricelistEditCreate().editButton.click();

        extentLogger.info(" Change the name of the price list");
        pages.pricelistEditCreate().pricelistName.clear();
        pages.pricelistEditCreate().pricelistName.sendKeys(ConfigurationReader.getProperty("pricelistName"));

        extentLogger.info(" Click on \"Save\" button");
        pages.pricelistEditCreate().save.click();

        extentLogger.info("Verify if pricelist name after saving it is matching with the one user put.");
        Assert.assertEquals(pages.pricelistEditCreate().savedPricelistName.getText(), ConfigurationReader.getProperty("pricelistName"));

        extentLogger.info(" Click on \"Pricelists\" link");
        pages.pricelists().pricelistsLink.click();
        BrowserUtilities.wait(2);

        extentLogger.info("Verify that pricelist name table includes updated name ");
        String updatedName = "";
        for (int i = 0; i < pages.pricelists().priceListNames.size(); i++) {
            if (pages.pricelists().priceListNames.get(i).getText().equals(ConfigurationReader.getProperty("pricelistName"))) {
                updatedName = pages.pricelists().priceListNames.get(i).getText();
                break;
            }
        }
        Assert.assertEquals(updatedName, ConfigurationReader.getProperty("pricelistName"));
    }

    @Test
    public void discardEditing() {
        extentLogger = report.createTest("Discarding the editied Item Info Test");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(5);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on \"Pricelists\" link under \"Catalog\"");
        BrowserUtilities.waitForPageToLoad(2);
        pages.pricelists().pricelistsLink.click();

        extentLogger.info("Click on any pricelist name");
        pages.pricelists().priceListNames.get(randomNumber(0, pages.pricelists().priceListNames.size() - 1)).click();

        extentLogger.info("Click on \"Edit\" button");
        pages.pricelistEditCreate().editButton.click();

        extentLogger.info("Type a code into \"E-commerce Promotional Code\" field and click on discard button");

        extentLogger.info("Click on \"discard\" button.");

        extentLogger.info("Verify that previous info did not change for the Pricelist item");


    }
}
