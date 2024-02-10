package user;

import base.TestBase;
import enums.SocialTitle;
import org.testng.annotations.Test;
import pages.commons.MenuPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

public class RegistrationTest extends TestBase {

    @Test
    public void shouldRegisterNewUser(){
        //  Kliknij przycisk Sign in -> PO - webelement + metoda + impl w teście
        //  Kliknij przycisk No account? -> PO - webelement + metoda + impl w teście

        new MenuPage(driver).goToLogin();

        new LoginPage(driver).goToRegistration();

        new RegistrationPage(driver).selectSocialTitle(SocialTitle.MR);
    }



}

/*
Wejdź na stronę http://146.59.32.4/index.php
- Kliknij przycisk Sign in
- Po przeniesieniu do strony logowanie kliknij przycisk No account? Create one here
*/

