package pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;
import pages.user.LoginPage;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".user-info a")
    private WebElement loginBtn;
    @FindBy(css = ".account span")
    private WebElement userNameLabel;

    public String getUserName(){
        return userNameLabel.getText();
    }
    public LoginPage goToLogin() {
        click(loginBtn);
        return new LoginPage(driver);

    }
}
