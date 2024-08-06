package Projects.selendroidPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class firstPage extends PageBase {

    By continueButton = By.xpath("//*[@resource-id='com.android.permissioncontroller:id/continue_button']");
    By okButton = By.xpath("//*[@resource-id='android:id/button1']");
    By googleSymbol = By.xpath("//*[@content-desc='buttonStartWebviewCD']");
    By progressBar = By.xpath("//*[@content-desc='waitingButtonTestCD']");

    public firstPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public firstPage clickOnContinue(){
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
        return this;
    }

    public firstPage clickOnOk(){
        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        driver.findElement(okButton).click();
        return this;
    }

    public googlePage clickOnGoogle(){
        wait.until(ExpectedConditions.presenceOfElementLocated(googleSymbol));
        driver.findElement(googleSymbol).click();
        return new googlePage(driver,bot,wait);
    }

    public createAccountPage clickOnProgressBar(){
        wait.until(ExpectedConditions.presenceOfElementLocated(progressBar));
        driver.findElement(progressBar).click();
        return new createAccountPage(driver,bot,wait);
    }
}
