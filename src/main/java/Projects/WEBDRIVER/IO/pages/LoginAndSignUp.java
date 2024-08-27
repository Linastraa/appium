package Projects.WEBDRIVER.IO.pages;

import Projects.ActionsBot;
import Projects.PageBase;
//import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class LoginAndSignUp  extends PageBase{

    By Email =By.xpath("//*[@content-desc='input-email']");
    By password =By.xpath("//*[@content-desc='input-password']");
    By confirmPassword =By.xpath("//*[@content-desc='input-repeat-password']");

    By loginButton =By.xpath("//*[@text='LOGIN']");
    By signUpButton =By.xpath("//*[@content-desc='button-SIGN UP']");

    By LoginSuccessfullyTest =By.xpath("//*[@resource-id='android:id/message']");
    By SignUpSuccessfullyTest= By.xpath("//*[@resource-id='android:id/message']");

    By SignUpPageButton =By.xpath("//*[@text='Sign up']");
    public LoginAndSignUp(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

//    @Given("successful login")
    public String SignUp(){
        bot.click(SignUpPageButton);
//        wait.until(ExpectedConditions.presenceOfElementLocated(SignUpPageButton));
        bot.type(Email,"hamzaosailan@hotmail.com");
        bot.type(password,"Xoxo5566xu1z");
        bot.type(confirmPassword,"Xoxo5566xu1z");
        bot.click(signUpButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(SignUpSuccessfullyTest));
        return driver.findElement(SignUpSuccessfullyTest).getText();
    }
//    @When("successful SignUp")
    public String Login(){
        wait.until(ExpectedConditions.presenceOfElementLocated(Email));
        bot.type(Email,"hamzaosailan@hotmail.com");
        bot.type(password,"Xoxo5566xu1z");
        bot.LongPress(loginButton);

        wait.until(ExpectedConditions.presenceOfElementLocated(LoginSuccessfullyTest));
        return driver.findElement(LoginSuccessfullyTest).getText();
    }
}
