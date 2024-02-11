package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductMiniatureComponent extends BasePage {
    public ProductMiniatureComponent(WebElement parent, WebDriver driver) {
        super(parent, driver);
    }
    @FindBy(css = ".product-title")
    private WebElement name;
    public String getName(){
        return name.getText();
    }
    // konstruktor z BP uzuwający parent oraz driver

    // webelement + metody zwaracjące: discount, price, priceBeforeDiscount, name

    // do tego też metoda open() która otwera dany produt

    public ProductDetailsPage open(){
        click(name);
        return new ProductDetailsPage(driver);
    }
}
