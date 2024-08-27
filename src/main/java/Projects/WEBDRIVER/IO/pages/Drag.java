package Projects.WEBDRIVER.IO.pages;

import Projects.ActionsBot;
import Projects.PageBase;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.Map;


public class Drag extends PageBase {
//    AppiumBy firstDrag = (AppiumBy) AppiumBy.accessibilityId("drag-l1");
//    AppiumBy firstDrop = (AppiumBy) AppiumBy.accessibilityId("drop-l1");
By proofOfPage = By.xpath("//android.widget.TextView[@text=\"Drag and Drop\"]");

    String firstDrag = "drag-l1";
    String firstDrop = "drop-l1";
    String secondDrag = "drag-c1";
    String secondDrop = "drop-c1";
    String thirdDrag = "drag-r1";
    String thirdDrop = "drop-r1";
    String fourthDrag = "drag-l2";
    String fourthDrop = "drop-l2";
    String fifthDrag = "drag-c2";
    String fifthDrop = "drop-c2";
    String sixthDrag = "drag-r2";
    String sixthDrop = "drop-r2";
    String seventhDrag = "drag-l3";
    String seventhDrop = "drop-l3";
    String eighthDrag = "drag-c3";
    String eighthDrop = "drop-c3";
    String ninthDrag = "drag-r3";
    String ninthDrop = "drop-r3";

    public Drag(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public Drag drag() throws InterruptedException, IOException {
        wait.until(ExpectedConditions.presenceOfElementLocated(proofOfPage));
        DragAndDrop(firstDrag,firstDrop);
        return this;
    }

    private void DragAndDrop(String source , String destination) throws InterruptedException, IOException {
        RemoteWebElement source1 = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId(source));
        RemoteWebElement destination1 = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId(destination));
//        Thread.sleep(30);

        ((JavascriptExecutor) driver).executeScript("gesture: dragAndDrop", Map.of("sourceId", source1.getId(), "destinationId", destination1.getId()));
        bot.fullScreenShot(proofOfPage);
        bot.elementScreenShot(proofOfPage);
    }



}
