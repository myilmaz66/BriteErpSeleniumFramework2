package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscussModulePage {
    public DiscussModulePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='oe_topbar_name']")
    public WebElement dropDown;

    @FindBy (xpath = "//*[@data-menu='logout']")
    public WebElement signOutButton;
}
