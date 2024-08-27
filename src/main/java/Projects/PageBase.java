package Projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class PageBase {
    protected  WebDriver driver;
    protected ActionsBot bot;
    protected  Wait<WebDriver> wait;

    public PageBase(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        this.driver = driver;
        this.bot = bot;
        this.wait = wait; // Ensure this is being set
    }
}

