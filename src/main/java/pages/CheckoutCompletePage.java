package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private By checkMarkImage = By.xpath("//img[@data-test = \"pony-express\"]");

    public CheckoutCompletePage(WebDriver driver){
        super(driver);
    }

    public boolean validateSuccessfulOrderMessage(By locator, String expectedInfo){
        return validateInfo(locator, expectedInfo);
    }

    public boolean validateCheckMarkImageIsVisible(){
        return isElementDisplayed(checkMarkImage);
    }
}
