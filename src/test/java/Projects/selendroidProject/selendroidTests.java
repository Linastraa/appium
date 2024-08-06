package Projects.selendroidProject;

import Projects.selendroidPages.firstPage;
import Projects.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class selendroidTests extends testBase {

    @Test
    public void test(){

        firstPage firstPage = new firstPage(driver,bot,wait);
        String actualText = firstPage.
                                      clickOnContinue().
                                      clickOnOk().
                                      clickOnGoogle().
                                      editName().
                                      chooseTheCar().
                                      clickOnSend().
                                      getTheWelcome();

        Assert.assertEquals(actualText,"This is my way of saying hello");
    }

    @Test
    public void registeringUserTest() throws InterruptedException {

        firstPage firstPage = new firstPage(driver,bot,wait);
        String actualText = firstPage.
                                      clickOnContinue().
                                      clickOnOk().
                                      clickOnProgressBar().
                                      editUserName().
                                      editEmail().
                                      editPassword().
                                      editName().
                                      selectLanguage().
                                      agreeOnAd().
                                      registerAUser().
                                      verify();

        Assert.assertEquals(actualText,"Verify user");
    }
}
