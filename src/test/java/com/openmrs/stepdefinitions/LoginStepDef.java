package com.openmrs.stepdefinitions;

import com.openmrs.pages.OpenMrsLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDef {

    WebDriver driver = DriverHelper.getDriver();
    OpenMrsLoginPage loginPage = new OpenMrsLoginPage(driver);

    @Given("User provides the username and password with {string}")
    public void user_provides_the_username_and_password_with(String location) {
        loginPage.login(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"), location);
    }

    @Then("User validates the {string} and {string}")
    public void user_validates_the_and(String expectedTitle, String expectedUrl) {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl().trim());
    }

    @Given("User provides {string} and {string} with {string}")
    public void user_provides_and_with(String username, String password, String location) {
        loginPage.login(username, password, location);
    }

    @Then("User validates the {string}")
    public void userValidatesThe(String expectedMessage) {
        Assert.assertEquals(expectedMessage,loginPage.validateMessage());
    }
}