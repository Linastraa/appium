package Projects.WEBDRIVER.IO.pages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class Webview extends PageBase {

    By WatchYouTube = By.xpath("//*[@text='Watch on YouTube']");
    By Title = By.xpath("//*[@text='Next-gen browser and mobile automation test framework for Node.js']");
    By TestInRealEnv = By.xpath("//*[@text='Committed Community']");

    public Webview(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }
    public Webview ScrollDown() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(WatchYouTube));
//        bot.scrollDownToElementByXpath(WatchYouTube);
        bot.scrollDownToElementByXpath(WatchYouTube);
        return this;
    }

    //problem in the app
    public Webview scrollIntoView() throws InterruptedException {
//    wait.until(ExpectedConditions.presenceOfElementLocated(WatchYouTube));
    bot.scrollDownToElementByXpath(TestInRealEnv);
    return this;
    }

    public void ClickToYouTubeButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(WatchYouTube));
        bot.click(WatchYouTube);
    }


}
