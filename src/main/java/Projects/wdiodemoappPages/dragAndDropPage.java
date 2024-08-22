package Projects.wdiodemoappPages;

import Projects.ActionsBot;
import Projects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class dragAndDropPage extends PageBase {

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

    public dragAndDropPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver, bot, wait);
    }

    public dragAndDropPage dragAndDrop() throws InterruptedException {
        bot.waitFor(proofOfPage);
        bot.dragAndDrop(firstDrag,firstDrop);
        bot.dragAndDrop(secondDrag,secondDrop);
        bot.dragAndDrop(thirdDrag,thirdDrop);
        bot.dragAndDrop(fourthDrag,fourthDrop);
        bot.dragAndDrop(fifthDrag,fifthDrop);
        bot.dragAndDrop(sixthDrag,sixthDrop);
        bot.dragAndDrop(seventhDrag,seventhDrop);
        bot.dragAndDrop(eighthDrag,eighthDrop);
        bot.dragAndDrop(ninthDrag,ninthDrop);
        Thread.sleep(5000);
        return this;
    }
}
