package com.briterp.tests.functional_test.reporting.orders;

import com.briterp.utilities.ConfigurationReader;
import com.briterp.utilities.Driver;
import com.briterp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class orders extends TestBase {
    @Test
    public void accessOrdersAnlysGrph() throws InterruptedException {
        extentLogger = report.createTest("Visibility Abd Clickability");

        extentLogger.info("Click on Brite erp");
        pages.odoo().briteErpDemo.click();
        extentLogger.info("Enter Username");
        pages.loginPage().emailBox.sendKeys(ConfigurationReader.getProperty("username"));
        extentLogger.info("Enter Password");
        pages.loginPage().passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        extentLogger.info("Click on the SignTn Button");
        pages.loginPage().signInButton.click();
        Thread.sleep(5000);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-menu-xmlid='point_of_sale.menu_point_root']")));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extentLogger.info("Click on the Point Of Sale Button");
        pages.pointOfSale().pointOfSaleModuleButton.click();
        extentLogger.info("Click On The Orders Button");
        pages.pointOfSale().orders.click();


        //pages.orders().measuresButton.click();

    }

    @Test
    public void chooseStatementsOfSales() throws InterruptedException {

        accessOrdersAnlysGrph();
        extentLogger = report.createTest("Choose Statements Of Sales Test ");
        extentLogger.info("Click On The Measure Button");
        pages.pointOfSale().measures.click();

        extentLogger.info("Click on the Total Price Button");
        pages.pointOfSale().totalPrice.click();

        extentLogger.info("Click On The SubTotalDiscount");
        pages.pointOfSale().subTotalDiscount.click();

        extentLogger.info("Click On The TotalDiscount");
        pages.pointOfSale().totalDiscount.click();

        extentLogger.info("Click On The #OfLine Button");
        pages.pointOfSale().ofLines.click();

        extentLogger.info("Click On The ProductQuantity Button");
        pages.pointOfSale().productQuantity.click();

        extentLogger.info("Click On The delayValidation Button");
        pages.pointOfSale().delayValidation.click();

        extentLogger.info("Click On The Count Button");
        pages.pointOfSale().count.click();
    }

    @Test
    public void barCharResult() throws InterruptedException {
        chooseStatementsOfSales();
        extentLogger = report.createTest("Bar Chart Result Test");
        extentLogger.info(" Click On The BarChart Button ");
        pages.pointOfSale().barChart.click();


    }
}


