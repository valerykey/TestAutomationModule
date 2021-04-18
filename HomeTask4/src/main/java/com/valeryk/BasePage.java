package com.valeryk;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage extends Page {

    protected WebDriver driver;
    protected PropertyManager propertyManager;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected void enterTextIntoField(WebElement element, String text, Logger logger){
        logger.info("Entering text: \"" + text + "\" into field with XPath: " + element);
        Actions actions = new Actions(driver);
        actions.sendKeys(element, text).perform();
    }

    protected void pressKey(Keys key, Logger logger){
        logger.info("Pressing key: " + key.name());
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }

    protected void clickOnElement(WebElement element, Logger logger){
        logger.info("Clicking on element: " + element);
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

    protected void selectFromDropdownByVisibleText(WebElement element, String text, Logger logger){
        logger.info("Trying to select option: \"" + text + "\" from dropdown: " + element);
        Select dropdown = new Select(element);
        try {
            dropdown.selectByVisibleText(text);
        } catch (Exception e) {
            logger.error("Option cannot be selected from dropdown");
            throw e;
        }
    }
}
