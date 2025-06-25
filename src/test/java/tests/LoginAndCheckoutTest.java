package tests;

import base.BaseTest;
import pages.*;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;

public class LoginAndCheckoutTest extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutInfoPage checkoutInfoPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

    @Test
    public void testLoginAndCheckoutSuccessfully() {
        loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //Validate user login successfully
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");

        productPage = new ProductPage(driver);
        productPage.sortProductPriceHighToLow();
        productPage.addProductToCart(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        productPage.addProductToCart(By.id("add-to-cart-sauce-labs-backpack"));
        productPage.clickCartButton();
        cartPage = new CartPage(driver);
        //Validate product quantity of first product
        Assert.assertTrue(cartPage.validateProductInfo(By.xpath("//div[@data-test = \"cart-list\"]//div[3]//div[@data-test=\"item-quantity\"]"), "1"));
        //Validate product quantity of second product
        Assert.assertTrue(cartPage.validateProductInfo(By.xpath("//div[@data-test = \"cart-list\"]//div[4]//div[@data-test=\"item-quantity\"]"), "1"));

        //Validate product title of first product
        Assert.assertTrue(cartPage.validateProductInfo(By.xpath("//a[@data-test=\"item-5-title-link\"]//div"), "Sauce Labs Fleece Jacket"));
        //Validate product title of second product
        Assert.assertTrue(cartPage.validateProductInfo(By.xpath("//a[@data-test=\"item-4-title-link\"]//div"), "Sauce Labs Backpack"));

        //Validate product price of first product
        Assert.assertTrue(cartPage.validateProductInfo(By.xpath("//div[@data-test = \"cart-list\"]//div[3]//div[2]//div[2]//div"), "$49.99"));
        //Validate product price of second product
        Assert.assertTrue(cartPage.validateProductInfo(By.xpath("//div[@data-test = \"cart-list\"]//div[4]//div[2]//div[2]//div"), "$29.99"));

        //Validate remove button of first product
        Assert.assertTrue(cartPage.isRemoveButtonVisible(By.xpath("//button[@id=\"remove-sauce-labs-fleece-jacket\"]")));
        //Validate remove button of second product
        Assert.assertTrue(cartPage.isRemoveButtonVisible(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")));

        cartPage.clickCheckoutButton();
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.inputFirstName("Test");
        checkoutInfoPage.inputLastName("Test");
        checkoutInfoPage.inputZip("12345");
        checkoutInfoPage.clickContinueButton();
        checkoutOverviewPage = new CheckoutOverviewPage(driver);

        //Validate price total details, then click finish button
        Assert.assertTrue(checkoutOverviewPage.validatePriceTotalDetail(By.xpath("//div[@data-test=\"total-info-label\"]"), "Price Total"));
        Assert.assertTrue(checkoutOverviewPage.validatePriceTotalDetail(By.xpath("//div[@data-test=\"subtotal-label\"]"), "Item total: $79.98"));
        Assert.assertTrue(checkoutOverviewPage.validatePriceTotalDetail(By.xpath("//div[@data-test=\"tax-label\"]"), "Tax: $6.40"));
        Assert.assertTrue(checkoutOverviewPage.validatePriceTotalDetail(By.xpath("//div[@data-test=\"total-label\"]"), "Total: $86.38"));
        checkoutOverviewPage.clickFinishButton();

        checkoutCompletePage = new CheckoutCompletePage(driver);

        //Validate successful order message
        Assert.assertTrue(checkoutCompletePage.validateCheckMarkImageIsVisible());
        Assert.assertTrue(checkoutCompletePage.validateSuccessfulOrderMessage(By.xpath("//h2[@data-test = \"complete-header\"]"), "Thank you for your order!"));
        Assert.assertTrue(checkoutCompletePage.validateSuccessfulOrderMessage(By.xpath("//div[@data-test = \"complete-text\"]"), "Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
    }

    @Test
    public void testLoginFailed() {
        loginPage = new LoginPage(driver);
        loginPage.inputUsername("locked_out_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //Validate user login failed
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.validateLoginErrorMessage(By.xpath("//*[@data-test=\"error\"]"), "Epic sadface: Sorry, this user has been locked out."));
    }
}