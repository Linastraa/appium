package Projects.SauceLabsPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class menuPage extends PageBase {

    By GEO = By.xpath("//*[@text='GEO LOCATION']");

    public menuPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public geoPage clickOnGEO(){
        wait.until(ExpectedConditions.presenceOfElementLocated(GEO));
        driver.findElement(GEO).click();
        return new geoPage(driver,bot,wait);
    }
}
