package models;

import enums.SocialTitle;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private SocialTitle socialTitle;

    public User(String firstName, String lastName, String email, String password, SocialTitle socialTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.socialTitle = socialTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public SocialTitle getSocialTitle() {
        return socialTitle;
    }

    public String getDisplayedUserName() {
        return getFirstName() + " " + getLastName();
    }

    // https://devcave.pl/effective-java/wzorzec-projektowy-builder
    // https://www.baeldung.com/java-faker
    public static final class UserBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private SocialTitle socialTitle;

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder socialTitle(SocialTitle socialTitle) {
            this.socialTitle = socialTitle;
            return this;
        }

        public User build() {
            // tutaj mogą być sprawdzenia czy jakieś pola wymagane przypadkiem nie zostały puste
            return new User(firstName, lastName, email, password, socialTitle);
        }
    }
}
