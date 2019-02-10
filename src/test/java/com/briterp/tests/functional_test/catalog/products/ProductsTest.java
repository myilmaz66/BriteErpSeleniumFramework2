package com.briterp.tests.functional_test.catalog.products;

import com.briterp.utilities.BrowserUtilities;
import com.briterp.utilities.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends TestBase {
    @Test(priority = 6)
    public void isAlphabetical() {
        extentLogger = report.createTest("Check if the products are listed alphabetically Test");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(4);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on \"Products\" link under \"Catalog\"");
        pages.pointOfSaleModulePage().productsLink.click();

        extentLogger.info("Verify that products are listed alphabetically ");
        BrowserUtilities.wait(2);
        for (int i = 0; i < pages.productsPage().productsNames.size() - 1; i++) {
            Assert.assertTrue(pages.productsPage().productsNames.get(i).getText().compareTo(pages.productsPage().productsNames.get(i + 1).getText()) <= 0);
        }
    }

    @Test(priority = 7)
    public void canbanListView() {
        extentLogger = report.createTest(" Create a new product Test");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(4);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on \"Products\" link under \"Catalog\"");
        BrowserUtilities.wait(2);
        pages.pointOfSaleModulePage().productsLink.click();

        extentLogger.info("Click on create button");
        pages.productsPage().createButton.click();

        extentLogger.info("Put a product name into the product name field");
        Faker faker = new Faker();
        String newProductName = faker.commerce().productName();
        pages.productsSaveDiscardPage().productNameBox.sendKeys(newProductName);

        extentLogger.info("Verify that \"can be purchased\" and \"can be sold\" options are checked by default");
        Assert.assertTrue(pages.productsSaveDiscardPage().canBeSoldCheckBox.isSelected());
        Assert.assertTrue(pages.productsSaveDiscardPage().canBePurchasedCheckBox.isSelected());

        extentLogger.info("Click on \"Save\" button.");
        pages.productsSaveDiscardPage().saveButton.click();

        extentLogger.info("Verify that product name is displayed in upper left corner and matches with the one user put");
        Assert.assertTrue(pages.productsEditCreatePage().productName.isDisplayed());
        BrowserUtilities.wait(3);
        Assert.assertTrue(pages.productsEditCreatePage().productName.getText().equals(newProductName));
    }

    @Test(priority = 8)
    public void createNewProduct() {
        extentLogger = report.createTest(" Switch the view of the products between \"Kanban\" and \"List\" Test");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(4);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on \"Products\" link under \"Catalog\"");
        pages.pointOfSaleModulePage().productsLink.click();

        extentLogger.info("Verify that products are listed as Kanban by default");
        BrowserUtilities.waitForVisibility(pages.productsPage().productPicture, 5);
        Assert.assertTrue(pages.productsPage().productPicture.isDisplayed());
        Assert.assertTrue(pages.productsPage().firstProductName.isDisplayed());

        extentLogger.info("Click on \"List\" sign ");
        pages.productsPage().listButton.click();

        extentLogger.info("Verify that the view of the products has changed from kanban to List ");
        Assert.assertTrue(pages.listViewPage().checkBox.isDisplayed());
    }

    @Test(priority = 9)
    public void productsFromOneToEighty() {
        extentLogger = report.createTest("Check if the page displays the products from 1 to 80 Test");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(4);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on \"Products\" link under \"Catalog\"");
        pages.pointOfSaleModulePage().productsLink.click();

        extentLogger.info("Verify that the products are listed from 1 to 80");
        Assert.assertTrue(pages.productsPage().productsNamesSize.size() == 80);
        Assert.assertEquals(pages.productsPage().pagerValue.getText(), "1-80");

        extentLogger.info("Click on next arrow button");
        pages.pricelistSaveDiscardPage().forwardArrowButton.click();

        extentLogger.info("verify if the numbers interval is changed from 81 to 160 or last product's number");
        int productTotalCount = Integer.parseInt(pages.productsPage().productTotalCount.getText());
        if (productTotalCount < 160) {
            Assert.assertEquals(pages.productsPage().pagerValue.getText(), "81-"+productTotalCount);
        } else {
            Assert.assertEquals(pages.productsPage().pagerValue.getText(), "81-160");
        }
    }
}
