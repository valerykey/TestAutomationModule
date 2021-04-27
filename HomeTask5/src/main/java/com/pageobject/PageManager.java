package com.pageobject;

import com.pageobject.steam.HomePage;
import com.pageobject.steam.ProductDetailsPage;
import com.pageobject.steam.SearchResultPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PageManager {
    private static final Logger logger = LogManager.getLogger(PageManager.class.getSimpleName());

    public WebDriver driver;
    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;
    private SearchResultPage searchResultPage;

    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage homePage(){
        if(homePage == null)
            homePage = new HomePage(driver, this);
        return homePage;
    }

    public ProductDetailsPage productDetailsPage(){
        if(productDetailsPage == null)
            productDetailsPage = new ProductDetailsPage(driver, this);
        return productDetailsPage;
    }

    public SearchResultPage searchResultPage(){
        if(searchResultPage == null)
            searchResultPage = new SearchResultPage(driver, this);
        return searchResultPage;
    }

    public PageManager open(String url){
        logger.info("Opening page with url: " + url);
        driver.navigate().to(url);
        return this;
    }


}
