package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PointOfSalePage {
    public PointOfSalePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@data-menu='491']")
    public WebElement productsModuleButton;

    @FindBy(xpath = "//a[@class='oe_menu_toggler']//span[@class='oe_menu_text'][contains(text(),'Point of Sale')]")
    public WebElement pointOfSaleModuleButton;

    @FindBy (xpath = "//*[@class='ui-sortable']")
    public WebElement table;

    @FindBy (xpath = "//div[@class='o_sub_menu_content']//div[8]//ul[3]//li[1]//a[1]//span[1]")
    public WebElement orders;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm dropdown-toggle']")
    public WebElement measures;

    @FindBy(xpath = "//a[contains(text(),'Total Price')]")
    public  WebElement totalPrice;

    @FindBy(xpath = "//a[contains(text(),'Subtotal w/o discount')]")
    public  WebElement subTotalDiscount;

    @FindBy(xpath = "//a[contains(text(),'Total Discount')]")
    public WebElement totalDiscount;

    @FindBy(xpath = "//a[contains(text(),'Average Price')]")
    public WebElement averagePrice;

    @FindBy(xpath = "//a[contains(text(),'# of Lines')]")
    public WebElement ofLines;

    @FindBy(xpath = "//a[contains(text(),'Product Quantity')]")

    public WebElement productQuantity;

    @FindBy(xpath = "//a[contains(text(),'Delay Validation')]")
    public WebElement delayValidation;

    @FindBy(xpath = "//a[contains(text(),'Count')]")
    public WebElement count;

    @FindBy(xpath = "//button[@class='btn btn-default fa fa-bar-chart-o o_graph_button active']")
    public WebElement barChart;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[2]")
    public WebElement lineChart;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[3]")
    public WebElement pieChart;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[3]/button[1]")
    public WebElement graph;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[3]/button[2]")
    public WebElement pivot;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[1]")
    public WebElement flip;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[2]")
    public WebElement expand;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[3]")
    public WebElement download;


}
