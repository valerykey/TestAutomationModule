package com.stepdefinitions;

import com.PropertyManager;
import com.context.CucumberStepContext;
import com.pageobject.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class BasicSteps {

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();

     @Given("Customer is on page with url {string}")
    public void openWebPage(String page){

        pageManager.open(PropertyManager.getProperty(page));
        pageManager.homePage().acceptCookies();
    }


}
