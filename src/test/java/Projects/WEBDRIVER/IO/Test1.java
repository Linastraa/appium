package Projects.WEBDRIVER.IO;

import Projects.WEBDRIVER.IO.pages.HomePage;
import Projects.testBase;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test1 extends testBase {
    @Test(priority = 1)
    @Step("Test cases 001")
    public void proof(){
        HomePage homePage =new HomePage(driver,bot,wait);
        homePage.proof();
//        String actualTest =homePage
//                .proof();


//        Assert.assertEquals(actualTest,"WEBDRIVER");
    }
    @Step("Test cases 002")
    @Test(priority = 2)
    public void WatchYouTube() throws InterruptedException {
        HomePage homePage = new HomePage(driver, bot, wait);
        homePage
                .ClickToWebview()
                .ScrollDown()
                .scrollIntoView()
                .ClickToYouTubeButton();
    }


    @Test
    public void Login(){
        HomePage homePage =new HomePage(driver,bot,wait);
        String actualTest=homePage.
                ClickToLogin()
                .Login();

        Assert.assertEquals(actualTest,"You are logged in!");
    }

    @Test
    public void SignUp(){
        HomePage homePage =new HomePage(driver,bot,wait);
        String actualTest=homePage.
                ClickToLogin()
                .SignUp();

        Assert.assertEquals(actualTest,"You successfully signed up!");
    }

    @Test
    public void FillTheForm(){
        HomePage homePage =new HomePage(driver,bot,wait);
        homePage.
                ClickToForms()
                .fillTheForm();

    }
    @Test
    public void Swipe() throws InterruptedException {
        HomePage homePage =new HomePage(driver,bot,wait);
        homePage.
                ClickToSwipe()
                .LeftToRight()
                .RightToLeft();

    }

    @Test
    public void DragAndDrop() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver, bot, wait);
        homePage.
                ClickToDrag()
                .drag();
        ;
    }

}
