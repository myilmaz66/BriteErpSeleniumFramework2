package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){ PageFactory.initElements(Driver.getDriver(),this); }



}
