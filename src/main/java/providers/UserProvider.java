package providers;

import com.github.javafaker.Faker;
import enums.SocialTitle;
import models.User;

public class UserProvider {
    public static User getRandomUser() {
        Faker faker = new Faker();
        return new User.UserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .socialTitle(SocialTitle.MR)
                .build();
    }

    public static User getAlreadyRegieredUser() {
        // ewentualnie te dane moge nie byc zahardcodowane ale brane np z bazy danych
        return new User.UserBuilder().firstName("jan")
                .lastName("kowalski")
                .email("j.k@wp.pl")
                .password("password123")
                .socialTitle(SocialTitle.MR)
                .build();
    }
}
