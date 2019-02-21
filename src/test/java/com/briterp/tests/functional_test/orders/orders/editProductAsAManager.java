package com.briterp.tests.functional_test.orders.orders;

import com.briterp.utilities.BrowserUtilities;
import com.briterp.utilities.Driver;
import com.briterp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class editProductAsAManager extends TestBase {

    @Test
    public void editButton(){
        extentLogger = report.createTest("Edit Button Under Orders Functionality");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();

        extentLogger.info("Click on \"point of sale\" link");
        BrowserUtilities.wait(5);
        pages.discussModulePage().pointOfSale.click();

        extentLogger.info("Click on \"Orders\" link under \"Dashboard\"");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BrowserUtilities.wait(5);
        pages.orders2Page().ordersLink.click();


        extentLogger.info("Click on random order from list");
        BrowserUtilities.wait(5);
        List<WebElement> orders = pages.orderListPage().ordersEdit;
        Random random = new Random();
        int i = random.nextInt( orders.size() ) + 1;
        pages.orderListPage().selectOrder(i).click();


        extentLogger.info("Click on \"Edit\" ");
        BrowserUtilities.wait(5);
        pages.orderListPage().editElement.click();

        extentLogger.info("Enter an input to Guests");
        pages.orderListPage().guestElement.clear();
        String testValue = "999";
        pages.orderListPage().guestElement.sendKeys(testValue);

        extentLogger.info("Click on \"Save\" ");
        pages.orderListPage().saveElement.click();


        extentLogger.info("Click on \"Orders\" link under \"Dashboard\"");
        BrowserUtilities.wait(5);
        pages.orders2Page().ordersLink.click();

        extentLogger.info("Click on order that selected randomly from list\"");
        BrowserUtilities.wait(5);
        pages.orderListPage().selectOrder(i).click();

        extentLogger.info("Click on \"Edit\" ");
        BrowserUtilities.wait(5);
        pages.orderListPage().editElement.click();

        extentLogger.info("Verify that changing is displayed on the order");
        BrowserUtilities.wait(5);
        WebElement guestElementR = pages.orderListPage().guestElement;
        Assert.assertEquals( guestElementR.getAttribute("value"),testValue );
        //String guest = guestElementR.getAttribute("value");
        //String guest = guestElementR.getAttribute("innerHTML");
        //String guest = guestElementR.getAttribute("outerHTML");
        pages.orderListPage().discardElement.click();

    }

}
