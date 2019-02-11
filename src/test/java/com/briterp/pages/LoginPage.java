package com.briterp.pages;

import com.briterp.utilities.ConfigurationReader;
import com.briterp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "login")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement logInButton;

    @FindBy(xpath = "//*[@class='alert alert-danger']")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement signInButton;


    public void positiveLogIn() {
        emailBox.sendKeys(ConfigurationReader.getProperty("username"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        logInButton.click();
    }


}
