package com.briterp.tests.smoke_test;

import com.briterp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmokeTest extends TestBase {

// IN PROGRESS // Needs Waits everywhere

    @Test(priority = 0)
    public void titleHomePage(){
        extentLogger = report.createTest("TitleHomePage");
        extentLogger.info("Verifying home page title");
        Assert.assertEquals(driver.getTitle(), "Odoo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        extentLogger.info("Clicking on BriteErpDemo");
        pages.odoo().briteErpDemo.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        extentLogger.info("Verifying logIn page title");
        Assert.assertEquals(driver.getTitle(), "Login | Website localhost");
  }
    @Test(priority = 1)
    public void logInPositive(){
        extentLogger = report.createTest("Positive Log In Test");
        extentLogger.info("Clicking on BritErpDemo");
        pages.odoo().stepsToLogInPage();

        extentLogger.info("Entering Correct email in Email box");
        pages.loginPage().emailBox.sendKeys(ConfigurationReader.getProperty("username"));

        extentLogger.info("Entering Correct password in Password box");
        pages.loginPage().passwordBox.sendKeys(ConfigurationReader.getProperty("password"));

        extentLogger.info("Clicking on signIn");
        pages.loginPage().logInButton.click();

        extentLogger.info("Clicking on Drop Down Menu");
        pages.discussModulePage().dropDown.click();

        extentLogger.info("Clicking on Sign out");
        pages.discussModulePage().signOutButton.click();

        extentLogger.info("Verifying title equals expected");
        Assert.assertEquals(driver.getTitle(),"Login | Website localhost");

    }

    @Test(priority = 2)
    public void logInNegative(){
        extentLogger = report.createTest("Negative Log In Test");
        extentLogger.info("Clicking on BritErpDemo");
        pages.odoo().stepsToLogInPage();

        extentLogger.info("Entering Correct email in Email box");
        pages.loginPage().emailBox.sendKeys(ConfigurationReader.getProperty("username"));

        extentLogger.info("Entering incorrect password in Password box");
        pages.loginPage().passwordBox.sendKeys(ConfigurationReader.getProperty("incorretpassword"));

        extentLogger.info("Clicking on signIn");
        pages.loginPage().logInButton.click();

        extentLogger.info("Verifying error message");
        Assert.assertEquals(pages.loginPage().errorMessage.getText(), ApplicationConstants.LOGIN_ERROR_MESSAGE);

    }

    @Test(priority = 3)
    public void VisibilityAndClickability() throws InterruptedException {
        extentLogger = report.createTest("Visibility Abd Clickability");
        extentLogger.info("Clicking on BritErpDemo");
        pages.odoo().stepsToLogInPage();

        extentLogger.info("Login in with correct credentials");
        pages.loginPage().positiveLogIn();

        extentLogger.info("Clicking on Sign In button");
//        loginPage.signInButton.click();

        extentLogger.info("Clicking on Point of Sale button");
        Thread.sleep(1000);
        pages.discussModulePage().pointOfSale.click();

        Thread.sleep(2000);
        pages.discussModulePage().pointOfSale.click();
        extentLogger.info("Verifying Title");
        Thread.sleep(7000);
        Assert.assertEquals(driver.getTitle(),"Point of Sale - Odoo");

        extentLogger.info("Clicking on products button");
        pages.pointOfSaleModulePage().productsLink.click();

        extentLogger.info("Verifying Title");
        Thread.sleep(7000);
        Assert.assertEquals(driver.getTitle(), "Products - Odoo");

        extentLogger.info("Clicking on point of Sale button");
        pages.pointOfSaleModulePage().pointOfSaleLink.click();
        Thread.sleep(4000);

        extentLogger.info("Verifying Title");
        Assert.assertEquals(driver.getTitle(), "Point of Sale - Odoo");

  }
}
