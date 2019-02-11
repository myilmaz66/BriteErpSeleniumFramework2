package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CountryGroupsPage {
    public CountryGroupsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='modal-body o_act_window']//div//tbody[@class='ui-sortable']//tr//td//div//input")
    public List<WebElement> checkBoxes;

    @FindBy(xpath = " //div[@class='modal-footer']//button[1]")
    public WebElement selecButton;

    @FindBy(xpath = "//div[@class='modal-body o_act_window']//div//tbody[@class='ui-sortable']" +
            "//tr//td[@class='o_data_cell o_required_modifier']")
    public List<WebElement> countryGroupsNames;



}
