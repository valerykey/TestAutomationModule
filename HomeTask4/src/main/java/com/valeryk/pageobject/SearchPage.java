package com.valeryk.pageobject;

import com.valeryk.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//article[starts-with(@id, 'product')][1]/a")
    public static WebElement FIRST_PRODUCT;

    @Step("Go to the product page")
    public SearchPage selectProduct(){
        logger.info("Selecting product from list of results");
        clickOnElement(FIRST_PRODUCT, logger);
        return this;
    }
}
