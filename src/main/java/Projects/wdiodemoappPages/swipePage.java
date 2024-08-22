package Projects.wdiodemoappPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.List;

public class swipePage extends PageBase {

    By end = By.xpath("//android.widget.TextView[@text=\"COMPATIBLE\"]");
    String access = "card";
    By string = By.xpath("//android.view.ViewGroup[@content-desc=\"slideTextContainer\"]");

    public swipePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public swipePage swipe() throws InterruptedException {
        bot.swipeLeft(access,end,50);
        return this;
    }

    public swipePage takeFullScreenshot() throws IOException {
        bot.waitFor(end);
        bot.fullScreenShot(end);
        return this;
    }

    public swipePage takeScreenshotOfSpecificElement() throws IOException {
        bot.waitFor(end);
        bot.elementScreenShot(end);
        return this;
    }

    public swipePage getTextList(){
        System.out.println(bot.getTextList(string));
        return this;
    }
}
