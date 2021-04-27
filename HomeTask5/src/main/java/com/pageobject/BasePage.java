package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class BasePage {

    protected WebDriver driver;
    protected PageManager pageManager;


    public BasePage(WebDriver driver,PageManager pageManager){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.pageManager = pageManager;
    }

    protected void openWebPage(String url, Logger logger){
        logger.info("Navigating to website with url:   " + url);
        driver.navigate().to(url);
    }

    protected void checkPageTitle(String title, Logger logger){
        logger.info("Verifying if page title is equal to: " + title);
        Assert.assertEquals(driver.getTitle(), title);
        logger.info("Page title is correct: \"" + title + "\"");
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

    protected void checkAddingToCart(WebElement element, Logger logger){
        logger.info("Verifying if product is added to cart");
        Assert.assertEquals(element.getText(),"1 item in your cart");
        logger.info("Product is added to cart ");
    }


    protected void clickOnElement(WebElement element, Logger logger){
        logger.info("Clicking on element: " + element);
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

   /* protected void clickOnElement(By xpath, int position, Logger logger){
        logger.info("Clicking on element with xpath: " + xpath);
        Actions actions = new Actions(driver);
        actions.click(Elements.findElement(xpath, position, driver, logger)).perform();
    }*/

   /* protected WebElement waitForElementToBePresent(WebElement element, long seconds) {
        return new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(element));
    }*/
}
