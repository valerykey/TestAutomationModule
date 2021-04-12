package com;

import com.listeners.TestReporter;
import com.listeners.TestResultsListener;
import com.pageobject.steam.HomePage;
import com.pageobject.steam.ProductDetailsPage;
import com.pageobject.steam.SearchResultPage;
import com.pageobject.steam.SignInPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({TestResultsListener.class, TestReporter.class})
public abstract class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage = null;
    protected SearchResultPage searchResultsPage = null;
    protected ProductDetailsPage productDetailsPage = null;
    protected SignInPage signInPage = null;

    public static final Logger assertLogger = LogManager.getLogger("Assert");

    static final String CHROME_DRIVER_PATH = "D:\\Work\\chromedriver.exe";

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        signInPage = new SignInPage(driver);
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
