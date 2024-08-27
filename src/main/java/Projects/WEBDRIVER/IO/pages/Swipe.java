package Projects.WEBDRIVER.IO.pages;

import Projects.ActionsBot;
import Projects.PageBase;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Swipe extends PageBase {

    RemoteWebElement vertical = (RemoteWebElement) wait.until(presenceOfElementLocated(AppiumBy.accessibilityId("Swipe-screen")));
    RemoteWebElement  hor= (RemoteWebElement) wait.until(presenceOfElementLocated(AppiumBy.accessibilityId("Carousel")));

    public Swipe(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public Swipe RightToLeft() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("gesture: swipe", Map.of("elementId", hor.getId(), "percentage", 50, "direction", "left"));
        ((JavascriptExecutor) driver).executeScript("gesture: swipe", Map.of("elementId", hor.getId(), "percentage", -50, "direction", "left"));
//        bot.swipeLeft("Swipe-screen",vertical.getId(),50);
        return this;
    }
    public Swipe LeftToRight() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("gesture: swipe", Map.of("elementId", hor.getId(), "percentage", 50, "direction", "left"));
        ((JavascriptExecutor) driver).executeScript("gesture: swipe", Map.of("elementId", hor.getId(), "percentage", 50, "direction", "right"));
//        bot.SwipeLeftToRight();

        return this;
    }
}
