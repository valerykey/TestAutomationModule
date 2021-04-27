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

public class AddToBasketSteps {
    private static final Logger logger = LogManager.getLogger(SearchSteps.class.getSimpleName());
    static final String SEARCH_PRODUCT_TITLE = "SWEATER";

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();

    @When("Customer adds product to basket from search")
    public void addProductsToBasket(){
        pageManager.homePage().searchByProductTitle(SEARCH_PRODUCT_TITLE);
        pageManager.searchResultPage().selectProduct();
    }

    @Then("Product should be present on basket page")
    public void checkProductOnBasketPage() {
        pageManager.homePage().waitForElementToBePresent(pageManager.productDetailsPage().ADD_TO_CART_BUTTON,1000);
        pageManager.productDetailsPage().addProductToCart();
        pageManager.homePage().waitForElementToBePresent(pageManager.productDetailsPage().ADD_TO_CART_TEXT,1000);
        Assert.assertEquals(pageManager.productDetailsPage().ADD_TO_CART_TEXT.getText(), "1 item in your cart");
    }

}
