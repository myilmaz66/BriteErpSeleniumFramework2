package com.briterp.tests.functional_test.dashboard;

import com.briterp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WholeFoodsStore extends TestBase {

    // MIJAT RATKOVIC 10 TEST CASES


    @BeforeMethod
    public void setUp() throws InterruptedException {
        pages.odoo().briteErpDemo.click();
        pages.loginPage().positiveLogIn();
        pages.discussModulePage().pointOfSale.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        pages.discussModulePage().resumeWholeFoodsStore.click();
    }

    @Test
    public void ManagerChosingCustomer() throws InterruptedException {

        extentLogger = report.createTest("Manager chosing customer");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pages.wholeFoodsStorePage().searchCustomer.sendKeys(pages.wholeFoodsStorePage().customerNameSearch);


    }

}
