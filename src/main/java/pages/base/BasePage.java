package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected Actions actions;
    protected WebDriver driver;
    protected WebDriverWait defaultWait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        initDriver(driver);
    }

    private void initDriver(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        defaultWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void sendKeys(WebElement element, String textToSet) {
        System.out.println("Typing: " + textToSet);
        element.sendKeys(textToSet);
    }

    protected void sendKeysAndClear(WebElement element, String textToSet) {
        System.out.println("Clearing input");
        element.clear();
        sendKeys(element, textToSet);
    }

    protected void click(WebElement element) {
        System.out.println("clicking on: " + element.getText().replace("\r\n", " "));
        element.click();
    }
}
