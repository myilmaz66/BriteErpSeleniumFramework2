package com.briterp.pages;

import com.briterp.utilities.ConfigurationReader;
import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoSCategoriesPage {
    public PoSCategoriesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-menu-xmlid='point_of_sale.menu_products_pos_category']")
    public WebElement posCategories;
    @FindBy(xpath = "//a[@data-menu-xmlid='point_of_sale.pos_menu_products_configuration']")
    public WebElement productLink;
    @FindBy(xpath = "//img[@src='http://52.39.162.23/web/binary/company_logo?db=BriteErpDemo&company=1']")
    public WebElement BriteErpLogo;
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement isChecked;
    @FindBy(xpath = "//*[@class='btn btn-primary btn-sm o_list_button_add']")
    public WebElement CreateButton;
    @FindBy(xpath = "//*[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement nameBox;
    @FindBy(xpath = "//*[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class='o_field_char o_field_widget o_required_modifier']")
    public WebElement widjetName;

    @FindBy(xpath = "//button[contains(text(),'Action')]")
    public WebElement actionButton;

    @FindBy(xpath = "//*[@data-section='other']")
    public WebElement deleteButton;

    public void positiveCheck() {
        nameBox.sendKeys(ConfigurationReader.getProperty("boots"));
        saveButton.click();
    }
}
