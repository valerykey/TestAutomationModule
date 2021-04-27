package com.pageobject.steam;

import com.pageobject.BasePage;
import com.pageobject.PageManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SearchResultPage.class.getSimpleName());

    @FindBy(xpath="(//a[contains(@class, 'listing-link')])[1]")
    public static WebElement SEARCH_RESULTS_PRODUCT_TILES;
    @FindBy(xpath="(//div[@data-result-info]")
    public static WebElement SEARCH_INFO;

    public SearchResultPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }


    @Step("Select product in search results")
    public SearchResultPage selectProduct(){
        logger.info("Trying to select product from search results");
        clickOnElement(SEARCH_RESULTS_PRODUCT_TILES, logger);
        return this;
    }


}
