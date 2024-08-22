package Projects.SauceLabsPages;

import Projects.ActionsBot;
import Projects.PageBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;

public class HomePage extends PageBase {

    By proof = By.xpath("//*[@text='PRODUCTS']");
    By item = By.xpath("//*[@content-desc='test-Item']");
    AppiumBy addButton = (AppiumBy) AppiumBy.accessibilityId("test-ADD TO CART");
    By button = By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]");
    By cart = By.xpath("//*[@content-desc='test-Cart']");
    By myCartText = By.xpath("//*[@text='YOUR CART']");
    By checkoutButton = By.xpath("//*[@content-desc='test-CHECKOUT']");
    By firstName = By.xpath("//*[@content-desc='test-First Name']");
    By lastName = By.xpath("//*[@content-desc='test-Last Name']");
    By zipCode = By.xpath("//*[@content-desc='test-Zip/Postal Code']");
    By continueButton = By.xpath("//*[@content-desc='test-CONTINUE']");
    By text = By.xpath("//*[@text='CHECKOUT: OVERVIEW']");
    By fNameMessage = By.xpath("//*[@text='First Name is required']");
    By lNameMessage = By.xpath("//*[@text='Last Name is required']");
    By zCodeMessage = By.xpath("//*[@text='Postal Code is required']");
    By filterButton = By.xpath("//*[@content-desc='test-Modal Selector Button']");
    By filterByHighPrice = By.xpath("//*[@text='Price (high to low)']");
    By highestItemPrice = By.xpath("(//*[@content-desc='test-Item'])[1]");
    By price = By.xpath("//*[@content-desc='test-Price']");
    By menu = By.xpath("//*[@content-desc='test-Menu']");


    public HomePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    @Step("When I click the login button")
    public String prove(){
        wait.until(ExpectedConditions.presenceOfElementLocated(proof));
        return driver.findElement(proof).getText();
    }

    @Step("When i click on an item")
    public HomePage clickOnAnItem(){
        wait.until(ExpectedConditions.presenceOfElementLocated(item));
        driver.findElement(item).click();
        return this;
    }

    @Step("When i click on an item")
    public HomePage scrollDown() throws InterruptedException {
//        bot.scrollDownToElementByXpath(button);
        bot.scrollDownToElementByText("© 2024 Sauce Labs. All Rights Reserved.");
        return this;
    }

    @Step("When i click on an item")
    public HomePage scrollDownSelenium() throws InterruptedException {
        bot.scrollDownToElementByXpath(button);
        return this;
    }

    @Step("And i add the item to cart")
    public HomePage clickOnButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addButton));
        bot.click(addButton);
        return this;
    }

    @Step("And i add the item to cart")
    public HomePage clickOnCart(){
        wait.until(ExpectedConditions.presenceOfElementLocated(cart));
        driver.findElement(cart).click();
        return this;
    }

    @Step("And i add the item to cart")
    public String getTheText(){
        wait.until(ExpectedConditions.presenceOfElementLocated(myCartText));
        return driver.findElement(myCartText).getText();
    }

    @Step("And i add the item to cart")
    public HomePage clickOnCheckout(){
        wait.until(ExpectedConditions.presenceOfElementLocated(checkoutButton));
        driver.findElement(checkoutButton).click();
        return this;
    }

    @Step("And i add the item to cart")
    public HomePage fillOutInformation(){
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys("test");
        driver.findElement(lastName).sendKeys("anotherTest");
        driver.findElement(zipCode).sendKeys("lastTest");
        driver.findElement(continueButton).click();
        return this;
    }

    public String leaveFirstNameEmpty(){
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        driver.findElement(lastName).sendKeys("anotherTest");
        driver.findElement(zipCode).sendKeys("lastTest");
        driver.findElement(continueButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(fNameMessage));
        return driver.findElement(fNameMessage).getText();
    }

    public String leaveLastNameEmpty(){
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys("anotherTest");
        driver.findElement(zipCode).sendKeys("lastTest");
        driver.findElement(continueButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(lNameMessage));
        return driver.findElement(lNameMessage).getText();
    }

    public String leaveZipCodeEmpty(){
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys("anotherTest");
        driver.findElement(lastName).sendKeys("lastTest");
        driver.findElement(continueButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(zCodeMessage));
        return driver.findElement(zCodeMessage).getText();
    }

    public String getTheTextAfterInformation(){
        wait.until(ExpectedConditions.presenceOfElementLocated(text));
        return driver.findElement(text).getText();
    }

    public HomePage clickOnFilterButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(filterButton));
        driver.findElement(filterButton).click();
        return this;
    }

    public String filterByHighPriceAndGetTheText() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(filterByHighPrice));
        driver.findElement(filterByHighPrice).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(highestItemPrice));
        driver.findElement(highestItemPrice).click();
        bot.scrollDownToElementByXpath(price);
        wait.until(ExpectedConditions.presenceOfElementLocated(price));
        return driver.findElement(price).getText();
    }

    public menuPage clickOnMenu(){
        wait.until(ExpectedConditions.presenceOfElementLocated(menu));
        driver.findElement(menu).click();
        return new menuPage(driver,bot,wait);
    }

    public HomePage screenShotIt() throws IOException {
        bot.fullScreenShot(menu);
        return this;
    }
}
