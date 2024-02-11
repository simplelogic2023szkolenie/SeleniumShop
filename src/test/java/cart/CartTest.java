package cart;

import base.TestBase;
import configuration.Config;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.cart.CartPage;
import pages.products.ProductDetailsPage;
import pages.products.ProductPopupPage;
import pages.products.ProductsGridPage;

public class CartTest extends TestBase {
    @Test
    public void shouldAddProductToCart() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        new ProductsGridPage(driver).openRandomProduct();


        String productName = productDetailsPage.getName();
        String productPrice = productDetailsPage.getProductPrice();

        productDetailsPage.setQuantity(3)
                .addToCart();

        new ProductPopupPage(driver).goToCart();

        CartPage cartPage = new CartPage(driver);



        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(cartPage.getAddedProductName()).isEqualTo(productName);
        softAssertions.assertThat(cartPage.getAddedProductPrice()).isEqualTo(productPrice);
        softAssertions.assertThat(cartPage.getAddedProductQuantity()).isEqualTo("3");

        softAssertions.assertAll();
    }
}
