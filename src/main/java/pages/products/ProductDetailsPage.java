package pages.products;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css="h1")
    private WebElement name;

    @FindBy(css=".add-to-cart")
    private WebElement addToCartBtn;


    public String getName(){
        return name.getText();
    }
    public void addToCart() {
        click(addToCartBtn);
    }
    public ProductDetailsPage setPrice(int quantity) {
        // 5 -> "5"
        sendKeysAndClear(quantityInput, String.valueOf(quantity));
        return this;
    }




    // 2x webelement i 2x metoda, setQuantity(int quantity), addToCart()
}
