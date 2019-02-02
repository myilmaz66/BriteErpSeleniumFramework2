package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
    public OrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm dropdown-toggle']")
    public WebElement measuresButton;
}
