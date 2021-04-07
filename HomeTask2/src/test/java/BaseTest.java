import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    static WebDriver driver;
    static final String CHROME_DRIVER_PATH = "D:\\Work\\chromedriver.exe";
    static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    static final String SEARCH_TERM = "Nintendo Switch";
    static final String SEARCH_FIELD_XPATH = "//input[@id='twotabsearchtextbox']";
    static final String SEARCH_BUTTON_XPATH = "//input[@id='nav-search-submit-button']";

    static SoftAssert softAssert;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
