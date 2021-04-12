package com.actions;


import java.time.Duration;
import com.LogUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {

    public static WebElement findElement(By xpath, WebDriver driver, Logger logger){
        return findElement(xpath, -1, driver, logger);
    }

    public static WebElement findElement(By xpath, int position, WebDriver driver, Logger logger){
        WebElement element = null;
        try{
            if(position == -1)
                element = driver.findElement(xpath);
            else
                element = driver.findElements(xpath).get(position-1);
        } catch (Exception e) {
            logger.error(" Element with XPath: " + xpath + "  was not found on the page." );
            LogUtil.logStackTrace(e, logger);
        }
        return element;
    }


    public static WebElement findElementWithWait(By xpath, WebDriver driver, Logger logger){
        WebElement element = null;
        try{
            element = new WebDriverWait(driver, 3, 1)
                    .until(ExpectedConditions.presenceOfElementLocated(xpath));
        } catch (Exception e) {
            logger.error(" ---- Element with XPath: " + xpath + "  was not found on the page." );
            LogUtil.logStackTrace(e, logger);
        }
        return element;
    }
}