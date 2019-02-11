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

        extentLogger.info("Click on \"Orders\" link under \"Configuration\"");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BrowserUtilities.wait(5);
        pages.orders().measuresButton.click();


        extentLogger.info("Click on random order from list");
        BrowserUtilities.wait(5);
        List<WebElement> orders = driver.findElements(By.xpath("//tbody[@class='ui-sortable']/tr"));
        Random random = new Random();
        int i = random.nextInt( orders.size() ) + 1;
        WebElement randomOrder = driver.findElement(By.xpath("//tbody[@class='ui-sortable']/tr["+i+"]"));
        randomOrder.click();

        extentLogger.info("Click on \"Edit\" ");
        BrowserUtilities.wait(5);
        WebElement editElement = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_edit']"));
        editElement.click();


        extentLogger.info("Enter an input to Guests");
        WebElement guestElement = driver.findElement(By.xpath("//input[@class='o_field_integer o_field_number o_field_widget o_input']"));
        guestElement.clear();
        String testValue = "999";
        guestElement.sendKeys(testValue);

        extentLogger.info("Click on \"Save\" ");
        WebElement saveElement = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_save']"));
        saveElement.click();

        extentLogger.info("Click on \"Orders\" link under \"Configuration\"");
        BrowserUtilities.wait(5);
        pages.orders().measuresButton.click();

        extentLogger.info("Click on order that selected randomly from list\"");
        BrowserUtilities.wait(5);
        WebElement myOrder = driver.findElement(By.xpath("//tbody[@class='ui-sortable']/tr["+i+"]"));
        myOrder.click();

        extentLogger.info("Click on \"Edit\" ");
        BrowserUtilities.wait(5);
        WebElement editElementR = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_edit']"));
        editElementR.click();

        extentLogger.info("Verify that changing is displayed on the order");
        BrowserUtilities.wait(5);
        WebElement guestElementR = driver.findElement(By.xpath("//input[@class='o_field_integer o_field_number o_field_widget o_input']"));
        Assert.assertEquals( guestElementR.getAttribute("value"),testValue );
        //String guest = guestElementR.getAttribute("value");
        //String guest = guestElementR.getAttribute("innerHTML");
        //String guest = guestElementR.getAttribute("outerHTML");
        WebElement discardElement = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm o_form_button_cancel']"));
        discardElement.click();

    }

}
