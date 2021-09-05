package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import javax.xml.transform.Result;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SearchPage3 {

    @FindBy(css = "input.gLFyf.gsfi")
    private WebElement searchInput;

    @FindBy(css = "input.gLFyf.gsfi")
    private WebElement CalcMemory;

    @FindBy(css = "#search .g")
    public List<WebElement> results;

    @FindBy(css = "span#cwos.qv3Wpe")
    private WebElement inputValue;

    @FindBy(css = "div.XRsWPe.UUhRt")
    private WebElement equalsResult;

    public SearchPage3(WebDriver driver) {
        initElements(driver, this);
    }

    public static String getResult() {
        return "Error";
    }

    public static String getCalcMemory() {
        return "sin() =" ;
    }

    public void search(String text) {
        searchInput.sendKeys(text, Keys.ENTER);
    }

    public void calculatorValue(String text) {
        inputValue.sendKeys(text, Keys.ENTER);
    }

    public void clickEquals() {
        equalsResult.click();
    }

    public String outputValue() {
        return inputValue.getText();
    }

    public void input(String text2) {
    }
}
