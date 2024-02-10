package user.extras;

import base.TestBase;
import com.github.javafaker.Faker;
import enums.SocialTitle;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.commons.MenuPage;

public class RegistrationTestV2FullFluent extends TestBase {

    @Test
    public void shouldRegisterNewUser() {
        new MenuPage(driver)
                .goToLogin()
                .goToRegistration()
                .setFirstName("jan")
                .setLastName("kowalski")
                .setEmail(new Faker().internet().emailAddress())
                .setPassword("pass1234")
                .acceptPolices()
                .selectSocialTitle(SocialTitle.MR)
                .submitForm();

        String actualUserName = new MenuPage(driver).getUserName();

        Assertions.assertThat(actualUserName).isEqualTo("jan kowalski");
    }

    @Test
    public void shouldRegisterNewUserV2() {
        String actualUserName = new MenuPage(driver)
                .goToLogin()
                .goToRegistration()
                .setFirstName("jan")
                .setLastName("kowalski")
                .setEmail(new Faker().internet().emailAddress())
                .setPassword("pass1234")
                .acceptPolices()
                .selectSocialTitle(SocialTitle.MR)
                .submitForm()
                .getUserName();

        Assertions.assertThat(actualUserName).isEqualTo("jan kowalski");
    }

    @Test
    public void shouldRegisterNewUserV3() {
        Assertions.assertThat(
                new MenuPage(driver)
                        .goToLogin()
                        .goToRegistration()
                        .setFirstName("jan")
                        .setLastName("kowalski")
                        .setEmail(new Faker().internet().emailAddress())
                        .setPassword("pass1234")
                        .acceptPolices()
                        .selectSocialTitle(SocialTitle.MR)
                        .submitForm()
                        .getUserName()).isEqualTo("jan kowalski");
    }


}
