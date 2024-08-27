package Projects.Google;

import Projects.ActionsBot;
import Projects.PageBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import static java.awt.SystemColor.menu;

public class HomePage extends PageBase {
    //By search = By.xpath("//*[@resource-id='gb-main']");
    By item = By.xpath("//*[@content-desc='test-Item']");
    By proof = By.xpath("//*[@text='PRODUCTS']");
    AppiumBy AddToButton = (AppiumBy) AppiumBy.accessibilityId("test-ADD TO CART");
    By cart = By.xpath("//*[@content-desc='test-Cart']");
    By MyCartText = By.xpath("//*[@text=YOUR CART]");
    By checkoutButton = By.xpath("//*[@content-desc='test-CHECKOUT']");
    AppiumBy firstName = (AppiumBy) AppiumBy.accessibilityId("test-First Name");
    AppiumBy lastName = (AppiumBy) AppiumBy.accessibilityId("test-Last Name");
    AppiumBy ZipPostalCode = (AppiumBy) AppiumBy.accessibilityId("test-Zip/Postal Code");
    AppiumBy continueButton = (AppiumBy) AppiumBy.accessibilityId("test-CONTINUE");
    By fNameMessage = By.xpath("//*[@text='First Name is required']");
    By lNameMessage = By.xpath("//*[@text='Last Name is required']");
    By zCodeMessage = By.xpath("//*[@text='Postal Code is required']");
    By text = By.xpath("//*[@text='CHECKOUT: OVERVIEW']");
    By filterButton = By.xpath("//*[@content-desc='test-Modal Selector Button']");
    By highPrice =By.xpath("//*[@text='Price (high to low)']");
    By highestItemPrice = By.xpath("(//*[@content-desc='test-Item'])[1]");
    By price = By.xpath("//*[@content-desc='test-Price']");
    By menu = By.xpath("//*[@content-desc='test-Menu']");

    String addToCart="ADD TO CART";
    public HomePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait){
        super(driver, bot, wait);
    }

    @Step("When I click the login button.")
    public String prove() {
        wait.until(ExpectedConditions.presenceOfElementLocated(proof));
        return driver.findElement(proof).getText();
    }

    public HomePage SelectTheItem() {
        wait.until(ExpectedConditions.presenceOfElementLocated(item));
        driver.findElement(item).click();
        return this;
    }

    public HomePage ScrollDown() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(AddToButton));
        bot.scrollDownToElementByText(addToCart);
        bot.click(AddToButton);
        return this;
    }

    public HomePage Cart() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(cart));
        driver.findElement(cart).click();
        return this;
    }

    public String GetItem() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MyCartText));
        return driver.findElement(MyCartText).getText();
    }

    public HomePage clickOnCheckout() {
        wait.until(ExpectedConditions.presenceOfElementLocated(checkoutButton));
        driver.findElement(checkoutButton).click();
        return this;
    }

    public HomePage fillInformation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        bot.type(firstName, "hamza");
        bot.type(lastName, "osailan");
        bot.type(ZipPostalCode, "Medina");
        bot.click(continueButton);
        return this;
    }

    public String fillInformationWithOutFirstName() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        bot.type(lastName, "osailan");
        bot.type(ZipPostalCode, "Medina");
        bot.click(continueButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(fNameMessage));
        return driver.findElement(fNameMessage).getText();
    }

    public String fillInformationWithOutLastName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        bot.type(firstName, "hamza");
        bot.type(ZipPostalCode, "Medina");
        bot.click(continueButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(lNameMessage));

        return driver.findElement(lNameMessage).getText();
    }

    public String fillInformationWithOutZipCode() {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        bot.type(firstName, "hamza");
        bot.type(lastName, "osailan");
        bot.click(continueButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(zCodeMessage));

        return driver.findElement(zCodeMessage).getText();
    }

    public String getTheTextAfterInformation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(text));
        return driver.findElement(text).getText();
    }

    public HomePage clickOnFilterButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(filterButton));
        driver.findElement(filterButton).click();
        return this;
    }
    public String filterByHighPriceAndGetTheText() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(highPrice));
        driver.findElement(highPrice).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(highestItemPrice));
        driver.findElement(highestItemPrice).click();
        bot.scrollDownToElementByXpath(price);
        wait.until(ExpectedConditions.presenceOfElementLocated(price));
        return driver.findElement(price).getText();

    }

    public MenuPage clickOnMenu(){
        wait.until(ExpectedConditions.presenceOfElementLocated(menu));
        driver.findElement(menu).click();
        return new MenuPage(driver,bot,wait);
    }


}