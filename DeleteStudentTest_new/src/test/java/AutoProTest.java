import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class AutoProTest {
    WebDriver driver;

    @BeforeClass
    public void BeforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeEachMethod() {
        driver.get("https://avto.pro/");
    }

    @Test
    public void CheckCssImportMethods() throws InterruptedException {
        Thread.sleep(5000);
        int styleElementsCount = driver.findElements(By.cssSelector("style")).size();
        Assert.assertEquals(styleElementsCount, 0);
        Thread.sleep(2000);
    }

    @Test
    public void CheckCssImportsCount() throws InterruptedException {
        Thread.sleep(5000);
        int styleElementsCount = driver.findElements(By.cssSelector("link[rel=\"stylesheet\"]")).size();
        Assert.assertEquals(styleElementsCount, 0);
        Thread.sleep(2000);
    }

    @Test
    public void CheckJsImportMethods() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElements(By.cssSelector("script")).forEach(elem -> {
            if (elem.getText() != "") {
                Assert.fail();
            }
        });
        Thread.sleep(2000);
    }

    @Test
    public void CheckJsImportsOnce() throws InterruptedException {
        Thread.sleep(5000);
        int jsElementsCount = driver.findElements(By.cssSelector("script[src]")).size();
        Assert.assertEquals(jsElementsCount, 1);
        Thread.sleep(2000);
    }

    @Test
    public void CheckIdsUnique() throws InterruptedException {
        Thread.sleep(5000);
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> seenIds = new ArrayList<>();
        driver.findElements(By.cssSelector("[id]")).forEach(elem -> {
            ids.add(elem.getAttribute("id"));
        });
        ids.forEach(id -> {
            if (seenIds.contains(id)) {
                Assert.fail();
            }
            seenIds.add(id);
        });
        Thread.sleep(2000);
    }
}