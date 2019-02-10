package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PointOfSaleModulePage {
    public PointOfSaleModulePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-menu='491']")
    public WebElement productsLink;

    @FindBy(xpath = "//a[@data-action-id='676']/span")
    public WebElement pointOfSaleLink;

    @FindBy(xpath = "//a[@data-menu-xmlid='point_of_sale.pos_config_menu_action_product_pricelist']")
    public WebElement pricelistsLink;
}
