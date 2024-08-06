package Projects.selendroidPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class googlePage extends PageBase {

    By nameField = By.xpath("//*[@resource-id='name_input']");
    By preferredCar = By.xpath("//*[@text='Volvo']");
    By myCar = By.xpath("//*[@resource-id='android:id/text1' and @text='Mercedes']");
    By sendButton = By.xpath("//*[@text='Send me your name!']");

    public googlePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public googlePage editName(){
        wait.until(ExpectedConditions.presenceOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys("Hi, I'm Sulaiman");
        return this;
    }

    public googlePage chooseTheCar(){
        wait.until(ExpectedConditions.presenceOfElementLocated(preferredCar));
        driver.findElement(preferredCar).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(myCar));
        driver.findElement(myCar).click();
        return this;
    }

    public welcomePage clickOnSend(){
        wait.until(ExpectedConditions.presenceOfElementLocated(sendButton));
        driver.findElement(sendButton).click();
        return new welcomePage(driver,bot,wait);
    }
}
