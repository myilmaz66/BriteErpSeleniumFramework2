package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListViewPage {
    public ListViewPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tbody[@class='ui-sortable']//tr[1]//td[1]//div[1]//input[1]")
    public WebElement checkBox;
}
