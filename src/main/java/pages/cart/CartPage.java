package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-line-info a")
    private WebElement productName;
    @FindBy(css = ".current-price")
    private WebElement productPrice;

    @FindBy(css = ".js-cart-line-product-quantity")
    private WebElement productQuantity;
    public String getAddedProductName(){
        return productName.getText();
    }

    public String getAddedProductQuantity() {
        return productQuantity.getAttribute("value");
    }

    public String getAddedProductPrice() {
        return productPrice.getText();
    }
}
