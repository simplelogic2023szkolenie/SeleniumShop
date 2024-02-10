package pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".user-info a")
    private WebElement loginBtn;

    public void goToLogin() {
        click(loginBtn);
    }
}
