package Projects;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class testBase {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    public static Logger logger;
    public ActionsBot bot;

    @Step("Initializing test data and properties")
    @BeforeSuite
    public static void beforeClass() {
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(testBase.class.getName());
    }

    @Step("Initializing phone app")
    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Emulator");
        options.setAppPackage("io.selendroid.testapp");
        options.setAppActivity("io.selendroid.testapp.HomeScreenActivity");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        bot = new ActionsBot(driver, wait, logger);

    }

    @Step("Terminating the phone")
    @AfterMethod
    public void tearDown(){
        logger.info("Quitting phone");
        driver.quit();
    }
}
