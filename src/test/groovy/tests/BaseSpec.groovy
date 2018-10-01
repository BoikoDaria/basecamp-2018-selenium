package tests

import io.github.bonigarcia.wdm.WebDriverManager
import objects.CalculatorPage
import objects.ClassicCalculatorPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import spock.lang.Shared
import spock.lang.Specification

import java.sql.DriverManager

class BaseSpec extends Specification {

    @Shared
    WebDriver driver
    @Shared
    ClassicCalculatorPage c_calc
    @Shared
    CalculatorPage calc

    def setupSpec() {
        WebDriverManager.chromedriver().setup()
        ChromeOptions opt = new ChromeOptions().setHeadless(false)
        driver = new ChromeDriver(opt);
        calc = new CalculatorPage(driver)
        c_calc = new ClassicCalculatorPage(driver)
    }

    def cleanupSpec() {
        driver.quit();
    }
}