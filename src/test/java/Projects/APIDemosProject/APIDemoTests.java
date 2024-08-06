package Projects.APIDemosProject;
import Projects.APIDemosPages.HomePage;
import Projects.testBase;
import org.testng.annotations.Test;

public class APIDemoTests extends testBase{

    @Test
    public void validLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver,bot,wait);
        homePage.clickOnText().clickOnKeyEventText();
    }
}
