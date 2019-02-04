package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricelistEditCreatePage {
    public PricelistEditCreatePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    public WebElement editButton;

    @FindBy(xpath = "(//td[@class='o_field_x2many_list_row_add']/a)[2]")
    public WebElement addAnItem2;
}
