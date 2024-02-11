package pages.products;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ProductsGridPage extends BasePage {
    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }

    // List<WebElement> która zwróci liste miniaturek produków

    // metoda getProductMiniatureComponents() zamieniające
    // List<WebElement>  na List<ProductMiniatureComponent>

    // public void openRandomProduct()
    // losujemy sobie jeden z elementów z   getProductMiniatureComponents()
    // i uruchamiamy na nim metode open() zaimplemenetowaja w  ProductMiniatureComponent
}
