package pages.products;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.math.BigDecimal;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = "h1")
    private WebElement name;
    @FindBy(css = "[itemprop='price']")
    private WebElement price;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;


    public String getName() {
        return name.getText();
    }

    public BigDecimal getProductPrice() {
        return getPrice(price);
    }
    public int getQuantity() {
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }


    public void addToCart() {
        click(addToCartBtn);
    }

    public ProductDetailsPage setQuantity(int quantity) {
        // 5 -> "5"
        sendKeysAndClear(quantityInput, String.valueOf(quantity));
        return this;
    }

    public Product toProductModel() {
        return new Product(getName(), getProductPrice(), getQuantity());
    }


    // 2x webelement i 2x metoda, setQuantity(int quantity), addToCart()
}
