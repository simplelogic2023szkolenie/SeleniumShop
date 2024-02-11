package pages.cart;

import models.Cart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart-item")
    private List<WebElement> cartLines;

    public CartLineComponent getNthCartLineComponent(int number) {
        return getCartLineComponent().get(number);
    }

    public List<CartLineComponent> getCartLineComponent() {
        return cartLines.stream()
                .map(cartLine -> new CartLineComponent(cartLine, driver))
                .collect(Collectors.toList());
    }

    public Cart toCartModel(){
        Cart cart = new Cart();
        for (CartLineComponent cartLinePage : getCartLineComponent()){
            cart.addProduct(cartLinePage.toProductModel());
        }
        return cart;
    }

}
