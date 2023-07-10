package com.openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class OpenMrsLoginPage {

    public OpenMrsLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//ul[@id='sessionLocation']//li")
    List<WebElement> locations;

    @FindBy(xpath = "//input[@id='loginButton']")
    WebElement loginButton;

    @FindBy(css = "#error-message")
    WebElement errorMessage;

    public void login(String username, String password, String location){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        chooseLocation(location);//why we call method inside the method (because it looks more professional,
        //rather I provide my all code inside login Method
        loginButton.click();
    }
    public String validateMessage() {
        return BrowserUtils.getText(errorMessage);
    }


    public void chooseLocation(String location){
        for (WebElement loctn : locations){
            if (BrowserUtils.getText(loctn).contains(location)){
                loctn.click();
                break;
            }
        }
    }
}