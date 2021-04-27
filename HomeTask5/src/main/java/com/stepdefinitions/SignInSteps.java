package com.stepdefinitions;

import com.PropertyManager;
import com.context.CucumberStepContext;
import com.pageobject.PageManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class SignInSteps {
    private static final Logger logger = LogManager.getLogger(SearchSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();


    @When("Customer sign in with right credentials")
    public void customerSignInWithRightInfo() {
        pageManager.homePage().userSignIn();
    }

    @When("Customer sign in with wrong credentials")
    public void customerSignInWithWrongPassword() {
        pageManager.homePage().userSignInWithWrongPassword();
    }


    @Then("Home page contains message {string}")
    public void homePageContainsMessage(String welcomeMessage) {
        logger.info("Checking if home page contains message " + propertyManager.getProperty(welcomeMessage));
        pageManager.homePage().waitForElementToBePresent(pageManager.homePage().WELCOME_MESSAGE,1000);
        Assert.assertEquals(pageManager.homePage().WELCOME_MESSAGE.getText(), propertyManager.getProperty(welcomeMessage));
    }

    @Then("Field contains message 'Password was incorrect'")
    public void fieldContainsMessage(String welcomeMessage) {
        logger.info("Checking if home page contains message 'Password was incorrect'");
        Assert.assertEquals(pageManager.homePage().WRONG_PASSWORD_INFO.getText(),"Password was incorrect");
    }

}
