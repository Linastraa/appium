package Projects.selendroidPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class welcomePage extends PageBase {

    By welcoming = By.xpath("//*[@text='This is my way of saying hello']");

    public welcomePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public String getTheWelcome(){
        wait.until(ExpectedConditions.presenceOfElementLocated(welcoming));
        return driver.findElement(welcoming).getText();
    }
}
