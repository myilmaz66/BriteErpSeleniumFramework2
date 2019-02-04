package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreatePricelistItemsPage {
    public CreatePricelistItemsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//input[@data-index='0'])[2]")
    public WebElement globalRadioBtn;

    @FindBy(xpath = "(//input[@data-index='0'])[3]")
    public WebElement fixPriceRadioBtn;

    @FindBy(xpath = "//div[@name='applied_on']/div/input")
    public List<WebElement> ApplyOnButtons;

    @FindBy(xpath = "//div[@name='compute_price']/div/input")
    public List <WebElement> computePriceButtons;

    @FindBy(xpath = "//input[@name='min_quantity']")
    public WebElement minQuantityBox;

    @FindBy(xpath = "//div[@class='modal-footer']//button[1]")
    public WebElement saveAndClose;

    @FindBy(xpath = "//div[@name='item_ids']//tbody/tr/td/button")
    public List<WebElement> deleteSigns;

    @FindBy(xpath = "//input[@id='radio435_2_product_category']/../../../..//following-sibling::tr//input")
    public List< WebElement> productBox;

    @FindBy(xpath = "//ul[@id='ui-id-30']/li")
    public List<WebElement> productVariantItems;






}
