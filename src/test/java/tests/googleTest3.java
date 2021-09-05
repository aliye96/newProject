package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.SearchPage;
import pages.SearchPage3;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTest3 {

    private static WebDriver driver;
    private static SearchPage3 searchPage3;

    @BeforeAll
    public static void startBrowser() {
        System.setProperty(
                "WebDriver.chrome.driver",
                "src/test/resources/chromedriver.exe"
        );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        searchPage3 = new SearchPage3(driver);
    }

    @BeforeEach
    public void startCalc() {
        driver.get("http://google.com");
        searchPage3.search("Calculator");

    }

    @Test
    @DisplayName("Кейс 3")
    public void test3() {
        searchPage3.input("(1 + 2) * (3) -40 /5");
        assertAll(
                () -> assertEquals("sin() =", SearchPage3.getCalcMemory()),
                () -> assertEquals("Error", SearchPage3.getResult())

        );

    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}