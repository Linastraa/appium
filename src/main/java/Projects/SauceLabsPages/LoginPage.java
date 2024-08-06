package Projects.SauceLabsPages;

import Projects.ActionsBot;
import Projects.PageBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;


public class LoginPage extends PageBase {

    AppiumBy userNameField = (AppiumBy) AppiumBy.accessibilityId("test-Username");
    AppiumBy passwordField = (AppiumBy) AppiumBy.accessibilityId("test-Password");
    AppiumBy loginButton = (AppiumBy) AppiumBy.accessibilityId("test-LOGIN");
    By userNameError = By.xpath("//*[@text='Username is required']");
    By passwordError = By.xpath("//*[@text='Password is required']");
    By invalidUsernameOrPasswordMessage = By.xpath("//*[@text='Username and password do not match any user in this service.']");


    public LoginPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }


    @Step("When I login with valid username and password")
    public HomePage loginWithValidUsernameAndPassword(){
        wait.until(ExpectedConditions.presenceOfElementLocated(userNameField));
        bot.type(userNameField,"standard_user");
        bot.type(passwordField,"secret_sauce");
        bot.click(loginButton);
        return new HomePage(driver, bot, wait);
    }

    @Step("When I login with empty username")
    public String loginWithEmptyUsername(){
        wait.until(ExpectedConditions.presenceOfElementLocated(userNameField));
        bot.type(userNameField,"");
        bot.type(passwordField,"secret_sauce");
        bot.click(loginButton);
        return driver.findElement(userNameError).getText();
    }

    @Step("When I login with empty password")
    public String loginWithEmptyPassword(){
        wait.until(ExpectedConditions.presenceOfElementLocated(userNameField));
        bot.type(userNameField,"standard_user");
        bot.type(passwordField,"");
        bot.click(loginButton);
        return driver.findElement(passwordError).getText();
    }

    @Step("When i login with invalid username or password")
    public String loginWithInvalidUsernameOrPassword(){
        wait.until(ExpectedConditions.presenceOfElementLocated(userNameField));
        bot.type(userNameField,"test");
        bot.type(passwordField,"test");
        bot.click(loginButton);
        return driver.findElement(invalidUsernameOrPasswordMessage).getText();
    }

}
