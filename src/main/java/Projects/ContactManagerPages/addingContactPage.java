package Projects.ContactManagerPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class addingContactPage extends PageBase {

    By targetAccountSpinner = By.xpath("//*[@resource-id='com.example.android.contactmanager:id/accountSpinner']");
    By contactName = By.xpath("//*[@resource-id='com.example.android.contactmanager:id/contactNameEditText']");
    By phoneField = By.xpath("//*[@resource-id='com.example.android.contactmanager:id/contactPhoneEditText']");
    By phoneDropDown = By.xpath("//*[@resource-id='com.example.android.contactmanager:id/contactPhoneTypeSpinner']");
    By mobileOption = By.xpath("//*[@resource-id='android:id/text1' and @text='Mobile']");
    By mailField = By.xpath("//*[@resource-id='com.example.android.contactmanager:id/contactEmailEditText']");
    By mailDropDown = By.xpath("//*[@resource-id='com.example.android.contactmanager:id/contactEmailTypeSpinner']");
    By workOption = By.xpath("//*[@resource-id='android:id/text1' and @text='Work']");
    By saveButton = By.xpath("//*[@content-desc='Save']");

    public addingContactPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public addingContactPage clickOnTargetAccount() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(targetAccountSpinner));
        driver.findElement(targetAccountSpinner).click();
        Thread.sleep(5000);
        driver.navigate().back();
        return this;
    }

    public addingContactPage editingContactName(){
        wait.until(ExpectedConditions.presenceOfElementLocated(contactName));
        driver.findElement(contactName).sendKeys("Sulaiman Ahmed Alzahrani");
        return this;
    }

    public addingContactPage editingPhone(){
        wait.until(ExpectedConditions.presenceOfElementLocated(phoneField));
        driver.findElement(phoneField).sendKeys("+966581638310");
        return this;
    }

    public addingContactPage editingPhoneType(){
        wait.until(ExpectedConditions.presenceOfElementLocated(phoneDropDown));
//        //driver.findElement(phoneDropDown).click();
//        Select dropDown = new Select(driver.findElement(phoneDropDown));
//        dropDown.selectByVisibleText("Mobile");
        driver.findElement(phoneDropDown).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(mobileOption));
        driver.findElement(mobileOption).click();
        return this;
    }

    public addingContactPage editingMail(){
        wait.until(ExpectedConditions.presenceOfElementLocated(mailField));
        driver.findElement(mailField).sendKeys("salzahrani@adree.com");
        return this;
    }

    public addingContactPage editingMailType(){
        wait.until(ExpectedConditions.presenceOfElementLocated(mailDropDown));
//        //driver.findElement(mailDropDown).click();
//        Select dropDown = new Select(driver.findElement(mailDropDown));
//        dropDown.selectByVisibleText("Work");
        driver.findElement(mailDropDown).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(workOption));
        driver.findElement(workOption).click();
        return this;
    }

    public firstPage clickOnSave(){
        wait.until(ExpectedConditions.presenceOfElementLocated(saveButton));
        driver.findElement(saveButton).click();
        return new firstPage(driver,bot,wait);
    }
}
