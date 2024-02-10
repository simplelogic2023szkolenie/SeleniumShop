package user;

import base.TestBase;
import com.github.javafaker.Faker;
import enums.SocialTitle;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.commons.MenuPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

public class RegistrationTestV3 extends TestBase {
    MenuPage menuPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void testSetup() {
        menuPage = new MenuPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void shouldRegisterNewUser() {
        menuPage.goToLogin();

        loginPage.goToRegistration();

        registrationPage
                .setFirstName("jan")
                .setLastName("kowalski")
                .setEmail(new Faker().internet().emailAddress())
                .setPassword("pass1234")
                .acceptPolices()
                .selectSocialTitle(SocialTitle.MR)
                .submitForm();

        String actualUserName = menuPage.getUserName();

        Assertions.assertThat(actualUserName).isEqualTo("jan kowalski");
    }


}

/*
Wejdź na stronę http://146.59.32.4/index.php
- Kliknij przycisk Sign in
- Po przeniesieniu do strony logowanie kliknij przycisk No account? Create one here
*/

