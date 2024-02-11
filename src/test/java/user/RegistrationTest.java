package user;

import base.TestBase;
import com.github.javafaker.Faker;
import enums.SocialTitle;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.commons.MenuPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

public class RegistrationTest extends TestBase {

    @Test
    public void shouldRegisterNewUser() {
        new MenuPage(driver).goToLogin();


        driver.findElement(By.cssSelector("#login-form [name='email']")).sendKeys("asd");
        driver.findElement(By.cssSelector("#submit-login")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       String asd =  driver.findElement(By.cssSelector("#login-form [name='email']")).getAttribute("title");

        System.out.println(asd);

//        new LoginPage(driver).goToRegistration();
//
//        new RegistrationPage(driver).setFirstName("jan")
//                .setLastName("kowalski")
//                .setEmail(new Faker().internet().emailAddress())
//                .setPassword("pass1234")
//                .acceptPolices()
//                .selectSocialTitle(SocialTitle.MR)
//                .submitForm();
//
//        String actualUserName = new MenuPage(driver).getUserName();
//
//        Assertions.assertThat(actualUserName).isEqualTo("jan kowalski");
    }


}

/*
Wejdź na stronę http://146.59.32.4/index.php
- Kliknij przycisk Sign in
- Po przeniesieniu do strony logowanie kliknij przycisk No account? Create one here
*/

