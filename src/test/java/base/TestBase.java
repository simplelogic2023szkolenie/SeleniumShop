package base;


import configuration.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.base.BasePage;
import providers.DriverProvider;
import providers.UrlProvider;

import java.util.function.Consumer;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverProvider.getDriver(Config.getBrowser());

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

    // https://www.youtube.com/watch?v=tj5sLSFjVj4
    // poniżej interfej fukncyjny consumer, powoduje ze na obiekcie stowrzonej klasy
    // uruchamiamy jej metody poprzed consumer
    public <T extends BasePage> void at(Class<T> pageClass, Consumer<T> consumer) {
        try {
            // poniżej to refleksja
            T page = pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
            consumer.accept(page);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
