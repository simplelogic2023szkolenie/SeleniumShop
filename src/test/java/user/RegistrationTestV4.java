package user;

import base.TestBase;
import com.github.javafaker.Faker;
import enums.SocialTitle;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.commons.MenuPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

public class RegistrationTestV4 extends Pages {
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

