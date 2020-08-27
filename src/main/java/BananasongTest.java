// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class BananasongTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void bananasong() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(1269, 826));
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("banana song");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3*1000);
        js.executeScript("window.scrollTo(0,120)");
        {
            WebElement element = driver.findElement(By.cssSelector("#rso > .g:nth-child(2) .LC20lb"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector("#rso > .g:nth-child(2) .LC20lb")).click();
        driver.findElement(By.cssSelector(".ytp-play-button")).click();
        driver.findElement(By.cssSelector(".ytp-play-button")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".ytp-next-button"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        assertTrue(driver.getTitle().contains("YouTube"));
        WebElement count = driver.findElement(By.id("count"));
        String text = count.getText();

        driver.close();
    }
}
