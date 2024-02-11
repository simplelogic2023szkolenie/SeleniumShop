package cart;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
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
        String productPrice = productDetailsPage.getProductPrice(); // tutaj

        productDetailsPage.setPrice(3)
                .addToCart();

        new ProductPopupPage(driver).goToCart();

        CartPage cartPage = new CartPage(driver);

        Assertions.assertThat(cartPage.getAddedProductName()).isEqualTo(productName);
        Assertions.assertThat(cartPage.getAddedProductPrice()).isEqualTo(productPrice);// tutaj
        Assertions.assertThat(cartPage.getAddedProductQuantity()).isEqualTo(3);// tutaj
    }
}
