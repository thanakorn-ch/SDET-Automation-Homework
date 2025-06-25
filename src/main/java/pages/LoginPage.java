package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton   = By.id("login-button");

    public LoginPage (WebDriver driver){
        super(driver);
    }

    public void inputUsername(String username) {
        inputText(usernameField, username);
    }

    public void inputPassword(String password) {
        inputText(passwordField, password);
    }

    public void clickLoginButton(){
        clickButton(loginButton);
    }

    public boolean validateLoginErrorMessage(By locator, String expectedInfo){
        return validateInfo(locator, expectedInfo);
    }

}
