import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExistedAccountTest extends BaseTest{

    static final String NAV_ARROW_XPATH = "//a[@id='nav-link-accountList']";
    static final String LINK_TO_CREATE_XPATH = "//a[@class='nav-a']";
    static final String NAME_FIELD_XPATH = "//input[@id='ap_customer_name']";
    static final String EMAIL_FIELD_XPATH = "//input[@id='ap_email']";
    static final String PASSWORD_FIELD_XPATH = "//input[@id='ap_password']";
    static final String PASSWORD_CHECK_FIELD_XPATH = "//input[@id='ap_password_check']";
    static final String CONTINUE_BUTTON_XPATH = "//input[@id='continue']";
    static final String ALERT_XPATH = "//div[@class='a-box a-alert a-alert-warning a-spacing-base']//child::h4";
    static final String WRONG_EMAIL_ALERT = "//div[contains(text(), 'Enter a valid email address')]";
    static final String NO_NAME_ALERT = "//div[contains(text(), 'Enter your name')]";
    static final String MATCH_PASSWORDS_ALERT = "//div[contains(text(), 'Passwords must match')]";
    static final String NAME_FIELD = "QA Engineer";
    static final String EMAIL_FIELD = "seleniumtest2021@mail.ru";
    static final String WRONG_EMAIL_FIELD = "seleniumtest2021";
    static final String PASSWORD_FIELD = "123test";
    static final String WRONG_PASSWORD_FIELD = "123";
    static final String ALERT_TEXT = "Email address already in use";

    @Test
    public void basicExistedAccountTest(){
        driver.navigate().to(AMAZON_HOME_PAGE_URL);
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(NAV_ARROW_XPATH));
        builder.moveToElement(element).perform();
        waitForElementToBePresent(LINK_TO_CREATE_XPATH, 20).click();
        driver.findElement(By.xpath(NAME_FIELD_XPATH)).sendKeys(NAME_FIELD);
        driver.findElement(By.xpath(EMAIL_FIELD_XPATH)).sendKeys(EMAIL_FIELD);
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys(PASSWORD_FIELD);
        driver.findElement(By.xpath(PASSWORD_CHECK_FIELD_XPATH)).sendKeys(PASSWORD_FIELD);
        driver.findElement(By.xpath(CONTINUE_BUTTON_XPATH)).click();

        softAssert.assertEquals(driver.findElement(By.xpath(ALERT_XPATH)).getText(),ALERT_TEXT);
        softAssert.assertAll();
    }

    @Test
    public void basicUserInformationTest(){
        driver.navigate().to(AMAZON_HOME_PAGE_URL);
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(NAV_ARROW_XPATH));
        builder.moveToElement(element).perform();
        waitForElementToBePresent(LINK_TO_CREATE_XPATH, 20).click();
      ///  driver.findElement(By.xpath(NAME_FIELD_XPATH)).sendKeys(NAME_FIELD);
        driver.findElement(By.xpath(EMAIL_FIELD_XPATH)).sendKeys(WRONG_EMAIL_FIELD);
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys(PASSWORD_FIELD);
        driver.findElement(By.xpath(PASSWORD_CHECK_FIELD_XPATH)).sendKeys(WRONG_PASSWORD_FIELD);
        driver.findElement(By.xpath(CONTINUE_BUTTON_XPATH)).click();

        softAssert.assertTrue(driver.findElement(By.xpath(NO_NAME_ALERT)).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath(WRONG_EMAIL_ALERT)).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath(MATCH_PASSWORDS_ALERT)).isDisplayed());
        softAssert.assertAll();
    }

    private static WebElement waitForElementToBePresent(String xPath, long seconds) {
        return new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }

}
