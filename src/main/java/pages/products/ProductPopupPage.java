package pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class ProductPopupPage extends BasePage {
    public ProductPopupPage(WebDriver driver) {
        super(driver);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#blockcart-modal .modal-content")));
    }

    @FindBy(css = "#blockcart-modal .btn-primary")
    private WebElement goToCartBtn;

    public void goToCart() {
        click(goToCartBtn);
    }
}
