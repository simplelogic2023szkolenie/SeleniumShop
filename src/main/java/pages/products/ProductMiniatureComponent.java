package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.math.BigDecimal;

public class ProductMiniatureComponent extends BasePage {
    public ProductMiniatureComponent(WebElement parent, WebDriver driver) {
        super(parent, driver);
    }

    @FindBy(css = ".product-title")
    private WebElement name;

    @FindBy(css = ".discount")
    private WebElement discount;

    @FindBy(css = ".price")
    private WebElement price;

    @FindBy(css = ".regular-price")
    private WebElement priceBeforeDiscount;

    public String getName() {
        return name.getText();
    }

    public String getDiscount() {
        return discount.getText();
    }

    public BigDecimal getPrice() {
        return getPrice(price);
    }

    public String getPriceBeforeDiscount() {
        return priceBeforeDiscount.getText();
    }

    public ProductDetailsPage open() {
        click(name);
        return new ProductDetailsPage(driver);
    }
}
