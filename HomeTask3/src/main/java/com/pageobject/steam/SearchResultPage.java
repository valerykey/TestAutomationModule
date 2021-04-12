package com.pageobject.steam;

import com.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SearchResultPage.class.getSimpleName());

    public static final By SEARCH_RESULTS_PRODUCT_TILES = By.xpath("(//a[@class='a-link-normal a-text-normal'])[1]");

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Select product in search results")
    public SearchResultPage selectProduct(){
        logger.info("Trying to select product from search results");
        clickOnElement(SEARCH_RESULTS_PRODUCT_TILES, logger);
        return this;
    }
}
