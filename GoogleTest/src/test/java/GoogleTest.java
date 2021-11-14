import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class GoogleTest {
    WebDriver driver;
    String searchWord;

    @BeforeClass
    public void BeforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/chromedriver.exe");
        driver = new ChromeDriver();
        searchWord = "formula 1";
    }

    @BeforeMethod
    public void BeforeEachMethod() {
        driver.get("https://google.com");
    }

    @Test
    public void openGoogleSearch() {
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void searchResult() {
        WebElement searchInput = driver.findElement(By.ByCssSelector.cssSelector("input[name='q']"));
        searchInput.sendKeys(searchWord);
        searchInput.sendKeys(Keys.ENTER);
        List<WebElement> result = driver.findElements(By.cssSelector("div[data-text-ad='1']"));
        result.addAll(driver.findElements(By.cssSelector("div[data-text-ad='1']")));

    }

    @AfterClass
    public void afterEachMethod() {
        driver.quit();
    }

}
