import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    static final String AMAZON_HOME_PAGE_TITLE = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    static final String SEARCH_RESULTS_BREADCRUMB_XPATH = "//*[contains(@class,'s-breadcrumb')]//span[@class='a-color-state a-text-bold']";
    static final String SEARCH_RESULTS_XPATH = "(//*[contains(text(), 'Nintendo Switch')])[1]";
    @Test
    public void basicProductSearch(){
        driver.navigate().to(AMAZON_HOME_PAGE_URL);   // you can also use driver.get("AMAZON_HOME_PAGE_URL");
        String pageTitle = driver.getTitle();
        softAssert.assertEquals(pageTitle, AMAZON_HOME_PAGE_TITLE);
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(SEARCH_TERM);
        driver.findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();
        softAssert.assertTrue(driver.findElement(By.xpath(SEARCH_RESULTS_BREADCRUMB_XPATH)).isDisplayed());
        softAssert.assertNotNull(driver.findElements(By.xpath(SEARCH_RESULTS_XPATH)));
        softAssert.assertAll();
    }

}
