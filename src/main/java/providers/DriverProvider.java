package providers;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverProvider {
    public static WebDriver getDriver(Browser browser){
        switch (browser) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                return new ChromeDriver(options);
            }
            case FIREFOX -> {
                return new FirefoxDriver();
            }
            case EDGE -> {
                return new EdgeDriver();
            }
            case IE -> {
                return new InternetExplorerDriver();
            }
            default -> throw new IllegalStateException("Unexpected value: " + browser);
        }
    };
}
