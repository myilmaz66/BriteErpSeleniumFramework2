package com.briterp.pages;

import com.briterp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {

    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='o_main_content']//div[@class='o_kanban_view o_kanban_ungrouped']//strong)[position()>11]")
    public List<WebElement> productsNames;

    @FindBy(xpath = "//div[@class='o_main_content']//div[@class='o_kanban_view o_kanban_ungrouped']//strong")
    public List<WebElement> productsNamesSize;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement createButton;

    @FindBy(xpath = "(//div[@class='o_content']//img)[1]")
    public WebElement productPicture;

    @FindBy(xpath = "//span[contains(text(),'Apple In-Ear Headphones')]")
    public WebElement firstProductName;

    @FindBy(xpath = "(//div[@class='o_cp_right']//button[2])[3]")
    public WebElement listButton;

    @FindBy(xpath = "//span[@class='o_pager_value']")
    public WebElement pagerValue;

    @FindBy(xpath = "//span[@class='o_pager_limit']")
    public WebElement productTotalCount;







}
