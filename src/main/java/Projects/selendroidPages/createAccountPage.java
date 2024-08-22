package Projects.selendroidPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class createAccountPage extends PageBase {

    By usernameField = By.xpath("//*[@resource-id='io.selendroid.testapp:id/inputUsername']");
    By emailField = By.xpath("//*[@content-desc='email of the customer']");
    By passField = By.xpath("//*[@resource-id='io.selendroid.testapp:id/inputPassword']");
    By nameField = By.xpath("//*[@resource-id='io.selendroid.testapp:id/inputName']");
    By javaLanguage = By.xpath("//*[@resource-id='android:id/text1' and @text='Java']");
    By adCheckbox = By.xpath("//*[@resource-id='io.selendroid.testapp:id/input_adds']");
    By registerButton = By.xpath("//*[@resource-id='io.selendroid.testapp:id/btnRegisterUser']");

    public createAccountPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public createAccountPage editUserName() throws InterruptedException {
        Thread.sleep(10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys("Linastra");
        return this;
    }

    public createAccountPage editEmail(){
        wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys("salzahrani@adree.com");
        return this;
    }

    public createAccountPage editPassword() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(passField));
        bot.scrollDownToElementByXpath(passField);
        driver.findElement(passField).sendKeys("Linastra@1420");
        return this;
    }

    public createAccountPage editName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys("Sulaiman");
        return this;
    }

    public createAccountPage selectLanguage() {
        driver.findElement(By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(javaLanguage));
        driver.findElement(javaLanguage).click();
        return this;
    }

    public createAccountPage agreeOnAd() {
        wait.until(ExpectedConditions.presenceOfElementLocated(adCheckbox));
        driver.findElement(adCheckbox).click();
        return this;
    }

    public userPage registerAUser() {
        wait.until(ExpectedConditions.presenceOfElementLocated(registerButton));
        driver.findElement(registerButton).click();
        return new userPage(driver,bot,wait);
    }
}
