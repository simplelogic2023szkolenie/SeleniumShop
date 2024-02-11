package pages.cart;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.math.BigDecimal;

public class CartLineComponent extends BasePage {
    public CartLineComponent(WebElement parent, WebDriver driver) {
        super(parent, driver);
    }

    @FindBy(css = ".product-line-info a")
    private WebElement productName;
    @FindBy(css = ".current-price")
    private WebElement productPrice;
    @FindBy(css = ".product-line-actions strong")
    private WebElement productTotalPrice;

    @FindBy(css = ".js-cart-line-product-quantity")
    private WebElement productQuantity;

    public String getProductName() {
        return productName.getText();
    }

    public int getProductQuantity() {
        return Integer.parseInt(productQuantity.getAttribute("value"));
    }

    public BigDecimal getProductPrice() {
        return getPrice(productPrice);
    }

    public BigDecimal getProductTotalPrice() {
        return getPrice(productTotalPrice);
    }

    public Product toProductModel() {
        return new Product(getProductName(), getProductPrice(), getProductTotalPrice()
                , getProductQuantity());
    }

}
