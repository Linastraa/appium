package Projects.wdiodemoappPages;

import Projects.ActionsBot;
import Projects.PageBase;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class homePage extends PageBase {

    By webViewOption = By.xpath("//android.widget.TextView[@text=\"Webview\"]");
    By loginButton = By.xpath("//android.widget.TextView[@text=\"Login\"]");
    By swipeButton = By.xpath("//android.widget.TextView[@text=\"Swipe\"]");
    By dragAndDropButton = By.xpath("//android.widget.TextView[@text=\"Drag\"]");

    public homePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public webViewPage clickOnWebViewOption() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(webViewOption));
        driver.findElement(webViewOption).click();
        return new webViewPage(driver,bot,wait);
    }

    public loginAndSignupPage clickOnLoginOption() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return new loginAndSignupPage(driver,bot,wait);
    }

    public swipePage clickOnSwipeButton() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(swipeButton));
        driver.findElement(swipeButton).click();
        Thread.sleep(5000);
        return new swipePage(driver,bot,wait);
    }

    public dragAndDropPage clickOnDragAndDropPage(){
        bot.waitFor(dragAndDropButton);
        driver.findElement(dragAndDropButton).click();
        return new dragAndDropPage(driver,bot,wait);
    }
}
