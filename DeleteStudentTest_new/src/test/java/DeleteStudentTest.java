import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.JsonToWebElementConverter;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.testng.annotations.*;

public class DeleteStudentTest {
    WebDriver driver;

    @BeforeClass
    public void BeforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeEachMethod() {
        driver.get("http://151.80.70.42:3000/");
    }

    @Test
    public void deleteStudent() throws InterruptedException {
        Thread.sleep(5000);
        int sizeBefore = driver.findElements(By.cssSelector("#user-list > li")).size();
        driver.findElement(By.cssSelector("#user-list > li:nth-child(10) > a.secondary-content")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        int sizeAfter = driver.findElements(By.cssSelector("#user-list > li")).size();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
        driver.quit();
    }
}