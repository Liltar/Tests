import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Locale;

public class DeleteStudentTest {
    WebDriver driver;

    @BeforeClass
    public void BeforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver.exe");
        driver = new ChomeDriver();
    }

    @BeforeMethod
    public void beforeEachMethod() {
        driver.get("http://151.80.70.42:3000/");
    }

    @Test
    public void deleteStudent() throws InterrupterException {
        Thread.sleep(5000);
        int sizeBefore = driver.findElements(By.cssSelector("#user-list > li")).size();
        System.out.println(sizeBefore);
        driver.findElement(By.cssSelector("#user-list > li:nth-child(2) > a.secondary-content")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
    }
}