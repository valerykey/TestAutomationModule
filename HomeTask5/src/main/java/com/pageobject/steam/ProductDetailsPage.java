package com.pageobject.steam;

import com.pageobject.BasePage;
import com.pageobject.PageManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductDetailsPage.class.getSimpleName());
    @FindBy(xpath="//form[@class='add-to-cart-form']//button")
    public static WebElement ADD_TO_CART_BUTTON;
    @FindBy(xpath="//h1[@class='wt-text-heading-01']")
    public static WebElement ADD_TO_CART_TEXT;

    public ProductDetailsPage(WebDriver driver,
                              PageManager pageManager) {
        super(driver, pageManager);
    }


    @Step("Add product to cart")
    public ProductDetailsPage addProductToCart(){
        logger.info("Trying to add selected product to cart");
        clickOnElement(ADD_TO_CART_BUTTON, logger);
       // checkAddingToCart(ADD_TO_CART_TEXT, logger);
        return this;
    }

}
