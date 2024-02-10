package user.extras.pages;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import pages.cart.CartPage;
import pages.commons.HomePage;
import pages.commons.MenuPage;
import pages.products.ProductDetailsPage;
import pages.products.ProductPopupPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

public class Pages extends TestBase {
    // w Pages inicjalizuje wszystki page objektów
    // i teraz wszystki testy dziedziczą po 'Pages'
    // dzięki temu nie trzeba robic w testach new XxxxPage(driver)

    // ale! to tylko dla małych aplikacji około 10-15 page objektów
    MenuPage menuPage;
    HomePage homePage;
    CartPage cartPage;
    ProductDetailsPage productDetailsPage;
    ProductPopupPage productPopupPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void testSetup() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productPopupPage = new ProductPopupPage(driver);
        menuPage = new MenuPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

}
