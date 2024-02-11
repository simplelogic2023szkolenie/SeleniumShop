package pages.products;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    // 2x webelement i 2x metoda, setQuantity(int quantity), addToCart()
}
