package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PricelistSaveDiscardPage {
    public PricelistSaveDiscardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div//table[@class='o_group o_inner_group']//tbody//tr[2]//td[2]/input")
    public WebElement eCommercePromotionalCodeBox;

    @FindBy(xpath = "//div[@name='website_id']//input")
    public WebElement allowToUseOnDropDown;

    @FindBy(xpath = "//a[contains(text(),'Website 0.0.0.0')]")
    public WebElement allowToUseOn2Option;

    @FindBy(xpath = "//button[contains(text(),'Discard')]")
    public WebElement discardButton;

    @FindBy(xpath = "//span[contains(text(),'Ok')]")
    public WebElement okButton;

    @FindBy(xpath = "//button[@type='button'][contains(text(),'Save')]")
    public WebElement save;

    @FindBy(xpath = "//div[@name='item_ids']//tbody/tr/td/button")
    public List<WebElement> deleteSigns;

    @FindBy(xpath = "(//td[@class='o_field_x2many_list_row_add']/a)[2]")
    public WebElement addAnItem2;

    @FindBy(xpath = "//h1/input")
    public WebElement pricelistName;

    @FindBy(xpath = "//div[contains(@class,'modal-body')]")
    public WebElement discardMessage;

    @FindBy(xpath = "//div[contains(@class,'btn-group o_search_options')]/following-sibling::div//button[2]")
    public WebElement forwardArrowButton;

    @FindBy(xpath = "//div[contains(@class,'btn-group o_search_options')]/following-sibling::div//button[1]")
    public WebElement backArrowButton;



}
