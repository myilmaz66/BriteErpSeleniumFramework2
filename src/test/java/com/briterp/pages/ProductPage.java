package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[39]")
    public WebElement products;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-primary btn-sm o-')]")
    public WebElement CreatButton;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement SaveButton;

    @FindBy(xpath = "(//li[@class='active'])[3]")
    public WebElement ProductMessageOnThePage;


}