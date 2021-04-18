package com.valeryk;

import com.valeryk.PropertyManager;
import com.valeryk.drivers.DriverManager;
import com.valeryk.listeners.TestReporter;
import com.valeryk.listeners.TestResultsListener;
import com.valeryk.pageobject.HomePage;
import com.valeryk.pageobject.ProductPage;
import com.valeryk.pageobject.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.Locale;

@Listeners({TestResultsListener.class, TestReporter.class})
public abstract class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final Logger assertLogger = LogManager.getLogger("Assert");

    protected DriverManager driverManager;
    protected PropertyManager propertyManager;

    protected HomePage homePage;
    protected SearchPage searchPage;
    protected ProductPage productPage;

    @Parameters({"browserName","testDataFileName"})
    @BeforeClass
    public void setup(@Optional("Chrome") String browserName,
                      @Optional("default.properties") String testDataFileName){
        driverManager = new DriverManager();
        driver.set(driverManager.getDriver(browserName, "Grid"));
        ITestContext context = Reporter.getCurrentTestResult().getTestContext();
        context.setAttribute("WebDriver", driver.get());
        System.out.println(driver.get());
      //  propertyManager = new PropertyManager();
        homePage = new HomePage(driver.get());
        searchPage = new SearchPage(driver.get());
        productPage = new ProductPage(driver.get());
    }

    @AfterMethod
    public void browserReset(){
        driver.get().manage().deleteAllCookies();

    }

    @AfterClass
    public void cleanUp(){
        driver.get().quit();
        driver.remove();
    }

}
