package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsSaveDiscardPage {
    public  ProductsSaveDiscardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Product Name']")
    public WebElement productNameBox;

    @FindBy(xpath = "(//div[@class='o_field_boolean o_field_widget o_checkbox']//input)[1]")
    public WebElement canBeSoldCheckBox;

    @FindBy(xpath = "(//div[@class='o_field_boolean o_field_widget o_checkbox']//input)[2]")
    public WebElement canBePurchasedCheckBox;

    @FindBy(xpath = "//div[@class='o_form_buttons_edit']//button[@type='button'][contains(text(),'Save')]")
    public WebElement saveButton;




}
