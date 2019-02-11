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


public class deleteProductAsAManager extends TestBase {

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
        //This code is selecting 5th order "Gap Store at Old Orchard/0003".
        //If you want to select randomly any order you should use i instead of 5
        WebElement randomOrder = driver.findElement(By.xpath("//tbody[@class='ui-sortable']/tr["+1+"]"));
        randomOrder.click();

        extentLogger.info("Click on \"Edit\" ");
        BrowserUtilities.wait(5);
        WebElement editElement = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_edit']"));
        editElement.click();


        extentLogger.info("Click on delete icon");
        BrowserUtilities.wait(5);
        List<WebElement> deleteIcons = driver.findElements(By.xpath("//button[@class='fa fa-trash-o o_list_record_delete_btn']"));
        int k = random.nextInt(deleteIcons.size());
        WebElement deleteElement = deleteIcons.get(k);
        deleteElement.click();
         /*
        extentLogger.info("Enter a product name");
        String product = "xxxxx";
        addElement.sendKeys(product);
        WebElement productAdd = driver.findElement(By.xpath("//div[@class='o_field_widget o_field_many2one o_required_modifier']//input[@class='o_input ui-autocomplete-input']"));
        productAdd.sendKeys(product + Keys.ENTER);
        productAdd.click();
        driver.navigate().refresh();

            /*
            extentLogger.info("Click on \"Save\" ");
            WebElement saveElement = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_save']"));
            saveElement.click();
            */
/*
        extentLogger.info("Verify that changing is displayed");
        wait(5);
        List<WebElement> products = driver.findElements(By.xpath("//td[@class='o_data_cell o_required_modifier']"));
        WebElement verifyProduct = products.get(products.size()-1);
        Assert.assertEquals( verifyProduct.getText(), product);*/

    }

}
