package user.extras.user_object;

import base.TestBase;
import com.github.javafaker.Faker;
import enums.SocialTitle;
import models.User;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.commons.MenuPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;
import providers.UserProvider;

public class RegistrationTestWithAt extends TestBase {

    @Test
    public void shouldRegisterNewUser() {
        User user = UserProvider.getRandomUser();

        at(MenuPage.class).goToLogin();

        at(LoginPage.class).goToRegistration();

        at(RegistrationPage.class).fillForm(user);

        String actualUserName = at(MenuPage.class).getUserName();

        Assertions.assertThat(actualUserName).isEqualTo(user.getDisplayedUserName());
    }


}

/*
Wejdź na stronę http://146.59.32.4/index.php
- Kliknij przycisk Sign in
- Po przeniesieniu do strony logowanie kliknij przycisk No account? Create one here
*/

