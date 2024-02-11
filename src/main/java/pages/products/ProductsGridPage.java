package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsGridPage extends BasePage {
    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".product-miniature")
    private List<WebElement> productMiniatures;

    public List<ProductMiniatureComponent> getProductMiniatureComponents(){
        // całość można zapisać w 1 linijce użwają stream() collect
        List<ProductMiniatureComponent> miniatureComponents = new ArrayList<>();
        for (WebElement productMiniature : productMiniatures){
            miniatureComponents.add(new ProductMiniatureComponent(productMiniature, driver));
        }
        return miniatureComponents;
    }

    public ProductDetailsPage openRandomProduct(){
        List<ProductMiniatureComponent> products = getProductMiniatureComponents();

        ProductMiniatureComponent product = products.get(new Random().nextInt(products.size()));
        product.open();
        return new ProductDetailsPage(driver);
    }
}
