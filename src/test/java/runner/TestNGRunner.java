package runner;

import java.io.File;

import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty" ,"html:target/cucumber-reports.html"},
        monochrome = true
)

public class TestNGRunner {


    }

