package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    public Actions actions;
    public WebDriver driver;
    public WebDriverWait defaultWait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        initDriver(driver);
    }

    private void initDriver(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        defaultWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void sendKeys(WebElement element, String textToSet) {
        System.out.println("Typing: " + textToSet);
        element.sendKeys(textToSet);
    }

    public void sendKeysAndClear(WebElement element, String textToSet) {
        System.out.println("Clearing input");
        element.clear();
        sendKeys(element, textToSet);
    }

    public void click(WebElement element) {
        System.out.println("clicking on: " + element.getText().replace("\r\n", " "));
        element.click();
    }
}
