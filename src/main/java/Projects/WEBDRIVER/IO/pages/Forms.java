package Projects.WEBDRIVER.IO.pages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class Forms extends PageBase {

    By inputField = By.xpath("//*[@content-desc='text-input']");
//    By youHaveTyped =By.xpath("//*[@content-desc='input-text-result']");
    By Switch = By.xpath("//*[@content-desc='switch']");
//    By SwitchText =By.xpath("//*[@content-desc='switch-text']");
    By Dropdown =By.xpath("//*[@resource-id='text_input']");
    By DropdownText=By.xpath("//*[@resource-id='android:id/text1' and @text='Select an item...']");
    By DropdownSecondText =By.xpath("//*[@text='Appium is awesome']");
    By activeButton=By.xpath("//*[@text='Active']");
    By inactiveButton=By.xpath("//*[@content-desc='button-Inactive']");
    By ActiveOk =By.xpath("//*[@resource-id='android:id/button1']");
    public Forms(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public Forms fillTheForm(){
        wait.until(ExpectedConditions.presenceOfElementLocated(inputField));
//        bot.click(inputField);
        bot.type(inputField,"hello");
//        bot.getText(youHaveTyped);
        bot.click(Switch);
//        bot.getText(SwitchText);
        bot.click(Dropdown);
//        bot.type(DropdownText,"hello");
        bot.click(DropdownSecondText);
        bot.click(activeButton);
        bot.click(ActiveOk);
        bot.click(inactiveButton);
        return this;
    }
}
