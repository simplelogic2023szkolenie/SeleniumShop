package cart;

import base.TestBase;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.cart.CartPage;
import pages.products.ProductDetailsPage;
import pages.products.ProductPopupPage;
import pages.products.ProductsGridPage;

import java.math.BigDecimal;

public class CartTest extends TestBase {
    @Test
    public void shouldAddProductToCart() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        new ProductsGridPage(driver).openRandomProduct();


        String productName = productDetailsPage.getName();
        BigDecimal productPrice = productDetailsPage.getProductPrice();

        productDetailsPage.setQuantity(3)
                .addToCart();

        new ProductPopupPage(driver).goToCart();

        CartPage cartPage = new CartPage(driver);



        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(cartPage.getNthCartLineComponent(0).getProductName()).isEqualTo(productName);
        softAssertions.assertThat(cartPage.getNthCartLineComponent(0).getProductPrice()).isEqualTo(productPrice);
        softAssertions.assertThat(cartPage.getNthCartLineComponent(0).getProductQuantity()).isEqualTo("3");

        softAssertions.assertAll();
    }
}
