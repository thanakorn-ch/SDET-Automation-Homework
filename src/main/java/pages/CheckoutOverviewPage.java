package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    private By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
    }

    public boolean validatePriceTotalDetail(By locator, String expectedInfo){
        return validateInfo(locator, expectedInfo);
    }

    public void clickFinishButton(){
        clickButton(finishButton);
    }
}
