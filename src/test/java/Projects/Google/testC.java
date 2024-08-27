package Projects.Google;
import Projects.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testC extends testBase {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualMessage = loginPage.
                loginWithValidUsernameAndPassword().
                prove();

                 //Do assertion
        Assert.assertEquals(actualMessage,"PRODUCTS");

    }

    @Test
    public void emptyUsernameTest() {
                 LoginPage loginPage=new LoginPage(driver,bot,wait);
                 String actualMessage =loginPage
                         .loginWithEmptyUsername();

                 //Do assertion
                 Assert.assertEquals(actualMessage,"Username is required");

    }
    @Test
    public void emptyPasswordTest() {
                 LoginPage loginPage=new LoginPage(driver,bot,wait);
                 String actualMessage =loginPage
                         .loginWithEmptyPassword();

                 //Do assertion
                 Assert.assertEquals(actualMessage,"Password is required");

    }
    @Test
    public void invalidUsernameOrPasswordTest() {
        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String errorMessage = loginPage.
                loginWithInvalidUsernameOrPassword();

        //Do assertion
        Assert.assertEquals(errorMessage,"Username and password do not match any user in this service.");
    }
    @Test
    public void scrollDownTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualText= loginPage.
                loginWithValidUsernameAndPassword()
                .prove();

        //Do assertion
        Assert.assertEquals(actualText,"PRODUCTS");
    }
    @Test
    public void addToCartTest(){
        LoginPage loginPage =new LoginPage(driver,bot,wait);
        String actualText =loginPage.
                loginWithValidUsernameAndPassword()
                .SelectTheItem()
                .ScrollDown()
                .Cart()
                .clickOnCheckout()
                .fillInformation()
                .getTheTextAfterInformation();

        //Do assertion
        Assert.assertEquals(actualText,"CHECKOUT: OVERVIEW");
    }
    @Test
    public void emptyFirsName(){
        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualText=loginPage.
                loginWithValidUsernameAndPassword()
                .SelectTheItem()
                .ScrollDown()
                .Cart()
                .clickOnCheckout()
                .fillInformationWithOutFirstName();


        Assert.assertEquals(actualText,"First Name is required");
    }
    @Test
    public void emptyLastName(){
        LoginPage loginPage= new LoginPage(driver,bot,wait);
        String actualText =loginPage.
                loginWithValidUsernameAndPassword()
                .SelectTheItem()
                .ScrollDown()
                .Cart()
                .clickOnCheckout()
                .fillInformationWithOutLastName();

        Assert.assertEquals(actualText,"Last Name is required");
    }
    @Test
    public void ذemptyPostalCode(){
        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualText = loginPage.
                loginWithValidUsernameAndPassword()
                .SelectTheItem()
                .ScrollDown()
                .Cart()
                .clickOnCheckout()
                .fillInformationWithOutZipCode();

        Assert.assertEquals(actualText,"Postal Code is required");
    }
    @Test
    public void filtering() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver,bot,wait);
        String actualText =loginPage.
                loginWithValidUsernameAndPassword()
                .clickOnFilterButton()
                .filterByHighPriceAndGetTheText();

        Assert.assertEquals(actualText,"$49.99");
    }


    @Test
    public void GEOLOCATION(){
        LoginPage loginPage =new LoginPage(driver,bot,wait);
                loginPage.
                        loginWithValidUsernameAndPassword()
                        .clickOnMenu()
                        .ClickOnGEO()
                        .accept();
    }
}

//android.widget.TextView[@text="FINISH"]

