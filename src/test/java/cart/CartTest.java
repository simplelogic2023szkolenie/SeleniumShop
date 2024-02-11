package cart;

import base.TestBase;
import org.testng.annotations.Test;
import pages.products.ProductsGridPage;

public class CartTest extends TestBase {

    @Test
    public void shouldAddProductToCart(){
        new ProductsGridPage(driver).openRandomProduct();
    }
}
