package Projects.Google;

import Projects.ActionsBot;
import Projects.PageBase;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class MenuPage extends PageBase {

    By GEO = By.xpath("//*[@text='GEO LOCATION']");

    public MenuPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public GEO ClickOnGEO(){
        wait.until(ExpectedConditions.presenceOfElementLocated(GEO));
        bot.click(GEO);
        return new GEO(driver, bot, wait);
    }


}
