package Projects.wdiodemoappPages;

import Projects.ActionsBot;
import Projects.PageBase;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class dragAndDropPage extends PageBase {

    AppiumBy firstDrag = (AppiumBy) AppiumBy.accessibilityId("drag-l1");
    AppiumBy firstDrop = (AppiumBy) AppiumBy.accessibilityId("drop-l1");
    AppiumBy secondDrag = (AppiumBy) AppiumBy.accessibilityId("drag-c1");
    AppiumBy secondDrop = (AppiumBy) AppiumBy.accessibilityId("drop-c1");
    AppiumBy thirdDrag = (AppiumBy) AppiumBy.accessibilityId("drag-r1");
    AppiumBy thirdDrop = (AppiumBy) AppiumBy.accessibilityId("drop-r1");
    AppiumBy fourthDrag = (AppiumBy) AppiumBy.accessibilityId("drag-l2");
    AppiumBy fourthDrop = (AppiumBy) AppiumBy.accessibilityId("drop-l2");
    AppiumBy fifthDrag = (AppiumBy) AppiumBy.accessibilityId("drag-c2");
    AppiumBy fifthDrop = (AppiumBy) AppiumBy.accessibilityId("drop-c2");
    AppiumBy sixthDrag = (AppiumBy) AppiumBy.accessibilityId("drag-r2");
    AppiumBy sixthDrop = (AppiumBy) AppiumBy.accessibilityId("drop-r2");
    AppiumBy seventhDrag = (AppiumBy) AppiumBy.accessibilityId("drag-l3");
    AppiumBy seventhDrop = (AppiumBy) AppiumBy.accessibilityId("drop-l3");
    AppiumBy eighthDrag = (AppiumBy) AppiumBy.accessibilityId("drag-c3");
    AppiumBy eighthDrop = (AppiumBy) AppiumBy.accessibilityId("drop-c3");
    AppiumBy ninthDrag = (AppiumBy) AppiumBy.accessibilityId("drag-r3");
    AppiumBy ninthDrop = (AppiumBy) AppiumBy.accessibilityId("drop-r3");

    public dragAndDropPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public dragAndDropPage dragAndDrop(){
        bot.waitFor(firstDrag);
        bot.dragAndDrop(firstDrag,firstDrop);
        bot.dragAndDrop(secondDrag,secondDrop);
        bot.dragAndDrop(thirdDrag,thirdDrop);
        bot.dragAndDrop(fourthDrag,fourthDrop);
        bot.dragAndDrop(fifthDrag,fifthDrop);
        bot.dragAndDrop(sixthDrag,sixthDrop);
        bot.dragAndDrop(seventhDrag,seventhDrop);
        bot.dragAndDrop(eighthDrag,eighthDrop);
        bot.dragAndDrop(ninthDrag,ninthDrop);
        return this;
    }
}
