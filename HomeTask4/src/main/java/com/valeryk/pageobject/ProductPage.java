package com.valeryk.pageobject;

import com.valeryk.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());

    @FindBy(xpath="//select[@data-id='sizeSelect']")
    public static WebElement SELECT_DROPDOWN;

    @FindBy(xpath="//button[@data-test-id='add-button']")
    public static WebElement ADD_TO_CART_BUTTON;


    @Step("Select size from dropdown")
    public ProductPage selectSize(String size){
        logger.info("Selecting size of product from dropdown");
        selectFromDropdownByVisibleText(SELECT_DROPDOWN,size,logger);
        return this;
    }

    @Step("Add product to cart")
    public ProductPage addProductToCart(){
        logger.info("Adding product to cart");
        clickOnElement(ADD_TO_CART_BUTTON, logger);
        return this;
    }
}
