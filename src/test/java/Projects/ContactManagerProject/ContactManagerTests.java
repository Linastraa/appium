package Projects.ContactManagerProject;
import Projects.ContactManagerPages.firstPage;
import Projects.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactManagerTests extends testBase{
    @Test
    public void test() throws InterruptedException {

        firstPage firstPage = new firstPage(driver,bot,wait);
        String actualText = firstPage.
                                      clickOnContinue().
                                      clickOnOk().
                                      clickOnAddContact().
                                      clickOnTargetAccount().
                                      editingContactName().
                                      editingPhone().
                                      editingPhoneType().
                                      editingMail().
                                      editingMailType().
                                      clickOnSave().
                                      veryify();

        Assert.assertEquals(actualText,"Contact Manager");
    }
}
