import java.io.File;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;

import static org.junit.Assert.*;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasicScript {
    private static WebDriver driver;
    private String baseUrl;


    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Before
    public void setURL() {
        baseUrl = getAppPath();
    }

    @Test
    public void testAdd() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        assertEquals("6", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void testSubstract() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        assertEquals("0", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void testMultiply() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='x']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        assertEquals("8", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void testDiv() {
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


    private final String getAppPath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("calc.html").getFile());
        return file.getAbsolutePath();
    }


}
