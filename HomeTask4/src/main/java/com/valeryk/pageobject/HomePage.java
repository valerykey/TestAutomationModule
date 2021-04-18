package com.valeryk.pageobject;

import com.valeryk.BasePage;
import com.valeryk.PropertyManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    private final String HOME_PAGE_URL = propertyManager.getProperty("homepage.url");

    @FindBy(xpath = "//input[@id='chrome-search']")
    public static WebElement SEARCH_FIELD;

    @FindBy(xpath = "//div[@data-testid='cookie-disclaimer']//button")

    public static WebElement COOKIE_BUTTON;

    @FindBy(xpath = "//button[@data-testid='close-button' and @aria-label='Close']")
    public static WebElement CLOSE_BUTTON;



    public HomePage(WebDriver driver){
        super(driver);
       // PageFactory.initElements(this.driver, this);
    }

    @Step("Open application home page")
    public HomePage open(){
        logger.info("Trying to open application home page");
        driver.navigate().to(HOME_PAGE_URL);
        return this;
    }

    @Step("Accept cookies and close extra fields")
    public HomePage acceptCookies(){
        logger.info("Accepting cookies");
        clickOnElement(COOKIE_BUTTON, logger);
        clickOnElement(CLOSE_BUTTON, logger);
        return this;
    }

    @Step("Search for a product with name: {productTitle}")
    public HomePage searchByProductTitle(String productTitle){
        logger.info("Performing search for product with title: " + productTitle);
         enterTextIntoField(SEARCH_FIELD, productTitle, logger);
         pressKey(Keys.ENTER, logger);
        return this;
    }

}
