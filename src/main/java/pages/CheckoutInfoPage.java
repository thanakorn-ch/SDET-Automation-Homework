package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {
    private WebDriver driver;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipField = By.id("postal-code");
    private By continueButton = By.id("continue");

    public CheckoutInfoPage(WebDriver driver){
        this.driver= driver;
    }

    public void completeCheckoutInfoAndContinue(String firstName, String lastName, String zip){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(continueButton).click();
    }
}
