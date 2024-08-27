package stepDefinition;

import Projects.ActionsBot;
import Projects.PageBase;

import Projects.testBase;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class StepDefinitions  {
    public WebDriver driver;
    public Wait<WebDriver> wait;
    public static Logger logger;

    @Step("Initializing test data and properties")
    @BeforeSuite
    public static void beforeClass() {
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(testBase.class.getName());
    }

    public StepDefinitions(Wait<WebDriver> wait) {
        this.wait = wait;
    }

    @Step("Initializing phone app")
    @BeforeMethod
    public void beforeMethod() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("8.1");
        options.setAutomationName("UIAutomator2");
        options.setDeviceName("emulator-5554");
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setNoReset(false);


        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4725/"), options);

        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));



    }

    @Given("click login")
    public void clickLogin() {
    }

    @Step("Terminating the phone")
    @AfterMethod
    public void tearDown(){
//        logger.info("Quitting phone");
        driver.quit();
    }

    @When("sa")
    public void sa() {
        System.out.println("sa");
    }

    @Then("the")
    public void the() {
        System.out.println("the");

    }
}