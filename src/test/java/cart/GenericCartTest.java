package cart;

import base.TestBase;
import models.Cart;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.cart.CartPage;
import pages.products.ProductDetailsPage;
import pages.products.ProductPopupPage;
import pages.products.ProductsGridPage;
import providers.UrlProvider;

import java.util.Random;

public class GenericCartTest extends TestBase {
    private final static int PRODUCTS_TO_ADD = 10;

    @Test
    public void shouldAddProductsToBasketAndCheckCalculations()  {
        Cart expectectedCart = new Cart();

        for (int i = 0; i < PRODUCTS_TO_ADD; i++) {
            driver.get(UrlProvider.homePage);

            at(ProductsGridPage.class).openRandomProduct();

            at(ProductDetailsPage.class, p -> {
                p.setQuantity(getRandomQuantity());

                expectectedCart.addProduct(p.toProductModel());
                p.addToCart();
            });
            // nie musimy nic uruchamiać bo konstruktor ProductPopupPage ma wbudowany wait czekający na popup
            // a musimy na niego poczekać, żeby mieć pewność, że product został dodany do koszyka
            at(ProductPopupPage.class);
        }

        driver.get(UrlProvider.cart);

        Cart actualCart = at(CartPage.class).toCartModel();

        Assertions.assertThat(actualCart).usingRecursiveComparison().isEqualTo(expectectedCart);

    }


    private int getRandomQuantity() {
        return new Random().nextInt(5) + 1;
    }
}
