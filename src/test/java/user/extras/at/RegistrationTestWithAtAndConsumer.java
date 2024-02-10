package user.extras.at;

import base.TestBase;
import com.github.javafaker.Faker;
import enums.SocialTitle;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.commons.MenuPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

public class RegistrationTestWithAtAndConsumer extends TestBase {

    @Test
    public void shouldRegisterNewUser() {
        at(MenuPage.class).goToLogin();

        at(LoginPage.class).goToRegistration();

        at(RegistrationPage.class, p -> {
            p.setFirstName("jan");
            p.setLastName("kowalski");
            p.setEmail(new Faker().internet().emailAddress());
            p.setPassword("pass1234");
            p.acceptPolices();
            p.selectSocialTitle(SocialTitle.MR);
            p.submitForm();
        });


        String actualUserName = at(MenuPage.class).getUserName();

        Assertions.assertThat(actualUserName).isEqualTo("jan kowalski");
    }
}

/*
Wejdź na stronę http://146.59.32.4/index.php
- Kliknij przycisk Sign in
- Po przeniesieniu do strony logowanie kliknij przycisk No account? Create one here
*/

