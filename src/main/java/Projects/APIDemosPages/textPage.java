package Projects.APIDemosPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class textPage extends PageBase {

    By keyEventText = By.xpath("//*[@content-desc='KeyEventText']");

    public textPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public textPage clickOnKeyEventText() throws InterruptedException {
        driver.findElement(keyEventText).click();
        Thread.sleep(5000);
        return this;
    }
}
