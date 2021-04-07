import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UserSignInTest extends BaseTest{

    static final String NAV_ARROW_XPATH = "//a[@id='nav-link-accountList']";
    static final String LINK_TO_SIGN_IN_XPATH = "//a[@class='nav-action-button']";
    static final String EMAIL_FIELD_XPATH = "//input[@id='ap_email']";
    static final String PASSWORD_FIELD_XPATH = "//input[@id='ap_password']";
    static final String CONTINUE_BUTTON_XPATH = "//input[@id='continue']";
    static final String SIGN_IN_BUTTON_XPATH = "//input[@id='signInSubmit']";
    static final String HELLO_USER_XPATH = "//span[@id='nav-link-accountList-nav-line-1']";
    static final String EMAIL= "seleniumtest2021@mail.ru";
    static final String PASSWORD= "seleniumtest123";

    @Test
    public void basicSignInTest() throws InterruptedException {
        driver.navigate().to(AMAZON_HOME_PAGE_URL);
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(NAV_ARROW_XPATH));
        builder.moveToElement(element).perform();
        waitForElementToBePresent(LINK_TO_SIGN_IN_XPATH, 20).click();
        driver.findElement(By.xpath(EMAIL_FIELD_XPATH)).sendKeys(EMAIL);
        driver.findElement(By.xpath(CONTINUE_BUTTON_XPATH)).click();
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(SIGN_IN_BUTTON_XPATH)).click();
        softAssert.assertEquals(driver.findElement(By.xpath(HELLO_USER_XPATH)).getText(),"Hello, QA");
        softAssert.assertAll();
    }

    private static WebElement waitForElementToBePresent(String xPath, long seconds) {
        return new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }
}
