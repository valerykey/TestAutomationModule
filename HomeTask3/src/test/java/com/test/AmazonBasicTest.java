package com.test;

import com.BaseTest;
import org.testng.annotations.Test;

public class AmazonBasicTest extends BaseTest {

    static final String SEARCH_TERM = "Nintendo Switch";

    @Test
    public void searchTest(){
        homePage.open();
        signInPage.signIn();
        homePage.searchByProductTitle(SEARCH_TERM);
        searchResultsPage.selectProduct();
        productDetailsPage.addProductToCart();
    }
}
