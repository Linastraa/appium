package Projects.SauceLabsProject;

import Projects.SauceLabsPages.LoginPage;
import Projects.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SauceLabsTests extends testBase {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualMessage = loginPage.
                                        loginWithValidUsernameAndPassword().
                                        prove();

        Assert.assertEquals(actualMessage,"PRODUCTS");
    }

    @Test
    public void emptyUsernameTest() {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String errorMessage = loginPage.
                                        loginWithEmptyUsername();

        Assert.assertEquals(errorMessage,"Username is required");
    }

    @Test
    public void emptyPasswordTest() {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String errorMessage = loginPage.
                                        loginWithEmptyPassword();

        Assert.assertEquals(errorMessage,"Password is required");
    }

    @Test
    public void invalidUsernameOrPasswordTest() {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String errorMessage = loginPage.
                                        loginWithInvalidUsernameOrPassword();

        Assert.assertEquals(errorMessage,"Username and password do not match any user in this service.");
    }

    @Test
    public void scrollDownTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualText= loginPage.
                                    loginWithValidUsernameAndPassword().
                                    clickOnAnItem().
                                    scrollDownSelenium().
                                    clickOnButton().
                                    clickOnCart().
                                    getTheText();

        Assert.assertEquals(actualText,"YOUR CART");
    }

    @Test
    public void scrollDown1Test() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        loginPage.
                loginWithValidUsernameAndPassword().
                scrollDown();

        //Assert.assertEquals(actualText,"YOUR CART");
    }

    @Test
    public void addToCartTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualText= loginPage.
                                    loginWithValidUsernameAndPassword().
                                    clickOnAnItem().
                                    scrollDown().
                                    clickOnButton().
                                    clickOnCart().
                                    clickOnCheckout().
                                    fillOutInformation().
                                    getTheTextAfterInformation();

        Assert.assertEquals(actualText,"CHECKOUT: OVERVIEW");
    }

    @Test
    public void emptyFirstNameTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualText= loginPage.
                                    loginWithValidUsernameAndPassword().
                                    clickOnAnItem().
                                    scrollDown().
                                    clickOnButton().
                                    clickOnCart().
                                    clickOnCheckout().
                                    leaveFirstNameEmpty();

        Assert.assertEquals(actualText,"First Name is required");
    }

    @Test
    public void emptyLastNameTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualText= loginPage.
                                    loginWithValidUsernameAndPassword().
                                    clickOnAnItem().
                                    scrollDown().
                                    clickOnButton().
                                    clickOnCart().
                                    clickOnCheckout().
                                    leaveLastNameEmpty();

        Assert.assertEquals(actualText,"Last Name is required");
    }

    @Test
    public void emptyZipCodeTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualText= loginPage.
                                    loginWithValidUsernameAndPassword().
                                    clickOnAnItem().
                                    scrollDown().
                                    clickOnButton().
                                    clickOnCart().
                                    clickOnCheckout().
                                    leaveZipCodeEmpty();

        Assert.assertEquals(actualText,"Postal Code is required");
    }

    @Test
    public void filteringTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver,bot,wait);
        String actualText= loginPage.
                                    loginWithValidUsernameAndPassword().
                                    clickOnFilterButton().
                                    filterByHighPriceAndGetTheText();

        Assert.assertEquals(actualText,"$49.99");
    }

    @Test
    public void geoTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver,bot,wait);
        loginPage.
                loginWithValidUsernameAndPassword().
                clickOnMenu().
                clickOnGEO().
                accept();
    }

    @Test
    public void fullScreenShotTest() throws IOException {
        LoginPage loginPage = new LoginPage(driver,bot,wait);
        loginPage.
                  loginWithValidUsernameAndPassword().
                  screenShotIt();
    }

    @Test
    public void geo2Test() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver,bot,wait);
        loginPage.
                loginWithValidUsernameAndPassword().
                clickOnMenu().
                clickOnGEO().
                accept2();
    }
}
