package pages.user;

import enums.SocialTitle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.commons.MenuPage;

import java.util.List;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "customer_privacy")
    private WebElement customerPrivacyCbx;

    @FindBy(name = "psgdpr")
    private WebElement psgdprCbx;

    @FindBy(css = ".form-footer button")
    private WebElement saveBtn;
    @FindBy(name = "id_gender")
    private List<WebElement> genders;


    public RegistrationPage selectSocialTitle(SocialTitle socialTitle) {
        System.out.println("selecting " + socialTitle);
        switch (socialTitle) {
            case MR -> genders.get(0).click();
            case MRS -> genders.get(1).click();
            default -> throw new IllegalStateException("Unexpected value: " + socialTitle);
        }
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        sendKeys(this.firstName, firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        sendKeys(this.lastName, lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        sendKeys(this.email, email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        sendKeys(this.password, password);
        return this;
    }

    public RegistrationPage acceptPolices() {
        System.out.println("Accepting all required policies");
        customerPrivacyCbx.click();
        psgdprCbx.click();
        return this;
    }

    public MenuPage submitForm() {
        click(saveBtn);
        return new MenuPage(driver);
    }

}
