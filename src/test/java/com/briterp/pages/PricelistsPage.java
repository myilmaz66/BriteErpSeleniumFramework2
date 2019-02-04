package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PricelistsPage {
    public PricelistsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-menu-xmlid='point_of_sale.pos_config_menu_action_product_pricelist']")
    public WebElement pricelistsLink;

    @FindBy(xpath = "//table/tbody//td[3]")
    public List<WebElement> priceListNames;

}