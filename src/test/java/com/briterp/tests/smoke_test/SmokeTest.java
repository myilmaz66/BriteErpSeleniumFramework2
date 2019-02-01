package com.briterp.tests.smoke_test;

import com.briterp.pages.OdooFirstPage;
import com.briterp.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmokeTest extends TestBase {



    @Test
    public void titleHomePage(){

        extentLogger = report.createTest("TitleHomePage");
        extentLogger.info("Opening Browser");
        Driver.getDriver();

        extentLogger.info("Verifying home page title");
        Assert.assertEquals(driver.getTitle(), "Odoo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extentLogger.info("Clicking on BriteErpDemo");
        odooFirstPage.briteErpDemo.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extentLogger.info("Verifying logIn page title");
        Assert.assertEquals(driver.getTitle(), "Login | Website localhost");







    }
    @Test
    public void logInPositive(){
        extentLogger = report.createTest("Positive Log In Test");
        extentLogger.info("Getting browser");
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

    @Test
    public void logInNegative(){

        extentLogger = report.createTest("Negative Log In Test");


        extentLogger.info("Entering Correct email in Email box");
        loginPage.emailBox.sendKeys(ConfigurationReader.getProperty("username"));
        extentLogger.info("Entering incorect password in Password box");
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("incorretpassword"));
        extentLogger.info("Clicking on signIn");
        loginPage.signInButton.click();
        extentLogger.info("Verifying error message");
        Assert.assertEquals(loginPage.errorMessage.getText(), ApplicationConstants.LOGIN_ERROR_MESSAGE);

    }




}
