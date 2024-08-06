package Projects.ContactManagerPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class firstPage extends PageBase {

    By continueButton = By.xpath("//*[@resource-id='com.android.permissioncontroller:id/continue_button']");
    By okButton = By.xpath("//*[@resource-id='android:id/button1']");
    By addContact = By.xpath("//*[@content-desc='Add Contact']");
    By title = By.xpath("//*[@resource-id='android:id/title']");

    public firstPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public firstPage clickOnContinue() {
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
        return this;
    }

    public firstPage clickOnOk(){
        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        driver.findElement(okButton).click();
        return this;
    }

    public addingContactPage clickOnAddContact(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addContact));
        driver.findElement(addContact).click();
        return new addingContactPage(driver,bot,wait);
    }

    public String veryify(){
        wait.until(ExpectedConditions.presenceOfElementLocated(title));
        return driver.findElement(title).getText();
        //driver.getTitle();
    }
}
