package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orders2Page {
    public Orders2Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='o_sub_menu_content']/div[8]/ul[1]/li[1]/a[1]/span[1]")
    public WebElement ordersLink;
}
