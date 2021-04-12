package com.pageobject;

import com.actions.Elements;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {

    protected static WebDriver driver;

    static final String NAV_ARROW_XPATH = "//a[@id='nav-link-accountList']";
    static final String LINK_TO_SIGN_IN_XPATH = "//a[@class='nav-action-button']";
    static final String CONTINUE_BUTTON_XPATH = "//input[@id='continue']";
    static final String SIGN_IN_BUTTON_XPATH = "//input[@id='signInSubmit']";
    static final String EMAIL_FIELD_XPATH = "//input[@id='ap_email']";
    static final String PASSWORD_FIELD_XPATH = "//input[@id='ap_password']";
    static final String HELLO_USER_XPATH = "//span[@id='nav-link-accountList-nav-line-1']";

    protected void checkPageTitle(String title, Logger logger){
        logger.info("Verifying if page title is equal to: " + title);
        Assert.assertEquals(driver.getTitle(), title);
        logger.info("Page title is correct: \"" + title + "\"");
    }

    protected void checkAddingToCart(By xpath, Logger logger){
        logger.info("Verifying if product is added to cart");
        Assert.assertEquals(driver.findElement(xpath).getText(),"Added to Cart");
        logger.info("Product is added to cart ");
    }

    protected void openWebPage(String url, Logger logger){
        logger.info("Navigating to website with url:   " + url);
        driver.navigate().to(url);
    }

    protected void enterTextIntoField(By xpath, String text, Logger logger){
        logger.info("Entering text: \"" + text + "\" into field with XPath: " + xpath);
        Actions actions = new Actions(driver);
        actions.sendKeys(Elements.findElement(xpath, driver, logger),text).perform();
    }

    protected void pressKey(Keys key, Logger logger){
        logger.info("Pressing key: " + key.name());
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }
    protected void clickSignIn(Logger logger){
        logger.info("Finding Sign In button on the main page and click it");
        Actions builder = new Actions(driver);
        //WebElement element = driver.findElement(xpath);
        builder.moveToElement(driver.findElement(By.xpath(NAV_ARROW_XPATH))).perform();
        waitForElementToBePresent(LINK_TO_SIGN_IN_XPATH, 20).click();
    }

    protected void fillSignInFields(String email, String password, Logger logger){
        logger.info("Filling an email field");
        driver.findElement(By.xpath(EMAIL_FIELD_XPATH)).sendKeys(email);
        driver.findElement(By.xpath(CONTINUE_BUTTON_XPATH)).click();
        logger.info("Filling a password field");
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys(password);
        logger.info("Clicking sign in button");
        driver.findElement(By.xpath(SIGN_IN_BUTTON_XPATH)).click();
        logger.info("Checking of sign in");
        Assert.assertEquals(driver.findElement(By.xpath(HELLO_USER_XPATH)).getText(),"Hello, QA");

    }

    protected void clickOnElement(By xpath, Logger logger){
        clickOnElement(xpath, -1, logger);
    }

    protected void clickOnElement(By xpath, int position, Logger logger){
        logger.info("Clicking on element with xpath: " + xpath);
        Actions actions = new Actions(driver);
        actions.click(Elements.findElement(xpath, position, driver, logger)).perform();
    }

    private static WebElement waitForElementToBePresent(String xPath, long seconds) {
        return new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }
}
