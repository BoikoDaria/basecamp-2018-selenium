import java.io.File;
import java.util.concurrent.TimeUnit;

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
}

    @Before
    public void setURL() {
        baseUrl = "file://" + getAppPath();
        System.out.println(baseUrl);
    }

    @Test
    public void testAdd() {
        driver.get(baseUrl);
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("=")).click();
        assertEquals("4", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void testSubstract() {
        driver.get(baseUrl);
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("-")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("=")).click();
        assertEquals("0", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void testMultiply() {
        driver.get(baseUrl);
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("x")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("=")).click();
        assertEquals("8", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void testDiv() {
        driver.get(baseUrl);
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("/")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("=")).click();
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
