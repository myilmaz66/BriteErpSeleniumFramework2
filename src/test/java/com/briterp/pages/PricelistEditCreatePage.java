package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PricelistEditCreatePage {
    public PricelistEditCreatePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    public WebElement editButton;

    @FindBy(xpath = "//span[@name='name']")
    public WebElement pricelistName;

    @FindBy(xpath = "//div//table[@class='o_group o_inner_group']//tbody//tr[2]//td[2]")
    public WebElement eCommercePromotionalCodeBox;

    @FindBy(xpath = "//tbody//tr[5]//td[2]/a")
    public WebElement selectedAllowToUseOn;

    @FindBy(xpath = "//tbody[@class='ui-sortable']//tr/td[1][@class='o_data_cell o_readonly_modifier']")
    public List<WebElement> pricelistItems;


}
