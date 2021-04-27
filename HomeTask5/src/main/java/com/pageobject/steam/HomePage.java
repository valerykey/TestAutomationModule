package com.pageobject.steam;

import com.PropertyManager;
import com.pageobject.BasePage;
import com.pageobject.PageManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    private static final String HOME_PAGE_URL = PropertyManager.getProperty("homepage.url");
    private static final String PAGE_TITLE = PropertyManager.getProperty("homepage.title");
    private static final String SIGNIN_EMAIL = PropertyManager.getProperty("signin.email");
    private static final String SIGNIN_PASSWORD = PropertyManager.getProperty("signin.password");
    private static final String WRONG_PASSWORD = "test";

    @FindBy(xpath = "//input[@data-id='search-query']")
    public static WebElement SEARCH_FIELD;

    @FindBy(xpath = "//button[contains(@class, 'select-signin')]")
    public static WebElement SIGNIN_BUTTON;

    @FindBy(xpath = "//input[@name='email']")
    public static WebElement SIGNIN_EMAIL_FIELD;

    @FindBy(xpath = "//input[@name='password']")
    public static WebElement SIGNIN_PASSWORD_FIELD;

    @FindBy(xpath = "//div[contains(@class,'appears-ready')]//h1")
    public static WebElement WELCOME_MESSAGE;

    @FindBy(xpath = "//button[contains(text(),'Accept')]")
    public static WebElement ACCEPT_COOKIES_BUTTON;

    @FindBy(xpath = "//div[@id='aria-join_neu_password_field-error']")
    public static WebElement WRONG_PASSWORD_INFO;

    public HomePage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }

    @Step("Open application home page")
    public HomePage open(){
        logger.info("Trying to open application home page");
        openWebPage(HOME_PAGE_URL, logger);
        checkPageTitle(PAGE_TITLE, logger);
        return this;
    }

    @Step("Accept cookies")
    public HomePage acceptCookies(){
        logger.info("Accepting cookies");
        clickOnElement(ACCEPT_COOKIES_BUTTON, logger);
        return this;
    }

    @Step("Search for a product with name: {productTitle}")
    public HomePage searchByProductTitle(String productTitle){
        logger.info("Performing search for product with title: " + productTitle);
        enterTextIntoField(SEARCH_FIELD, productTitle, logger);
        pressKey(Keys.ENTER, logger);
        return this;
    }

    @Step("User sign in")
    public HomePage userSignIn() {
        logger.info("User is trying to sign in with right credentials");
        clickOnElement(SIGNIN_BUTTON,logger);
        waitForElementToBePresent(SIGNIN_EMAIL_FIELD,2000);
        enterTextIntoField(SIGNIN_EMAIL_FIELD, SIGNIN_EMAIL, logger);
        enterTextIntoField(SIGNIN_PASSWORD_FIELD, SIGNIN_PASSWORD, logger);
        pressKey(Keys.ENTER, logger);
        return this;
    }

    @Step("User sign in with wring password")
    public HomePage userSignInWithWrongPassword() {
        logger.info("User is trying to sign in with wrong password");
        clickOnElement(SIGNIN_BUTTON,logger);
        waitForElementToBePresent(SIGNIN_EMAIL_FIELD,2000);
        enterTextIntoField(SIGNIN_EMAIL_FIELD, SIGNIN_EMAIL, logger);
        enterTextIntoField(SIGNIN_PASSWORD_FIELD, WRONG_PASSWORD, logger);
        pressKey(Keys.ENTER, logger);
        return this;
    }
    public WebElement waitForElementToBePresent(WebElement element, long seconds) {
        return new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(element));
    }

}
