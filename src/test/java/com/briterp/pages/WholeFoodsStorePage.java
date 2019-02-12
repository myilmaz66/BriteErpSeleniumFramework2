package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WholeFoodsStorePage {

    public WholeFoodsStorePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div[2]/div/div/div[2]/button[1]")
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


    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td/div/div/div/div/span[18]/div[1]/img")
    public WebElement hondaAccord;

    @FindBy (xpath = "(//*[@class='value'])[1]")
    public WebElement cart;

    @FindBy (xpath = "//*[@data-mode='discount']")
    public WebElement discountButton;


    @FindBy (xpath = "//*[@data-mode='discount']")
    public WebElement discountButtonGreen;



    //button[@class='button set-customer ']
//*[contains(text(),'Honda')]
   public String customerNameSearch = "Morgan Rose";
   //   public String customerNameSet = customerButton.getText();
    public String urlSetCustomer = "http://52.39.162.23/pos/web/#action=pos.ui";

}
