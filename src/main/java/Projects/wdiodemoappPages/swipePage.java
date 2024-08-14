package Projects.wdiodemoappPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class swipePage extends PageBase {

    //String card = "__CAROUSEL_ITEM_0_READY__";
    //String card = "card";
    By end = By.xpath("//android.widget.TextView[@text=\"COMPATIBLE\"]");
    String access = "card";

    //By end = By.xpath("//android.view.ViewGroup[@resource-id=\"__CAROUSEL_ITEM_5_READY__\"]");

    public swipePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public swipePage swipe() throws InterruptedException {
        //bot.swipeRight(card,-150);
        bot.swipeLeft(access,end,50);
        return this;
    }

    public swipePage takeFullScreenshot() throws IOException {
        bot.waitFor(end);
        //Date date = new Date();
        bot.fullScreenShot(end);
        return this;
    }

    public swipePage takeScreenshotOfSpecificElement() throws IOException {
        bot.waitFor(end);
        bot.elementScreenShot(end);
        return this;
    }
}
