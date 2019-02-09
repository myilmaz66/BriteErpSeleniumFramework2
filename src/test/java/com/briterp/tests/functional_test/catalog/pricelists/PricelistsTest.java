package com.briterp.tests.functional_test.catalog.pricelists;

import com.briterp.utilities.BrowserUtilities;
import com.briterp.utilities.ConfigurationReader;
import com.briterp.utilities.Driver;
import com.briterp.utilities.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PricelistsTest extends TestBase {
    int itemsCount;

    @Test(priority = 0)
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
        itemsCount = pages.pricelistSaveDiscardPage().deleteSigns.size();

        extentLogger.info("Go to \"PriceList Items\" field and click on \"Add an item\" link");
        pages.pricelistSaveDiscardPage().addAnItem2.click();

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
        itemsCount = pages.pricelistSaveDiscardPage().deleteSigns.size();

        extentLogger.info("Click on trash can sign ");
        pages.pricelistSaveDiscardPage().deleteSigns.get(pages.pricelistSaveDiscardPage().deleteSigns.size() - 1).click();

        extentLogger.info("Verify that the item count is decreased by one");
        BrowserUtilities.wait(2);
        Assert.assertEquals(pages.pricelistSaveDiscardPage().deleteSigns.size(), itemsCount - 1);
    }

    @Test(priority = 1)
    public void pricelistName() {
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
        BrowserUtilities.wait(2);
        pages.pricelists().priceListNames.get(randomNumber(0, pages.pricelists().priceListNames.size() - 1)).click();

        extentLogger.info("Click on \"Edit\" button");
        pages.pricelistEditCreate().editButton.click();

        extentLogger.info(" Change the name of the price list");
        pages.pricelistSaveDiscardPage().pricelistName.clear();
        Faker faker = new Faker();
        String newPricelistName = faker.commerce().productName();
        pages.pricelistSaveDiscardPage().pricelistName.sendKeys(newPricelistName);

        extentLogger.info(" Click on \"Save\" button");
        pages.pricelistSaveDiscardPage().save.click();

        extentLogger.info("Verify if pricelist name after saving it is matching with the one user put.");
        Assert.assertEquals(pages.pricelistEditCreate().pricelistName.getText(), newPricelistName);

        extentLogger.info(" Click on \"Pricelists\" link");
        pages.pricelists().pricelistsLink.click();
        BrowserUtilities.wait(2);

        extentLogger.info("Verify that pricelist name table includes updated name ");
        String updatedName = "";
        for (int i = 0; i < pages.pricelists().priceListNames.size(); i++) {
            if (pages.pricelists().priceListNames.get(i).getText().equals(newPricelistName)) {
                updatedName = pages.pricelists().priceListNames.get(i).getText();
                break;
            }
        }
        Assert.assertEquals(updatedName, newPricelistName);
    }

    @Test(priority = 2)
    public void discardEditing() {
        extentLogger = report.createTest("Discarding the edited Item Info Test");
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


        String pricelistName =pages.pricelistEditCreate().pricelistName.getText();
        String eCommercePromotionalCode=pages.pricelistEditCreate().eCommercePromotionalCodeBox.getText();
        String allowToUseOn = pages.pricelistEditCreate().selectedAllowToUseOn.getText();
        String itemsCount = pages.pricelistEditCreate().pricelistItems.size()+"";

        extentLogger.info("Click on \"Edit\" button");
        pages.pricelistEditCreate().editButton.click();

        extentLogger.info(" Change the name of the price list");
        pages.pricelistSaveDiscardPage().pricelistName.clear();
        Faker faker = new Faker();
        String newPricelistName = faker.commerce().productName();
        pages.pricelistSaveDiscardPage().pricelistName.sendKeys(newPricelistName);

        extentLogger.info("Type a code into \"E-commerce Promotional Code\" field and click on discard button");
        pages.pricelistSaveDiscardPage().eCommercePromotionalCodeBox.sendKeys("12070");

        extentLogger.info("Click on \"Allow to use on\" dropdown and choose the second option");
        pages.pricelistSaveDiscardPage().allowToUseOnDropDown.click();
        pages.pricelistSaveDiscardPage().allowToUseOn2Option.click();

        extentLogger.info("Delete an item from \"Pricelist Items\" table");
        pages.pricelistSaveDiscardPage().deleteSigns.get(randomNumber(0, pages.pricelistSaveDiscardPage().deleteSigns.size() - 1)).click();

        extentLogger.info("Click on \"discard\" button and then \"Ok\" button.");
        pages.pricelistSaveDiscardPage().discardButton.click();
        pages.pricelistSaveDiscardPage().okButton.click();

        extentLogger.info("Verify that previous info did not change for the Pricelist item");
        Assert.assertEquals(pages.pricelistEditCreate().pricelistName.getText(),pricelistName);
        Assert.assertEquals(pages.pricelistEditCreate().eCommercePromotionalCodeBox.getText(),eCommercePromotionalCode);
        Assert.assertEquals(pages.pricelistEditCreate().selectedAllowToUseOn.getText(),allowToUseOn);
        Assert.assertEquals(pages.pricelistEditCreate().pricelistItems.size()+"",itemsCount);


    }
}
