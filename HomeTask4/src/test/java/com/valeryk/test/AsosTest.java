package com.valeryk.test;

import com.valeryk.BaseTest;
import org.testng.annotations.Test;

public class AsosTest extends BaseTest {

    static final String SEARCH_TERM = "Nike";
    public final String SIZE = "US 5";

    @Test
    public void searchTest(){
        homePage.open().acceptCookies().searchByProductTitle(SEARCH_TERM);
        searchPage.selectProduct();
        productPage.selectSize(SIZE).addProductToCart();
    }
}
