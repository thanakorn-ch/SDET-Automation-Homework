package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    public void clickButton(By locator){
        driver.findElement(locator).click();
    }

    public boolean validateInfo(By locator, String expectedInfo){
        String actualInfo = driver.findElement(locator).getText();
        return actualInfo.equals(expectedInfo);
    }

    public void inputText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

}
