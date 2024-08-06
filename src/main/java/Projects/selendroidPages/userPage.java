package Projects.selendroidPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class userPage extends PageBase {

    By verify = By.xpath("//*[@text='Verify user']");

    public userPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public String verify(){
        wait.until(ExpectedConditions.presenceOfElementLocated(verify));
        return driver.findElement(verify).getText();
    }
}
