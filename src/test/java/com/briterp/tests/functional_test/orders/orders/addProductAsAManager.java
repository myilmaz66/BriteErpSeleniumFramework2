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


public class addProductAsAManager extends TestBase{

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


            extentLogger.info("Click on 5th order from list");
            BrowserUtilities.wait(5);
            List<WebElement> orders = driver.findElements(By.xpath("//tbody[@class='ui-sortable']/tr"));
            Random random = new Random();
            int i = random.nextInt( orders.size() ) + 1;
            //This code is selecting 11th order "Tysons corner mall/0001".
            //If you want to select randomly any order you should use i instead of 11
            WebElement randomOrder = driver.findElement(By.xpath("//tbody[@class='ui-sortable']/tr["+11+"]"));
            randomOrder.click();

            extentLogger.info("Click on \"Edit\" ");
            BrowserUtilities.wait(5);
            WebElement editElement = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_edit']"));
            editElement.click();

            extentLogger.info("Click on \"Add an item\" ");
            BrowserUtilities.wait(5);
            WebElement addElement = driver.findElement(By.linkText("Add an item") );
            addElement.click();

           //extentLogger.info("Page headers test");
           // System.out.println(Driver.getDriver().getPageSource());

            extentLogger.info("Enter a product name");
            String product = "xxxxx";
            addElement.sendKeys(product);
            WebElement productAdd = driver.findElement(By.xpath("//div[@class='o_field_widget o_field_many2one o_required_modifier']//input[@class='o_input ui-autocomplete-input']"));
            productAdd.sendKeys(product + Keys.ENTER);
            productAdd.click();
            BrowserUtilities.wait(5);
            productAdd.sendKeys(Keys.ENTER);



            extentLogger.info("Click on \"Save\" ");
            BrowserUtilities.wait(5);
            WebElement saveElement = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_save']"));
            saveElement.click();


            extentLogger.info("Verify that changing is displayed");
            BrowserUtilities.wait(5);
            List<WebElement> products = driver.findElements(By.xpath("//td[@class='o_data_cell o_required_modifier']"));
            WebElement verifyProduct = products.get(products.size()-1);
            Assert.assertEquals( verifyProduct.getText(), product);

    }

}
