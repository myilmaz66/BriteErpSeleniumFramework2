package com.briterp.tests.functional_test.dashboard;

import com.briterp.utilities.BrowserUtilities;
import com.briterp.utilities.Driver;
import com.briterp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WholeFoodsStore extends TestBase {

    // MIJAT RATKOVIC 10 TEST CASES


    @BeforeMethod
    public void setUp() throws InterruptedException {
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();
//        pages.discussModulePage().pointOfSale.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(pages.discussModulePage().pointOfSale));
        pages.discussModulePage().pointOfSale.click();
        pages.discussModulePage().resumeWholeFoodsStore.click();
        BrowserUtilities.waitForPageToLoad(7);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    }

    @Test
    public void ManagerChosingCustomer() throws InterruptedException {

        extentLogger = report.createTest("Manager chosing customer");
        wait.until(ExpectedConditions.textToBePresentInElement(pages.wholeFoodsStorePage().customerButton,"Customer"));
        actions.moveToElement(pages.wholeFoodsStorePage().customerButton).clickAndHold().release().build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(pages.wholeFoodsStorePage().customerButton));
        BrowserUtilities.waitForClickablility(pages.wholeFoodsStorePage().customerButton,10);
        pages.wholeFoodsStorePage().customerButton.click();
        BrowserUtilities.waitForPageToLoad(5);
//        pages.wholeFoodsStorePage().customerButton.click();
        extentLogger.info("Search for particiluar customer");
        wait.until(ExpectedConditions.urlToBe(pages.wholeFoodsStorePage().urlSetCustomer));
        actions.moveToElement(pages.wholeFoodsStorePage().searchCustomer).click().sendKeys("Morgan");
        extentLogger.info("Clicking on set customer");


    }

    @Test
    public void Manager_giving_discount_to_customer() throws InterruptedException {

        extentLogger = report.createTest("Manager giving discount to customer");

        extentLogger.info("Clicking on Honda Accord");
        // Excplicit wait
        wait.until(ExpectedConditions.elementToBeClickable(pages.wholeFoodsStorePage().hondaAccord));
        BrowserUtilities.waitForPageToLoad(5);
        BrowserUtilities.waitForClickablility(pages.wholeFoodsStorePage().hondaAccord,10);
        // works only with actions so I put action class
        actions.moveToElement(pages.wholeFoodsStorePage().hondaAccord).click().build().perform();
        extentLogger.info("Clicking on discount button");
        actions.moveToElement(pages.wholeFoodsStorePage().discountButton).doubleClick().build().perform();
        Thread.sleep(5000);
        extentLogger.info("Clicking on number 5");
        // Excplicit wait
        wait.until(ExpectedConditions.elementToBeClickable(pages.wholeFoodsStorePage().number5));
        BrowserUtilities.waitForPageToLoad(5);
        BrowserUtilities.waitForClickablility(pages.wholeFoodsStorePage().number5,5);
        // works only with actions so I put action class
        actions.moveToElement(pages.wholeFoodsStorePage().number5).click().build().perform();

        extentLogger.info("Clicking on number 0");
        // Excplicit wait
        wait.until(ExpectedConditions.elementToBeClickable(pages.wholeFoodsStorePage().number0));
        BrowserUtilities.waitForPageToLoad(5);
        BrowserUtilities.waitForClickablility(pages.wholeFoodsStorePage().number0,5);
        // works only with actions so I put action class
        actions.moveToElement(pages.wholeFoodsStorePage().number0).click().build().perform();

        extentLogger.info("Verifying that price is $ 12,000.00");
        Assert.assertTrue(pages.wholeFoodsStorePage().cart.getText().contains("$ 12,000.00"));


    }

}
