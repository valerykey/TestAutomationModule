package com.stepdefinitions;

import com.PropertyManager;
import com.context.CucumberStepContext;
import com.pageobject.PageManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchSteps {

    private static final Logger logger = LogManager.getLogger(SearchSteps.class.getSimpleName());
    static final String SEARCH_PRODUCT_TITLE = "SWEATER";

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();

    @When("Customer enters product to search form")
    public void selectProduct(){
        pageManager.homePage().searchByProductTitle(SEARCH_PRODUCT_TITLE);
    }

    @Then("Customer redirected to a search page")
    public void checkSearchPage(){
        Assert.assertTrue(pageManager.searchResultPage().SEARCH_INFO.isDisplayed());
    }

}
