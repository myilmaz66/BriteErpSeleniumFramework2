package com.briterp.tests.smoke_test;

import com.briterp.pages.LoginPage;
import com.briterp.pages.OdooFirstPage;
import com.briterp.pages.PointOfSale;
import com.briterp.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmokeTest extends TestBase {

// IN PROGRESS // Needs Waits everywhere

    @Test(priority = 0)
    public void titleHomePage(){
        // Creating test for report.html
        extentLogger = report.createTest("TitleHomePage");
        extentLogger.info("Opening Browser");
        // Openning Browser
        Driver.getDriver();
        extentLogger.info("Verifying home page title");
        // Verifiying title equals expected
        Assert.assertEquals(driver.getTitle(), "Odoo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extentLogger.info("Clicking on BriteErpDemo");
        // Clicking on BRITEERPDEMO
        odooFirstPage.briteErpDemo.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Verifiying title equals expected
        extentLogger.info("Verifying logIn page title");
        Assert.assertEquals(driver.getTitle(), "Login | Website localhost");
  }
    @Test(priority = 1)
    public void logInPositive(){
        extentLogger = report.createTest("Positive Log In Test");
        Driver.getDriver();
        extentLogger.info("Clicking on BritErpDemo");
        odooFirstPage.stepsToLogInPage();
        extentLogger.info("Entering Correct email in Email box");
        loginPage.emailBox.sendKeys(ConfigurationReader.getProperty("username"));
        extentLogger.info("Entering Correct password in Password box");
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        extentLogger.info("Clicking on signIn");
        loginPage.signInButton.click();
        extentLogger.info("Clicking on Drop Down Menu");
        discussModulePage.dropDown.click();
        extentLogger.info("Clicking on Sign out");
        discussModulePage.signOutButton.click();
        extentLogger.info("Verifying title equals expected");
        Assert.assertEquals(driver.getTitle(),"Login | Website localhost");

    }

    @Test(priority = 2)
    public void logInNegative(){
        extentLogger = report.createTest("Negative Log In Test");
        extentLogger.info("Getting browser");
        Driver.getDriver();
        extentLogger.info("Clicking on BritErpDemo");
        odooFirstPage.stepsToLogInPage();
        extentLogger.info("Entering Correct email in Email box");
        loginPage.emailBox.sendKeys(ConfigurationReader.getProperty("username"));
        extentLogger.info("Entering incorect password in Password box");
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("incorretpassword"));
        extentLogger.info("Clicking on signIn");
        loginPage.signInButton.click();
        extentLogger.info("Verifying error message");
        Assert.assertEquals(loginPage.errorMessage.getText(), ApplicationConstants.LOGIN_ERROR_MESSAGE);

    }


    @Test(priority = 3)
    public void VisibilityAndClickability() throws InterruptedException {
        extentLogger = report.createTest("Visibility Abd Clickability");
        extentLogger.info("Getting browser");
        Driver.getDriver();
        extentLogger.info("Clicking on BritErpDemo");
        odooFirstPage.stepsToLogInPage();
        extentLogger.info("Login in with correct credentials");
        loginPage.positiveLogIn();
        extentLogger.info("Clicking on Sign In button");
//        loginPage.signInButton.click();
        extentLogger.info("Clicking on Point of Sale button");
        Thread.sleep(2000);
        discussModulePage.pointOfSale.click();
        extentLogger.info("Verifying Title");
        Thread.sleep(7000);
        Assert.assertEquals(driver.getTitle(),"Point of Sale - Odoo");
        extentLogger.info("Clicking on products button");
        pointOfSale.productsModuleButton.click();
        extentLogger.info("Verifying Title");
        Thread.sleep(4000);
        Assert.assertEquals(driver.getTitle(), "Products - Odoo");
        extentLogger.info("Clicking on point of Sale button");
        pointOfSale.pointOfSaleModuleButton.click();
        Thread.sleep(4000);
        extentLogger.info("Verifying Title");
        Assert.assertEquals(driver.getTitle(), "Point of Sale - Odoo");

  }
}
