import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{

    static final String FIRST_ITEM_XPATH = "(//a[@class='a-link-normal a-text-normal'])[1]";
    static final String ADD_TO_CART_BUTTON = "//input[@id='add-to-cart-button']";
    static final String ADD_TO_CART_TEXT = "//h1[@class='a-size-medium a-text-bold']";

    @Test
    public void basicAddToCartTest(){
        driver.navigate().to(AMAZON_HOME_PAGE_URL);
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(SEARCH_TERM);
        driver.findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();
        driver.findElement(By.xpath(FIRST_ITEM_XPATH)).click();
        driver.findElement(By.xpath(ADD_TO_CART_BUTTON)).click();
        softAssert.assertEquals(driver.findElement(By.xpath(ADD_TO_CART_TEXT)).getText(),"Added to Cart");
        softAssert.assertAll();
    }
}
