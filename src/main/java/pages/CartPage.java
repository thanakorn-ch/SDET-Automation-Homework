package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By checkoutButton = By.id("checkout");

    public CartPage (WebDriver driver){
        super(driver);
    }

    public boolean validateProductInfo(By locator, String expectedInfo) {
        return validateInfo(locator, expectedInfo);
    }

    public boolean isRemoveButtonVisible(By locator){
        return isElementDisplayed(locator);
    }

    public void clickCheckoutButton(){
        clickButton(checkoutButton);
    }
}
