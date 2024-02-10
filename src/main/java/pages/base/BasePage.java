package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public Actions actions;
    public WebDriver driver;
    public WebDriverWait defaultWait;
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        initDriver(driver);
    }

    private void initDriver(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        defaultWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


}
