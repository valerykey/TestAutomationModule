package com.pageobject.steam;

import com.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductDetailsPage.class.getSimpleName());

    public static final By ADD_TO_CART_BUTTON = By.xpath("//input[@id='add-to-cart-button']");
    public static final By ADD_TO_CART_TEXT = By.xpath("//h1[@class='a-size-medium a-text-bold']");

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Add product to cart")
    public ProductDetailsPage addProductToCart(){
        logger.info("Trying to add selected product to cart");
        clickOnElement(ADD_TO_CART_BUTTON, logger);
        checkAddingToCart(ADD_TO_CART_TEXT, logger);
        return this;
    }

}
