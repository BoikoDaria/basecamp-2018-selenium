import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicScript {
    private static WebDriver driver;
    private static String baseUrl;


    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "file:///D:/work/GlobalLogic/Trainings/BootCamp/code/calc.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAdd()
    {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        assertEquals("4", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void testSubstract()
    {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        assertEquals("0", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void testMultiply()
    {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='x']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        assertEquals("8", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void testDiv()
    {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='/']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        assertEquals("2", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
     }


}