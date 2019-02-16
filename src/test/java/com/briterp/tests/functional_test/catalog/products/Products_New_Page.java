package com.briterp.tests.functional_test.catalog.products;

import com.briterp.utilities.BrowserUtilities;
import com.briterp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Products_New_Page extends TestBase {

    @Test(priority = 1)
    public void test1() {
        extentLogger = report.createTest("Check if the products are listed alphabetically Test");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();
        pages.discussModulePage().pointOfSale.click();
        BrowserUtilities.waitForPageToLoad(6);
        pages.pointOfSale().pointOfSaleModuleButton.click();
        pages.productPage().products.click();
        BrowserUtilities.wait(4);
        pages.productPage().CreatButton.click();


        pages.productsSaveDiscardPage().canBeSoldCheckBox.click();
        pages.productsSaveDiscardPage().canBePurchasedCheckBox.click();
        BrowserUtilities.wait(2);
        pages.productsSaveDiscardPage().canBeExpensedCheckBox.click();
        pages.productsSaveDiscardPage().productNameBox.sendKeys("CyberTek Uniform");
        pages.productPage().SaveButton.click();
    }

    @Test(priority = 2)
    public void test2(){
        extentLogger = report.createTest("Check if the products are listed alphabetically Test");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();
        pages.discussModulePage().pointOfSale.click();
        BrowserUtilities.waitForPageToLoad(10);
        pages.pointOfSale().pointOfSaleModuleButton.click();
        pages.productPage().products.click();
        BrowserUtilities.wait(3);
        String ActualResult = pages.productPage().ProductMessageOnThePage.getText();
        String ExpectedResult = "Products";
        Assert.assertEquals(ActualResult, ExpectedResult);
        pages.productPage().CreatButton.click();
    }
}