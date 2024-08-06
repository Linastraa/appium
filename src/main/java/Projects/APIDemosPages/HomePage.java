package Projects.APIDemosPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class HomePage extends PageBase {

    By text = By.xpath("//*[@content-desc='Text']");

    public HomePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public textPage clickOnText(){
        driver.findElement(text).click();
        return new textPage(driver,bot,wait);
    }

}
