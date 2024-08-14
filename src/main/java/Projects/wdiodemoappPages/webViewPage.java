package Projects.wdiodemoappPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class webViewPage extends PageBase {

    String test = "API Reference";
    By picture = By.xpath("//android.view.View[@text='WebdriverIO']");

    public webViewPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public webViewPage scrollDown() throws InterruptedException {
        bot.waitFor(picture);
        bot.scrollDownToElementByText(test);
        Thread.sleep(5000);
        return this;
    }
}
