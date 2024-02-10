package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import providers.UrlProvider;

public class TestBase {
    public boolean isHeadless() {
        return false; // powinno być pobrane z pliku
    }

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        if (isHeadless()) {
            options.addArguments("--headless");
        }

        driver = new ChromeDriver(options);

        driver.get(UrlProvider.homePage);
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }


    public boolean isDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
