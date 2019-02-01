package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OdooFirstPage {


    public OdooFirstPage(){ PageFactory.initElements(Driver.getDriver(),this); }


    @FindBy (xpath = "//*[@href='/web?db=BriteErpDemo']")
    public WebElement briteErpDemo;

    public void stepsToLogInPage(){
        briteErpDemo.click();
    }


}
