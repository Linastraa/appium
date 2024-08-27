package Projects.WEBDRIVER.IO.pages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class HomePage extends PageBase {
    By WEBDRIVERTITLE = By.xpath("//*[@text='WEBDRIVER']");

    By webviewNav = By.xpath("//*[@text='Webview']");
    By loginNav = By.xpath("//*[@text='Login']");
    By forms =By.xpath("//*[@text='Forms']");
    By swipe =By.xpath("//*[@text='Swipe']");
    By dragNav =By.xpath("//*[@text='Drag']");

    public HomePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }


    public String proof(){
        wait.until(ExpectedConditions.presenceOfElementLocated(WEBDRIVERTITLE));
        return driver.findElement(WEBDRIVERTITLE).getText();
    }

    public Webview ClickToWebview (){
        wait.until(ExpectedConditions.presenceOfElementLocated(webviewNav));
        bot.doubleTap(webviewNav);

        return new Webview(driver,bot,wait);
    }
    public LoginAndSignUp ClickToLogin(){
        wait.until(ExpectedConditions.presenceOfElementLocated(loginNav));
        bot.click(loginNav);
        return new LoginAndSignUp(driver,bot,wait);
    }
    public Forms ClickToForms(){
        wait.until(ExpectedConditions.presenceOfElementLocated(forms));
        bot.click(forms);
        return new Forms(driver,bot,wait);
    }
    public Swipe ClickToSwipe(){
        wait.until(ExpectedConditions.presenceOfElementLocated(swipe));
        bot.click(swipe);
        return new Swipe(driver,bot,wait);
    }

    public Drag ClickToDrag() {
        bot.click(dragNav);
        return new Drag(driver, bot, wait);
    }

}
