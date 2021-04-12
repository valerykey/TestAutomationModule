package com.pageobject.steam;

import com.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductDetailsPage.class.getSimpleName());
    static final String EMAIL= "seleniumtest2021@mail.ru";
    static final String PASSWORD= "seleniumtest123";

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Sign in")
    public SignInPage signIn() {
        clickSignIn(logger);
        fillSignInFields(EMAIL,PASSWORD, logger);
        return this;
    }
}
