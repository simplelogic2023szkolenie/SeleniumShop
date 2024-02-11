package compare_objects;

import enums.SocialTitle;
import models.User;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssertJDemo {
    User user1;
    User user2;
    @BeforeMethod
    public void testSetup(){
        user1 = new User.UserBuilder().firstName("jan")
                .lastName("kowalski")
                .email("j.k@wp.pl")
                .password("password123")
                .socialTitle(SocialTitle.MR)
                .build();

        user2 = new User.UserBuilder().firstName("jan")
                .lastName("kowalski")
                .email("j.k@wp.pl")
                .password("password123")
                .socialTitle(SocialTitle.MR)
                .build();
    }

    @Test
    public void shouldCompareTwoUsers(){
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(user1.getFirstName()).isEqualTo(user2.getFirstName());
        softAssertions.assertThat(user1.getLastName()).isEqualTo(user2.getLastName());
        softAssertions.assertThat(user1.getPassword()).isEqualTo(user2.getPassword());
        softAssertions.assertThat(user1.getEmail()).isEqualTo(user2.getEmail());

        softAssertions.assertAll();
    }

    @Test
    public void shouldCompareTwoUsersV2(){
        // tutaj porównujemy obiekty dostajemy false, bo są 2 różne obiety zapisnane w 2 różnych miejscach w pamięci
        Assertions.assertThat(user1).isEqualTo(user2);
    }

    @Test
    public void shouldCompareTwoUsersV3(){
        // opcja usingRecursiveComparison() powoduje, że obiekty są porówane pole po polu, a nie gdzie są w pamięci
        Assertions.assertThat(user1).usingRecursiveComparison().isEqualTo(user2);
    }
}
