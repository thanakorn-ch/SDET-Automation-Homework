package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipField = By.id("postal-code");
    private By continueButton = By.id("continue");

    public CheckoutInfoPage(WebDriver driver){
        super(driver);
    }

    public void inputFirstName(String firstName) {
        inputText(firstNameField, firstName);
    }

    public void inputLastName(String lastName) {
        inputText(lastNameField, lastName);
    }

    public void inputZip(String zip) {
        inputText(zipField, zip);
    }

    public void clickContinueButton() {
        clickButton(continueButton);
    }

}
