package com.briterp.tests.functional_test.dashboard;

import com.briterp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        wait.until(ExpectedConditions.elementToBeClickable(pages.discussModulePage().pointOfSale)).click();
        pages.discussModulePage().resumeWholeFoodsStore.click();
    }

    @Test
    public void ManagerChosingCustomer() throws InterruptedException {

//        extentLogger = report.createTest("Manager chosing customer");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Thread.sleep(12000);
//
//         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='button set-customer']")));
//
//        actions.moveToElement(pages.wholeFoodsStorePage().customerButton).click().click().build().perform();
//        pages.wholeFoodsStorePage().searchCustomer.sendKeys(pages.wholeFoodsStorePage().customerNameSearch);

        // BLOCKER

    }

    @Test
    public void Manager_giving_discount_to_customer() throws InterruptedException {

        extentLogger = report.createTest("Manager giving discount to customer");
        Thread.sleep(10000);
        extentLogger.info("Clicking on Honda Accord");
        actions.moveToElement(pages.wholeFoodsStorePage().hondaAccord).click().build().perform();
        extentLogger.info("Clicking on discount button");
        actions.moveToElement(pages.wholeFoodsStorePage().discountButton).click().build().perform();
        extentLogger.info("Clicking on number 5");
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(pages.wholeFoodsStorePage().number5));
        pages.wholeFoodsStorePage().number5.click();
        extentLogger.info("Clicking on number 0");
        pages.wholeFoodsStorePage().number0.click();
        extentLogger.info("Verifying that price is $ 12,000.00");
        Assert.assertEquals(pages.wholeFoodsStorePage().cart.getText(), "$ 12,000.00");








    }

}
