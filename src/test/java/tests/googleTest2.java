package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.SearchPage;
import pages.SearchPage2;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTest2 {

    private static WebDriver driver;
    private static SearchPage2 searchPage2;

    @BeforeAll
    public static void startBrowser() {
        System.setProperty(
                "WebDriver.chrome.driver",
                "src/test/resources/chromedriver.exe"
        );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        searchPage2 = new SearchPage2(driver);
    }

    @BeforeEach
    public void startCalc() {
        driver.get("http://google.com");
        searchPage2.search("Calculator");

    }

    @Test
    @DisplayName("Кейс 2")
    public void test2() {
        searchPage2.input("6 / 0");
        assertAll(
                () -> assertEquals("6 / 0", SearchPage2.getCalcMemory()),
                () -> assertEquals("Infinity", SearchPage2.getResult())

        );

    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}