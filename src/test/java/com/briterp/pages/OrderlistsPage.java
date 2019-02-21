package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderlistsPage {

    public OrderlistsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//tbody[@class='ui-sortable']//td[@class = 'o_list_record_selector']//following-sibling::td[1]")
    public List<WebElement> orders;


    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement editElement;

    @FindBy(linkText = "Add an item")
    public WebElement addElement;


    @FindBy(xpath = "//div[@class='o_field_widget o_field_many2one o_required_modifier']//input[@class='o_input ui-autocomplete-input']")
    public WebElement productAdd;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveElement;


    @FindBy(xpath = "//td[@class='o_data_cell o_required_modifier']")
    public List<WebElement> products;

    @FindBy(xpath = "//button[@class='fa fa-trash-o o_list_record_delete_btn']")
    public List<WebElement> deleteIcons;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr")
    public List<WebElement> ordersEdit;


    @FindBy(xpath ="//input[@class='o_field_integer o_field_number o_field_widget o_input']")
    public  WebElement guestElement;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm o_form_button_cancel']")
    public  WebElement discardElement;

    @FindBy(xpath ="//input[@class='o_field_integer o_field_number o_field_widget o_input']")
    public  WebElement guestElementR;

    public WebElement selectOrder(int i){
        return orders.get(i);
    }

}
