package com.briterp.tests.functional_test.orders.orders;

import com.briterp.utilities.BrowserUtilities;
import com.briterp.utilities.ConfigurationReader;
import com.briterp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class orderFunctionalTests extends TestBase {

    @Test(priority = 1)
    public void orderProductAdd() {
        extentLogger = report.createTest("Edit Button Under Orders Functionality");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();
        driver.get(ConfigurationReader.getProperty("orderUrl"));
        BrowserUtilities.wait(5);

        extentLogger.info("Click on a random order from list");
        BrowserUtilities.wait(2);
        //If you want to select randomly any order you should use below line
        //pages.orderList().orders.get(BrowserUtilities.randomNumber(0, pages.orderList().orders.size()-1)).click();
        pages.orderListPage().orders.get(10).click(); //This code is selecting 11th order "Tysons corner mall/0001".

        extentLogger.info("Click on \"Edit\" ");
        BrowserUtilities.wait(2);
        pages.orderListPage().editElement.click();

        extentLogger.info("Click on \"Add an item\" ");
        BrowserUtilities.wait(2);
        pages.orderListPage().addElement.click();

        extentLogger.info("Enter a product name");
        String product = "xxxxx";
        WebElement productAdd = driver.findElement(By.xpath("//div[@class='o_field_widget o_field_many2one o_required_modifier']//input[@class='o_input ui-autocomplete-input']"));
        productAdd.sendKeys(product + Keys.ENTER);
        productAdd.click();
        BrowserUtilities.wait(5);
        productAdd.sendKeys(Keys.ENTER);

        extentLogger.info("Click on \"Save\" ");
        BrowserUtilities.wait(5);
        pages.orderListPage().saveElement.click();

        extentLogger.info("Verify that changing is displayed");
        BrowserUtilities.wait(5);
        WebElement verifyProduct = pages.orderListPage().products.get(pages.orderListPage().products.size() - 1);
        Assert.assertEquals(verifyProduct.getText(), product);

    }

    @Test(priority = 2)
    public void orderProductEdit() {
        extentLogger = report.createTest("Edit Button Under Orders Functionality");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();
        driver.get(ConfigurationReader.getProperty("orderUrl"));
        BrowserUtilities.wait(5);


        extentLogger.info("Click on random order from list");
        BrowserUtilities.wait(5);
        int i = randomNumber(0, pages.orderListPage().ordersEdit.size() - 1);
        WebElement randomOrder = pages.orderListPage().ordersEdit.get(i);
        randomOrder.click();

        extentLogger.info("Click on \"Edit\" ");
        BrowserUtilities.wait(5);
        pages.orderListPage().editElement.click();


        extentLogger.info("Enter an input to Guests");
        pages.orderListPage().guestElement.clear();
        String testValue = "999";
        pages.orderListPage().guestElement.sendKeys(testValue);

        extentLogger.info("Click on \"Save\" ");
        pages.orderListPage().saveElement.click();

        extentLogger.info("Click on \"Orders\" link under \"Orders\"");
        BrowserUtilities.wait(5);
        pages.orders2Page().ordersLink.click();

        extentLogger.info("Click on order that selected randomly from list\"");
        BrowserUtilities.wait(5);
        WebElement myOrder = pages.orderListPage().ordersEdit.get(i);
        myOrder.click();

        extentLogger.info("Click on \"Edit\" ");
        BrowserUtilities.wait(5);
        pages.orderListPage().editElement.click();

        extentLogger.info("Verify that changing is displayed on the order");
        BrowserUtilities.wait(5);
        WebElement guestElementR = driver.findElement(By.xpath("//input[@class='o_field_integer o_field_number o_field_widget o_input']"));
        Assert.assertEquals(guestElementR.getAttribute("value"), testValue);
        pages.orderListPage().discardElement.click();
    }

    @Test(priority = 3)
    public void orderDeleteProduct() {
        extentLogger = report.createTest("Edit Button Under Orders Functionality");
        extentLogger.info("Login");
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();
        driver.get(ConfigurationReader.getProperty("orderUrl"));
        BrowserUtilities.wait(5);

        extentLogger.info("Click on 11th order from list");
        BrowserUtilities.wait(5);
        //If you want to select randomly any order you should use below line
        //pages.orderList().orders.get(BrowserUtilities.randomNumber(0, pages.orderList().orders.size()-1)).click();
        pages.orderListPage().orders.get(10).click(); //This code is selecting 11th order.

        extentLogger.info("Click on \"Edit\" ");
        BrowserUtilities.wait(5);
        pages.orderListPage().editElement.click();


        extentLogger.info("Click on delete icon");
        BrowserUtilities.wait(5);
        WebElement deleteElement = pages.orderListPage().deleteIcons.get(randomNumber(0, (pages.orderListPage().deleteIcons.size() - 1)));
        deleteElement.click();

        extentLogger.info("Click on \"Save\" ");
        WebElement saveElement = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_save']"));
        saveElement.click();
        Assert.assertEquals(deleteElement.getText(), "");
    }


}
