package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTest {

    private static WebDriver driver;
    private static SearchPage searchPage;

    @BeforeAll
    public static void startBrowser() {
        System.setProperty(
                "WebDriver.chrome.driver",
                "src/test/resources/chromedriver.exe"
        );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
    }

    @BeforeEach
    public void startCalc() {
        driver.get("http://google.com");
        searchPage.search("Calculator");

    }

    @Test
    @DisplayName("Кейс 1")
    public void test1() {
        searchPage.input("(1 + 2) * (3) -40 /5");
        assertAll(
                () -> assertEquals("(1 + 2) * (3) -40 /5", SearchPage.getCalcMemory()),
                () -> assertEquals("1", SearchPage.getResult())

        );

    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}
