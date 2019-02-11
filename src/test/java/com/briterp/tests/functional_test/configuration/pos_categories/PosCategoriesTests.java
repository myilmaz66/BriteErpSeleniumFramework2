package com.briterp.tests.functional_test.configuration.pos_categories;

import com.briterp.pages.PoSCategoriesPage;
import com.briterp.utilities.BrowserUtilities;
import com.briterp.utilities.ConfigurationReader;
import com.briterp.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PosCategoriesTests extends TestBase {
    @Test
    public void Test1() {
        extentLogger = report.createTest("Click on BRITE ERP Logo and see discuss page");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(5);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on Products");
        pages.poSCategoriesPage().productLink.click();

        extentLogger.info("Click on Pos Categories link ");
        BrowserUtilities.wait(3);
        pages.poSCategoriesPage().posCategories.click();

        extentLogger.info("Click on BRITE ERP logo ");
        pages.poSCategoriesPage().BriteErpLogo.click();
//String verify = "Verify that discuss page message is correct";
////        extentLogger.info("Verify that discuss page message is correct ");
//        BrowserUtilities.wait(3);
//        Assert.assertEquals(pages.discussModulePage().discussPageMsg.isDisplayed(),
//                ConfigurationReader.getProperty("discusspagemessage");
//
    }

    @Test
    public void Test2() {
        extentLogger = report.createTest("Verify checkboxs on PoS Categories Page " +
                "are checkable");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(5);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on Products");
        pages.poSCategoriesPage().productLink.click();

        extentLogger.info("Click on Pos Categories link ");
        BrowserUtilities.wait(3);
        pages.poSCategoriesPage().posCategories.click();

        extentLogger.info("Verify checkbox ");
        pages.poSCategoriesPage().isChecked.isSelected();
    }

    @Test
    public void Test3() {
        extentLogger = report.createTest("Click create button on PoS Categories Page " +
                "are checkable");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(5);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on Products");
        pages.poSCategoriesPage().productLink.click();

        extentLogger.info("Click on Pos Categories link ");
        BrowserUtilities.wait(3);
        pages.poSCategoriesPage().posCategories.click();

        extentLogger.info("Click on create button ");
        pages.poSCategoriesPage().CreateButton.click();
    }

    @Test
    public void Test4() {
        extentLogger = report.createTest("Verify save on PoS Categories Page " +
                "are checkable");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(5);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on Products");
        pages.poSCategoriesPage().productLink.click();

        extentLogger.info("Click on Pos Categories link ");
        BrowserUtilities.wait(3);
        pages.poSCategoriesPage().posCategories.click();

        extentLogger.info("Click on create button ");
        pages.poSCategoriesPage().CreateButton.click();

        extentLogger.info("Type item in namebox and save ");
        pages.poSCategoriesPage().nameBox.sendKeys("boots");

        extentLogger.info("Click save ");
        pages.poSCategoriesPage().saveButton.click();
    }

    @Test
    public void Test5() {
        extentLogger = report.createTest("Verify delete on PoS Categories Page " +
                "are checkable");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(5);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on Products");
        pages.poSCategoriesPage().productLink.click();

        extentLogger.info("Click on Pos Categories link ");
        BrowserUtilities.wait(3);
        pages.poSCategoriesPage().posCategories.click();

        extentLogger.info("Click on create button ");
        pages.poSCategoriesPage().CreateButton.click();

        extentLogger.info("Type item in namebox and save ");
        pages.poSCategoriesPage().nameBox.sendKeys("boots");

        extentLogger.info("Click save ");
        pages.poSCategoriesPage().saveButton.click();

        extentLogger.info("Click on Action dropdown ");
        pages.poSCategoriesPage().actionButton.click();
//        extentLogger.info("Choose Delete ");
//        pages.poSCategoriesPage().deleteButton.click();
    }
}