package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.base.BasePage;
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

    // typy generyczne <T> - https://www.youtube.com/watch?v=K1iu1kXkVoA
    // refleksja - https://www.youtube.com/watch?v=bhhMJSKNCQY
    // ten kod przyjmuje nazwe klasy, która dziedzicy po TestBase i zwraca jej obiekt
    public <T extends BasePage> T at(Class<T> pageClass) {
        try {
            // poniżej to refleksja
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
