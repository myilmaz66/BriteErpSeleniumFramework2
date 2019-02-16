package com.briterp.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected Pages pages;
    protected Actions actions;
    protected WebDriverWait wait;
    protected static ExtentReports report;
    private static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;


    @BeforeMethod(alwaysRun = true)
    public void setupMethod() {
        driver = Driver.getDriver();
        pages = new Pages();
        wait = new WebDriverWait(driver,40);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        // if any test fails, it can detect it, take a screen shot at the point and attach to report
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = BrowserUtilities.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {
            extentLogger.skip("Test Case Skipped: " + result.getName());
        }

       Driver.closeDriver();
    }

    @BeforeTest(alwaysRun = true)
    public void setUpTest() {
        report = new ExtentReports();
        //path for mac users
        // String filePath = System.getProperty("user.dir") + "/test-output/report.html";

        //path for windows users
        String filePath = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(filePath);
        report.attachReporter(htmlReporter);


        report.setSystemInfo("Environment", "Staging");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("QA Engineers", "Tysons_8");

        htmlReporter.config().setDocumentTitle("Brite Erp Point of Sale Reports");

        htmlReporter.config().setReportName("Brite Erp Point of Sale Automated Test Reports");


//        htmlReporter.config().setTheme(Theme.DARK);

    }

    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        report.flush();
    }

    public static int randomNumber(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }
}
