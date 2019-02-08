package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WholeFoodsStorePage {

    public WholeFoodsStorePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(xpath = "//button[@class='button set-customer ']")
    public WebElement customerButton;

    @FindBy(xpath = "//*[@placeholder='Search Customers']")
    public WebElement searchCustomer;

    @FindBy(xpath = "//*[@data-id='40']/td[1]")
            public WebElement customerNameTable;

    @FindBy(xpath = "//*[@class='button next highlight']")
    public WebElement setCustomer;


    @FindBy(xpath = "(//*[@class='input-button number-char'])[5]")
    public WebElement number5;

    @FindBy(xpath = "(//*[@class='input-button number-char'])[10]")
    public WebElement number0;


    @FindBy(xpath = "//*[contains(text(),'Honda')]")
    public WebElement hondaAccord;

    @FindBy (xpath = "//*[@class='order']")
    public WebElement cart;

    @FindBy (xpath = "//*[@data-mode='discount']")
    public WebElement discountButton;


    @FindBy (xpath = "//*[@data-mode='discount']")
    public WebElement discountButtonGreen;





//   public String customerNameSearch = "Morgan Rose";
   //   public String customerNameSet = customerButton.getText();

}
