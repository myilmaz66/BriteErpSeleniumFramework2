package com.briterp.tests.functional_test.reporting.orders;

import com.briterp.utilities.Driver;
import com.briterp.utilities.TestBase;
import org.testng.annotations.Test;

public class orders extends TestBase {
    @Test
    public void accessOrdersAnlysGrph(){
        extentLogger = report.createTest("Visibility Abd Clickability");
        extentLogger.info("Open the URL");
        Driver.getDriver();
        pages.orders().measuresButton.click();

    }
}
