package Projects.wdiodemoappPages;

import Projects.ActionsBot;
import Projects.PageBase;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class loginAndSignupPage extends PageBase {

    By signUpOption = By.xpath("//android.widget.TextView[@text='Sign up']");
    By emailField = By.xpath("//android.widget.EditText[@content-desc='input-email']");
    By passwordField = By.xpath("//android.widget.EditText[@content-desc='input-password']");
    By confirmPasswordFiled = By.xpath("//android.widget.EditText[@content-desc='input-repeat-password']");
    By signUpButton = By.xpath("//android.widget.TextView[@text='SIGN UP']");
//    AppiumBy signUpButton = (AppiumBy) AppiumBy.accessibilityId("button-SIGN UP");
    By proofOfSignup = By.xpath("//android.widget.TextView[@resource-id='android:id/message']");

    public loginAndSignupPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public loginAndSignupPage clickOnSignupOption(){
        bot.waitFor(signUpOption);
        driver.findElement(signUpOption).click();
        return this;
    }

    public loginAndSignupPage fillSignupInformation(){
        bot.waitFor(emailField);
        driver.findElement(emailField).sendKeys("salzahrai@adree.com");
        driver.findElement(passwordField).sendKeys("Linastra@1420");
        driver.findElement(confirmPasswordFiled).sendKeys("Linastra@1420");
        return this;
    }

    public String signUp() throws InterruptedException {
        //bot.scrollDownToElementByXpath(signUpButton);
        bot.waitFor(signUpButton);
        driver.findElement(signUpButton).click();
        Thread.sleep(5000);
        return driver.findElement(proofOfSignup).getText();
    }
}
