package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PointOfSale {
    public PointOfSale(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@data-menu='491']")
    public WebElement productsModuleButton;

    @FindBy(xpath = "//a[@data-action-id='676']/span")
    public WebElement pointOfSaleModuleButton;

    @FindBy (xpath = "//*[@class='ui-sortable']")
    public WebElement table;

}
