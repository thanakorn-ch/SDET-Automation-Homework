package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By productSortContainer = By.xpath("//select[@data-test= \"product-sort-container\"]");
    private By priceHighToLowOption = By.xpath("//select[@data-test= \"product-sort-container\"]//option[4]");
    private By cartButton = By.xpath("//a[@data-test = \"shopping-cart-link\"]");

    public ProductPage (WebDriver driver){
        super(driver);
    }

    public void sortProductPriceHighToLow() {
        clickButton(productSortContainer);
        clickButton(priceHighToLowOption);
    }

    public void addProductToCart(By locator){
        clickButton(locator);
    }

    public void goToCart(){
        clickButton(cartButton);
    }
}