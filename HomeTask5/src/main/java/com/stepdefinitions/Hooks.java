package com.stepdefinitions;

import com.PropertyManager;
import com.context.CucumberStepContext;
import com.pageobject.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;

public class Hooks {

    @Before
    public void setup(){
     //   CucumberStepContext.getInstance().setPropertyManager(new PropertyManager("default.properties"));
        CucumberStepContext.getInstance().setDriver(new ChromeDriver());
        CucumberStepContext.getInstance().setPageManager( new PageManager(CucumberStepContext.getInstance().getDriver()));
    }

    @After
    public void cleanUp(){
        CucumberStepContext.getInstance().getDriver().quit();
    }

}
