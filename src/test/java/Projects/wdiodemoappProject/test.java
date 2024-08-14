package Projects.wdiodemoappProject;
import Projects.testBase;
import Projects.wdiodemoappPages.homePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class test extends testBase{

    @Test
    public void test() throws InterruptedException {

        homePage homePage = new homePage(driver, bot, wait);
        homePage.clickOnWebViewOption().scrollDown();
    }

    @Test
    public void loginTest() throws InterruptedException {

        homePage homePage = new homePage(driver, bot, wait);
        homePage.clickOnLoginOption();
    }

    @Test
    public void signUpTest() throws InterruptedException {
        homePage homePage = new homePage(driver, bot, wait);
        String actualText = homePage.
                                     clickOnLoginOption().
                                     clickOnSignupOption().
                                     fillSignupInformation().
                                     signUp();

        Assert.assertEquals(actualText,"You successfully signed up!");
    }

    @Test
    public void swipeTest() throws InterruptedException, IOException {
        homePage homePage = new homePage(driver, bot, wait);
        homePage.clickOnSwipeButton().swipe().takeScreenshotOfSpecificElement();
    }

    @Test
    public void dragAndDropTest(){
        homePage homePage = new homePage(driver, bot, wait);
        homePage.clickOnDragAndDropPage().dragAndDrop();
    }

}
