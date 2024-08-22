package Projects.SauceLabsPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class geoPage extends PageBase {

    By accept = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    public geoPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public geoPage accept() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(accept));
        driver.findElement(accept).click();
        Thread.sleep(5000);
        return this;
    }

    public geoPage accept2(){
        Alert alert = driver.switchTo().alert();
        String alertMessage= alert.getText();
        System.out.println(alertMessage);
        alert.accept();
        return this;
    }
}
